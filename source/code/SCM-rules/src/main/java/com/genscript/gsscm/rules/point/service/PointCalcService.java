package com.genscript.gsscm.rules.point.service;

import org.springframework.stereotype.Service;

import com.genscript.gsscm.rules.core.RuleExecuteResult;
import com.genscript.gsscm.rules.core.RuleRepository;
import com.genscript.gsscm.rules.core.VerKieSession;
import com.genscript.gsscm.rules.core.utils.RulesContextHolder;
import com.genscript.gsscm.rules.point.fact.PointFact;

/**
 * 点逻辑规则计算服务
 * @author duanjunwei
 *
 */
@Service
public class PointCalcService {

	/**
	 * 计算加减点Point
	 * @param pointFact
	 * @return
	 */
	public String calcPoint(PointFact pointFact){
		if (pointFact == null) {
			return RuleExecuteResult.FAILED;
		}

		VerKieSession kieSession = RulesContextHolder.getKieSession("point_ksession",
				RuleRepository.POINT, pointFact.getRuleVersion());
		kieSession.insert(pointFact);
		
		kieSession.fireAllRules();
		
		return RuleExecuteResult.SUCCESS;
	}
}
