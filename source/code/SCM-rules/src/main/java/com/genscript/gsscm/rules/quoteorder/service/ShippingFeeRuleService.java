package com.genscript.gsscm.rules.quoteorder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.genscript.gsscm.rules.core.RuleExecuteResult;
import com.genscript.gsscm.rules.core.RuleRepository;
import com.genscript.gsscm.rules.core.VerKieSession;
import com.genscript.gsscm.rules.core.utils.RulesContextHolder;
import com.genscript.gsscm.rules.quoteorder.fact.PackageFact;
import com.genscript.gsscm.rules.quoteorder.fact.QuoteOrderFact;

/**
 * Shipping Fee计算服务实现类
 * 
 * @author duanjunwei
 *
 */
@Service
@Transactional
public class ShippingFeeRuleService {

	private final static Logger logger = LoggerFactory.getLogger(ShippingFeeRuleService.class);

	/**
	 * 计算Shipping Fee方法
	 * 
	 */
	public String calShippingFee(QuoteOrderFact shippingFeeFact) {
		if (shippingFeeFact == null) {
			return RuleExecuteResult.FAILED;
		}
		
		logger.debug("Before Caculating shipping fee by rule, fact object:{}", shippingFeeFact);
		long beginTime = System.currentTimeMillis();

		// 通过KSession ID 获取Drools对应版本的Kie Session
		VerKieSession kieSession = RulesContextHolder.getKieSession("shippingfee_ksession", RuleRepository.QUOTEORDER,
				shippingFeeFact.getRuleVersion());

		try {
			kieSession.insert(shippingFeeFact);
			kieSession.setGlobal("logger", logger);
			kieSession.fireAllRules();


			logger.info("Caculating shipping fee has been finished, cost:{}, fact object:{}",
					System.currentTimeMillis() - beginTime, shippingFeeFact);

		} catch (Throwable e) {
			logger.error("An exception occured in Caculating shipping fee.", e);
			return RuleExecuteResult.FAILED;
		}

		return RuleExecuteResult.SUCCESS;
	}

	/**
	 * 计算Package的Shipping Fee
	 * 
	 * @param packageFact
	 * @return
	 */
	public String calPackageCustomerCharge(PackageFact packageFact) {
		if (packageFact == null) {
			return RuleExecuteResult.FAILED;
		}

		logger.debug("Before Caculating packaging customer charge by rule, fact object:{}", packageFact);
		long beginTime = System.currentTimeMillis();

		// 通过KSession ID 获取Drools对应版本的Kie Session
		VerKieSession kieSession = RulesContextHolder.getKieSession("packagingfee_ksession", RuleRepository.QUOTEORDER,
				packageFact.getRuleVersion());

		try {
			kieSession.insert(packageFact);
			kieSession.setGlobal("logger", logger);

			kieSession.fireAllRules();


			logger.info("Caculating packaging customer charge has been finished, cost:{}, fact object:{}",
					System.currentTimeMillis() - beginTime, packageFact);
		} catch (Throwable e) {
			logger.error("An exception occured in Caculating Packaging customer charge.", e);
			return RuleExecuteResult.FAILED;
		}

		return RuleExecuteResult.SUCCESS;
	}

}
