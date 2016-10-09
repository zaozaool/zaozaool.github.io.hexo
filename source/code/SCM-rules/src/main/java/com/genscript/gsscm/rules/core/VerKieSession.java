package com.genscript.gsscm.rules.core;

import java.util.Collection;
import java.util.Map;

import org.kie.api.KieBase;
import org.kie.api.command.Command;
import org.kie.api.event.process.ProcessEventListener;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.Globals;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.FactHandle;

/**
 * 带有真实规则版本号的KieSession，用于业务侧保存版本号时获取
 * 
 * @author duanjunwei
 *
 */
public class VerKieSession {

    // Drools Kie-Session
    private KieSession kieSession;

    // Rule Version
    private String ruleVersion;

    public VerKieSession(KieSession session, String ruleVersion) {
        this.kieSession = session;
        this.ruleVersion = ruleVersion;
    }

    public int fireAllRules() {
        return kieSession.fireAllRules();
    }

    public int fireAllRules(AgendaFilter agendaFilter) {
        return kieSession.fireAllRules(agendaFilter);
    }

    public <T> T execute(Command<T> command) {
        return kieSession.execute(command);
    }

    public void setGlobal(String identifier, Object value) {
        kieSession.setGlobal(identifier, value);
    }

    public Object getGlobal(String identifier) {
        return kieSession.getGlobal(identifier);
    }

    public Globals getGlobals() {
        return kieSession.getGlobals();
    }

    public KieBase getKieBase() {
        return kieSession.getKieBase();
    }

    public KieSessionConfiguration getSessionConfiguration() {
        return kieSession.getSessionConfiguration();
    }

    public FactHandle insert(Object object) {
        return kieSession.insert(object);
    }

    public void update(FactHandle handle, Object object) {
        kieSession.update(handle, object);
    }

    public long getFactCount() {
        return kieSession.getFactCount();
    }

    public ProcessInstance startProcess(String processId) {
        return kieSession.startProcess(processId);
    }

    public ProcessInstance startProcess(String processId, Map<String, Object> parameters) {
        return kieSession.startProcess(processId, parameters);
    }

    public ProcessInstance createProcessInstance(String processId, Map<String, Object> parameters) {
        return kieSession.createProcessInstance(processId, parameters);
    }

    public ProcessInstance startProcessInstance(long processInstanceId) {
        return kieSession.startProcessInstance(processInstanceId);
    }

    public Collection<ProcessInstance> getProcessInstances() {
        return kieSession.getProcessInstances();
    }

    public ProcessInstance getProcessInstance(long processInstanceId) {
        return kieSession.getProcessInstance(processInstanceId);
    }

    public ProcessInstance getProcessInstance(long processInstanceId, boolean readonly) {
        return kieSession.getProcessInstance(processInstanceId, readonly);
    }

    public void abortProcessInstance(long processInstanceId) {
        kieSession.abortProcessInstance(processInstanceId);
    }

    public WorkItemManager getWorkItemManager() {
        return kieSession.getWorkItemManager();
    }

    public KieRuntimeLogger getLogger() {
        return kieSession.getLogger();
    }

    public void addEventListener(RuleRuntimeEventListener listener) {
        kieSession.addEventListener(listener);
    }

    public void removeEventListener(RuleRuntimeEventListener listener) {
        kieSession.removeEventListener(listener);
    }

    public Collection<RuleRuntimeEventListener> getRuleRuntimeEventListeners() {
        return kieSession.getRuleRuntimeEventListeners();
    }

    public void addEventListener(AgendaEventListener listener) {
        kieSession.addEventListener(listener);
    }

    public void removeEventListener(AgendaEventListener listener) {
        kieSession.removeEventListener(listener);
    }

    public Collection<AgendaEventListener> getAgendaEventListeners() {
        return kieSession.getAgendaEventListeners();
    }

    public void addEventListener(ProcessEventListener listener) {
        kieSession.addEventListener(listener);
    }

    public void removeEventListener(ProcessEventListener listener) {
        kieSession.removeEventListener(listener);
    }

    public Collection<ProcessEventListener> getProcessEventListeners() {
        return kieSession.getProcessEventListeners();
    }

    public long getIdentifier() {
        return kieSession.getIdentifier();
    }

    public void dispose() {
        kieSession.dispose();
    }

    public void destroy() {
        kieSession.destroy();
    }

    public KieSession getKieSession() {
        return kieSession;
    }

    public void setKieSession(KieSession kieSession) {
        this.kieSession = kieSession;
    }

    public String getRuleVersion() {
        return ruleVersion;
    }

    public void setRuleVersion(String ruleVersion) {
        this.ruleVersion = ruleVersion;
    }

}
