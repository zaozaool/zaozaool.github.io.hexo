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
import com.genscript.gsscm.rules.quoteorder.fact.items.CloneFact;
import com.genscript.gsscm.rules.quoteorder.fact.items.CrisprRnpFact;
import com.genscript.gsscm.rules.quoteorder.fact.items.GeneFact;
import com.genscript.gsscm.rules.quoteorder.fact.items.GenezFact;

/**
 * item price计算服务实现类
 * 
 * @author jiangshengzao
 *
 */
@Service
@Transactional
public class PriceRuleService {

    private static final Logger logger = LoggerFactory.getLogger(PriceRuleService.class);

    /**
     * 计算gene价格方法
     * 
     */
    public String calGenePrice(GeneFact genePriceFact) {
        if (genePriceFact == null) {
            return RuleExecuteResult.FAILED;
        }
        logger.info("Begin exec rule gene price decition table for " + genePriceFact.getQuoteOrderNo() + "-" + genePriceFact.getItemNo());
        //logger.info("Begin Fact:" + genePriceFact.toString());
        if (genePriceFact.getSeqLength() == null) {
            genePriceFact.setMessage("seqLength can't be null.");
            return RuleExecuteResult.FAILED;
        }
        if (genePriceFact.getCloneReady() == null) {
            genePriceFact.setCloneReady(0);
        }
        if (!"Y".equals(genePriceFact.getVipFlag()) && !"N".equals(genePriceFact.getVipFlag())) {
            genePriceFact.setVipFlag("N");
        }

        VerKieSession kieSession = RulesContextHolder.getKieSession("itemprice_ksession", RuleRepository.QUOTEORDER, genePriceFact.getRuleVersion());
        kieSession.insert(genePriceFact);
        // kieSession.setGlobal("logger", logger);

        kieSession.fireAllRules();

        //logger.info("End Fact:" + genePriceFact.toString());
        logger.info("End exec rule gene price decition table for " + genePriceFact.getQuoteOrderNo() + "-" + genePriceFact.getItemNo());
        return RuleExecuteResult.SUCCESS;
    }

    /**
     * 计算CRISPR RNP方法
     *
     */
    public String calCrisprRnpPrice(CrisprRnpFact crisprRnpPriceFact) {
        if (crisprRnpPriceFact == null) {
            return RuleExecuteResult.FAILED;
        }
        logger.info("Begin exec rule CRISPR RNP price decition table for " + crisprRnpPriceFact.getQuoteOrderNo() + "-" + crisprRnpPriceFact.getItemNo());
        //logger.info("Begin Fact:" + genePriceFact.toString());

        VerKieSession kieSession = RulesContextHolder.getKieSession("itemprice_ksession", RuleRepository.QUOTEORDER, crisprRnpPriceFact.getRuleVersion());
        kieSession.insert(crisprRnpPriceFact);
        // kieSession.setGlobal("logger", logger);

        kieSession.fireAllRules();

        //logger.info("End Fact:" + genePriceFact.toString());
        logger.info("End exec rule CRISPR RNP price decition table for " + crisprRnpPriceFact.getQuoteOrderNo() + "-" + crisprRnpPriceFact.getItemNo());
        return RuleExecuteResult.SUCCESS;
    }

    /**
     * 计算Clone方法
     *
     */
    public String calClonePrice(CloneFact clonePriceFact) {
        if (clonePriceFact == null) {
            return RuleExecuteResult.FAILED;
        }
        logger.info("Begin exec rule Clone price decition table for " + clonePriceFact.getQuoteOrderNo() + "-" + clonePriceFact.getItemNo());
        //logger.info("Begin Fact:" + genePriceFact.toString());

        VerKieSession kieSession = RulesContextHolder.getKieSession("itemprice_ksession", RuleRepository.QUOTEORDER, clonePriceFact.getRuleVersion());
        kieSession.insert(clonePriceFact);
        // kieSession.setGlobal("logger", logger);

        kieSession.fireAllRules();

        //logger.info("End Fact:" + genePriceFact.toString());
        logger.info("End exec rule Clone price decition table for " + clonePriceFact.getQuoteOrderNo() + "-" + clonePriceFact.getItemNo());
        return RuleExecuteResult.SUCCESS;
    }

    /**
     * 计算genez价格方法
     * 
     */
    public String calGenezPrice(GenezFact genezFact) {
        if (genezFact == null) {
            return RuleExecuteResult.FAILED;
        }
        logger.info("Begin exec rule genez price decition table for " + genezFact.getQuoteOrderNo() + "-" + genezFact.getItemNo());
        //logger.info("Begin Fact:" + genePriceFact.toString());
        if (genezFact.getSeqLength() == null) {
            genezFact.setMessage("seqLength can't be null.");
            return RuleExecuteResult.FAILED;
        }
        if (!"Y".equals(genezFact.getVipFlag()) && !"N".equals(genezFact.getVipFlag())) {
            genezFact.setVipFlag("N");
        }

        VerKieSession kieSession = RulesContextHolder.getKieSession("itemprice_ksession", RuleRepository.QUOTEORDER, genezFact.getRuleVersion());
        kieSession.insert(genezFact);
        // kieSession.setGlobal("logger", logger);

        kieSession.fireAllRules();

        //logger.info("End Fact:" + genePriceFact.toString());
        logger.info("End exec rule genez price decition table for " + genezFact.getQuoteOrderNo() + "-" + genezFact.getItemNo());
        return RuleExecuteResult.SUCCESS;
    }

}
