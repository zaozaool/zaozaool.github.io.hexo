package com.genscript.gsscm.rules.core.utils;

import org.drools.compiler.kie.builder.impl.InternalKieContainer;
import org.drools.core.util.StringUtils;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.genscript.gsscm.common.util.SpringContextHolder;
import com.genscript.gsscm.rules.core.RuleRepository;
import com.genscript.gsscm.rules.core.VerKieSession;

/**
 * 规则引擎的Service/KSession获取实体工具类，支持按照规则版本获得对应的Session
 * 
 * @author duanjunwei
 *
 */
public class RulesContextHolder {

    /**
     * Get Session Bean From Remote Repository(Workbench) thru version no.
     * 
     * @param kSessionName
     * @param repository 规则仓库
     * @param version 规则版本
     * @return
     */
    public static VerKieSession getKieSession(String kSessionName, RuleRepository repository, String version) {
        if (StringUtils.isEmpty(version)) {
            version = "LATEST";
        }

        InternalKieContainer ikContainer = (InternalKieContainer) getKieContainer(repository.groupId(), repository.artifactId(), version);

        KieSession kSession = null;

        String realVersion = version;
        if ("LATEST".equals(realVersion)) {
            // 如果业务侧使用最新版本号，为了支持多版本调用，此处仍然需要返回实际的最新版本号，如1.7
            realVersion = ikContainer.getMainKieModule().getReleaseId().getVersion();

            //LATEST时从Spring上下文中已经初始化的Bean中直接取，不用new
            kSession = (KieSession)SpringContextHolder.getBean(kSessionName);
        } else {

            String kHisSessionName = kSession + "#" + realVersion;

            if (SpringContextHolder.containsSingleton(kHisSessionName)) {
                kSession = SpringContextHolder.getBean(kHisSessionName);
            } else {
                //从Container中new一个历史版本的ksession对象,并放入Spring容器管理
                kSession = ikContainer.newKieSession(kSessionName);

                SpringContextHolder.registerSingleton(kHisSessionName, kSession);
            }
        }

        VerKieSession verKSession = new VerKieSession(kSession, realVersion);

        return verKSession;
    }

    public static KieContainer getKieContainer(String groupId, String artifactId, String version) {
        KieServices kServices = KieServices.Factory.get();
        ReleaseId releaseId = kServices.newReleaseId(groupId, artifactId, version);

        KieContainer kContainer;
        String kContainerBeanName = groupId + "#" + artifactId + "#" + version;

        // Register singleton kContainer to Spring Context
        if (SpringContextHolder.containsSingleton(kContainerBeanName)) {
            kContainer = SpringContextHolder.getBean(kContainerBeanName);
        } else {
            // Create new kContainer
            kContainer = kServices.newKieContainer(releaseId);
            SpringContextHolder.registerSingleton(kContainerBeanName, kContainer);
        }

        return kContainer;
    }
}
