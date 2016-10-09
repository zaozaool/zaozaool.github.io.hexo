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
import com.genscript.gsscm.rules.quoteorder.fact.promotion.AgentDiscountFact;

/**
 * Jp Agent discount获取类
 * 
 * @author caopeng
 *
 */
@Service
@Transactional
public class PromotionRuleService {

    private static final Logger logger = LoggerFactory.getLogger(PromotionRuleService.class);

    /**
     * 获取当前item对应的agent discount
     * 
     */
    public String getAgentDiscount(AgentDiscountFact agentDiscountFact) {
        if (agentDiscountFact == null) {
            return RuleExecuteResult.FAILED;
        }
        logger.info("Begin exec rule agent discount decition table for " + agentDiscountFact.getQuoteOrderNo() + "-" + agentDiscountFact.getItemNo());

        VerKieSession kieSession = RulesContextHolder.getKieSession("promotion_ksession", RuleRepository.QUOTEORDER, agentDiscountFact.getRuleVersion());
        kieSession.insert(agentDiscountFact);

        kieSession.fireAllRules();

        logger.info("End exec rule agent discount decition table for " + agentDiscountFact.getQuoteOrderNo() + "-" + agentDiscountFact.getItemNo());
        return RuleExecuteResult.SUCCESS;
    }

}
