package com.genscript.gsscm.rules.core;

/**
 * rules repository define.
 * 
 * @author duanjunwei
 *
 */
public enum RuleRepository {
	//订单，Quote相关规则库
	QUOTEORDER("com.genscript.gsscm.quoteorder", "quoteorder"), 
	
	//点、积分规则库
	POINT("com.genscript.gsscm.point", "point"), 
	
	//发货规则库
	SHIPPING("com.genscript.gsscm.shipping", "shipping");

	private final String groupId;
	private final String artifactId;

	RuleRepository(String groupId, String artifactId) {
		this.groupId = groupId;
		this.artifactId = artifactId;
	}

	public String groupId(){
		return this.groupId;
	}
	
	public String artifactId(){
		return this.artifactId;
	}
}
