package com.genscript.gsscm.rules.point.fact;

import java.util.Date;

import com.genscript.gsscm.rules.core.BaseFact;

@SuppressWarnings("serial")
public class PointFact extends BaseFact {

	// 加减点触发事件类型，比如新注册register，支付payment，退款等
	private String actionType;

	// 客户编号，等级，区域信息
	private Integer custNo;
	private String city;
	private String state;
	private String country;
	private Integer orgId;
	private Integer divisionId;
	private Integer deptId;
	private String custType; // 客户类型
	private String priorityLvl; // 客户级别
	private Date creationDate; // 注册时间
	private Integer vipFlag; // 是否VIP，对JP有效

	// 订单信息
	private Integer orderNo;
	private Date orderDate; // 下单时间
	private Date customerConfirmDate;// 客户CC时间
	private Integer salesTerritory;// 销售区域
	private Double amount; // 订单付款加点或退款减点的金额

	// 积分兑换信息
	private Integer exchangeUnitPoints; // 兑换一单位礼品所需点数
	private Integer exchangeQuantity; // 兑换礼品数量
	private String redeemType; // 兑换礼品类型
	private String exchangeRewardNo; // 礼品的NO
	private String exchangeRewardName; // 兑换礼品名称

	// 规则引擎返回给业务模块的信息
	private Integer points; // 加减的点数，负值为减点
	private String comments; // 加减点的备注信息

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public Integer getCustNo() {
		return custNo;
	}

	public void setCustNo(Integer custNo) {
		this.custNo = custNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getPriorityLvl() {
		return priorityLvl;
	}

	public void setPriorityLvl(String priorityLvl) {
		this.priorityLvl = priorityLvl;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getVipFlag() {
		return vipFlag;
	}

	public void setVipFlag(Integer vipFlag) {
		this.vipFlag = vipFlag;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getCustomerConfirmDate() {
		return customerConfirmDate;
	}

	public void setCustomerConfirmDate(Date customerConfirmDate) {
		this.customerConfirmDate = customerConfirmDate;
	}

	public Integer getSalesTerritory() {
		return salesTerritory;
	}

	public void setSalesTerritory(Integer salesTerritory) {
		this.salesTerritory = salesTerritory;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getExchangeUnitPoints() {
		return exchangeUnitPoints;
	}

	public void setExchangeUnitPoints(Integer exchangeUnitPoints) {
		this.exchangeUnitPoints = exchangeUnitPoints;
	}

	public Integer getExchangeQuantity() {
		return exchangeQuantity;
	}

	public void setExchangeQuantity(Integer exchangeQuantity) {
		this.exchangeQuantity = exchangeQuantity;
	}

	public String getRedeemType() {
		return redeemType;
	}

	public void setRedeemType(String redeemType) {
		this.redeemType = redeemType;
	}

	public String getExchangeRewardNo() {
		return exchangeRewardNo;
	}

	public void setExchangeRewardNo(String exchangeRewardNo) {
		this.exchangeRewardNo = exchangeRewardNo;
	}

	public String getExchangeRewardName() {
		return exchangeRewardName;
	}

	public void setExchangeRewardName(String exchangeRewardName) {
		this.exchangeRewardName = exchangeRewardName;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
