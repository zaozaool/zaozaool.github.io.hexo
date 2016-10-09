/**
 * 
 */
package com.genscript.gsscm.rules.core;

import java.io.Serializable;

/**
 * 基础Fact定义，所有的Fact都继承自该类
 * 
 * @author duanjunwei
 *
 */
@SuppressWarnings("serial")
public class BaseFact implements Serializable {

	// 规则版本号
	private String ruleVersion;

	// 业务子系统标识，比如CN Order，US Order等
	private String system;

	// 规则引擎返回消息
	private String message;

	public String getRuleVersion() {
		return ruleVersion;
	}

	public void setRuleVersion(String ruleVersion) {
		this.ruleVersion = ruleVersion;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
