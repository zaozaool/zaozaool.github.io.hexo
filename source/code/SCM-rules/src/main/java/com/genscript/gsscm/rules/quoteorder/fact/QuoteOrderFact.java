/**
 * 
 */
package com.genscript.gsscm.rules.quoteorder.fact;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.rules.core.BaseFact;

/**
 * Shipping Fee的fact对象定义
 * 
 * @author duanjunwei
 *
 */
@SuppressWarnings("serial")
public class QuoteOrderFact extends BaseFact {

	// Quote或者Order No
	private Integer quoteOrderNo;

	// 包裹列表
	private List<PackageFact> packageList;

	// shipping info发货信息
	private Integer shipMethod;
	private String shippingAccount;

	// customer info客户信息
	private Integer custNo;
	private String custLocation;
	private Integer companyId;
	private Integer vipFlag;

	// special parameter info
	private Boolean shippingFeeFreezed;
	private Double customizedCost;

	// Promotion Info促销信息
	private String prmtShDiscType;
	private Double prmtShDiscount;

	// Special Handling Fee
	private String specialHandling;

	// 计算系数因子
	private String baseCurrency;// 基础币种，跟客户关联的
	private String quoteOrderCurrency;// 支付币种
	private Double exchRate;
	private Double usdToBaseCurrencyRate;

	// 输出Shipping Fee结果，用Double类型
	private Double baseHandlingFee = 0.0;
	private Double baseCustomerCharge = 0.0;
	private Double baseShipAmt = 0.0;
	private Double shipAmt = 0.0;
	private Double transferredSH = 0.0;

	private String shipAmtChanged;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Integer getQuoteOrderNo() {
		return quoteOrderNo;
	}

	public void setQuoteOrderNo(Integer quoteOrderNo) {
		this.quoteOrderNo = quoteOrderNo;
	}

	public List<PackageFact> getPackageList() {
		return packageList;
	}

	public void setPackageList(List<PackageFact> packageList) {
		this.packageList = packageList;
	}

	public Integer getShipMethod() {
		return shipMethod;
	}

	public void setShipMethod(Integer shipMethod) {
		this.shipMethod = shipMethod;
	}

	public String getShippingAccount() {
		return shippingAccount;
	}

	public void setShippingAccount(String shippingAccount) {
		this.shippingAccount = shippingAccount;
	}

	public Integer getCustNo() {
		return custNo;
	}

	public void setCustNo(Integer custNo) {
		this.custNo = custNo;
	}

	public String getCustLocation() {
		return custLocation;
	}

	public void setCustLocation(String custLocation) {
		this.custLocation = custLocation;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getVipFlag() {
		return vipFlag;
	}

	public void setVipFlag(Integer vipFlag) {
		this.vipFlag = vipFlag;
	}

	public Boolean getShippingFeeFreezed() {
		return shippingFeeFreezed;
	}

	public void setShippingFeeFreezed(Boolean shippingFeeFreezed) {
		this.shippingFeeFreezed = shippingFeeFreezed;
	}

	public Double getCustomizedCost() {
		return customizedCost;
	}

	public void setCustomizedCost(Double customizedCost) {
		this.customizedCost = customizedCost;
	}

	public String getPrmtShDiscType() {
		return prmtShDiscType;
	}

	public void setPrmtShDiscType(String prmtShDiscType) {
		this.prmtShDiscType = prmtShDiscType;
	}

	public Double getPrmtShDiscount() {
		return prmtShDiscount;
	}

	public void setPrmtShDiscount(Double prmtShDiscount) {
		this.prmtShDiscount = prmtShDiscount;
	}

	public String getSpecialHandling() {
		return specialHandling;
	}

	public void setSpecialHandling(String specialHandling) {
		this.specialHandling = specialHandling;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getQuoteOrderCurrency() {
		return quoteOrderCurrency;
	}

	public void setQuoteOrderCurrency(String quoteOrderCurrency) {
		this.quoteOrderCurrency = quoteOrderCurrency;
	}

	public Double getExchRate() {
		return exchRate;
	}

	public void setExchRate(Double exchRate) {
		this.exchRate = exchRate;
	}

	public Double getUsdToBaseCurrencyRate() {
		return usdToBaseCurrencyRate;
	}

	public void setUsdToBaseCurrencyRate(Double usdToBaseCurrencyRate) {
		this.usdToBaseCurrencyRate = usdToBaseCurrencyRate;
	}

	public Double getBaseHandlingFee() {
		return baseHandlingFee;
	}

	public void setBaseHandlingFee(Double baseHandlingFee) {
		this.baseHandlingFee = baseHandlingFee;
	}

	public Double getBaseCustomerCharge() {
		return baseCustomerCharge;
	}

	public void setBaseCustomerCharge(Double baseCustomerCharge) {
		this.baseCustomerCharge = baseCustomerCharge;
	}

	public Double getBaseShipAmt() {
		return baseShipAmt;
	}

	public void setBaseShipAmt(Double baseShipAmt) {
		this.baseShipAmt = baseShipAmt;
	}

	public Double getShipAmt() {
		return shipAmt;
	}

	public void setShipAmt(Double shipAmt) {
		this.shipAmt = shipAmt;
	}

	public Double getTransferredSH() {
		return transferredSH;
	}

	public void setTransferredSH(Double transferredSH) {
		this.transferredSH = transferredSH;
	}

	public String getShipAmtChanged() {
		return shipAmtChanged;
	}

	public void setShipAmtChanged(String shipAmtChanged) {
		this.shipAmtChanged = shipAmtChanged;
	}

}
