/**
 * 
 */
package com.genscript.gsscm.rules.quoteorder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.genscript.gsscm.rules.core.RuleExecuteResult;
import com.genscript.gsscm.rules.core.RuleRepository;
import com.genscript.gsscm.rules.core.VerKieSession;
import com.genscript.gsscm.rules.core.utils.RulesContextHolder;
import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;
import com.genscript.gsscm.rules.quoteorder.fact.PairingFacts;

/**
 * item timeline计算服务实现类
 * 
 * @author jiangshengzao
 *
 */
@Service
@Transactional
public class TimelineRuleService {

    private static final Logger logger = LoggerFactory.getLogger(TimelineRuleService.class);

    public String calTimeline(ItemDetailFact fact) {
        if (fact == null) {
            return RuleExecuteResult.FAILED;
        }

        logger.info("Begin exec rule calTimeline: " + fact.getQuoteOrderNo() + "-" + fact.getItemNo());

        VerKieSession kieSession = RulesContextHolder.getKieSession("itemtimeline_ksession", RuleRepository.QUOTEORDER, fact.getRuleVersion());
        kieSession.insert(fact);
        kieSession.setGlobal("logger", logger);

        kieSession.fireAllRules();

        logger.info("End exec rule calTimeline success: " + fact.getQuoteOrderNo() + "-" + fact.getItemNo() + " timeline:" + fact.getTimeline());
        return RuleExecuteResult.SUCCESS;
    }

    /**
     * 批量执行生产周期规则计算
     * @param factList
     * @return
     */
    public String calTimeline(PairingFacts facts) {
        //至少主Fact必须存在
        if (facts == null || facts.getPrimary() == null) {
            return RuleExecuteResult.FAILED;
        }

        logger.info("Begin batch exec rule calTimeline： paring facts.");

        //取第一个Item的rule version作为规则版本号
        VerKieSession kieSession = RulesContextHolder.getKieSession("itemtimeline_ksession", RuleRepository.QUOTEORDER, facts.getPrimary().getRuleVersion());
        kieSession.insert(facts.getPrimary());
        if (facts.getSecondary() != null) {
            //从Fact可以为空，将只计算主Fact的timeline
            kieSession.insert(facts.getSecondary());
        }

        kieSession.setGlobal("logger", logger);
        kieSession.fireAllRules();

        logger.info("End batch exec rule calTimeline success： paring facts.");

        return RuleExecuteResult.SUCCESS;
    }

}
