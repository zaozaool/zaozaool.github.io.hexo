/**
 * 
 */
package com.genscript.gsscm.rules.quoteorder.fact;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.rules.core.BaseFact;

/**
 * 包裹Fact对象 对于Package层面的shipping fee计算，主要输出customer charge和handling fee信息。
 * 
 * @author duanjunwei
 *
 */
@SuppressWarnings("serial")
public class PackageFact extends BaseFact {

	// ------------ 1. Input Parameters --------------
	private Integer packageId;

	private int packageSeq;
	
	// Quote或者Order No
	private Integer quoteOrderNo;

	List<QuoteOrderItemFact> quoteOrderItemList;

	// Shipping Fee是否冻结
	private Boolean shippingFeeFreezed;
	private String shippingAccount;

	// 是否为内部订单或者内部Quote
	private Boolean isInternal;

	// pacakage info包裹信息
	private Double actualWeight;
	private Double billableWeight;
	private Integer totalQty;
	private Double size;

	// Package包装类型,Tube，Kit Box，Bottle等
	private String packageType;

	// 发货信息
	private String shipVia;
	private Double shipTemperature;//发货温度
	private Integer shipMethod; // 发货方式
	private String shipCarrier; // 承运方

	// 仓储信息
	private String zone;
	private Integer warehouseId;

	// Item分类描述Desc的价格Map，将一个订单中同类的Item组合成一个价格累加Map
	private Map<String, BigDecimal> itemDescPriceMap;
	
	//Item Type的列表，将每个Item的类型组织成一个list用于规则判断
	private List<String> itemTypeList;

	// 客户信息
	private String custLocation;// 客户归属地
	private Integer custNo;
	private String country;// 发货地

	// 汇率
	private Double exchRate;
	// USD to JP的汇率
	private Double usdToJPRate;

	// customized cost
	private Double customizedShippingFee;

	private Double fedexPrice;

	// ------------ 2. Temp Vars，临时计算变量 --------------

	// JP shipping fee的最大值，因为日本Shipping fee要走US逻辑，并比对，所以加此计算临时变量
	private Double jpBiggestShippingFee;

	// Shipping fee计算系数
	private Double shippingFeeMul = 1.0;

	// ------------ 3. Out Parameters --------------

	// 各种handling fee包裹的处理加工费
	private Double serviceHandlingFee = 0.0;
	private Double productHandlingFee = 0.0;

	private Double handlingFee = 0.0;
	private Double baseHandlingFee = 0.0;// 基于客户币种的包裹加工费

	private String specialHandlingFee; // 特殊处理费

	private Double eeiHandlingFee = 0.0;
	private Double baseEeiHandlingFee = 0.0;

	private Double regularHandlingFee = 0.0;// 常规handling fee
	private Double baseRegularHandlingFee = 0.0;

	private Double baseCharge = 0.0; // 减去HandlingFee后的 charge

	// 客户支付的Shipping fee
	private Double customerCharge = 0.0;// package层面的Shipping fee记录到customer
										// charge
	private Double baseCustomerCharge = 0.0;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public int getPackageSeq() {
		return packageSeq;
	}

	public void setPackageSeq(int packageSeq) {
		this.packageSeq = packageSeq;
	}

	public List<QuoteOrderItemFact> getQuoteOrderItemList() {
		return quoteOrderItemList;
	}

	public void setQuoteOrderItemList(List<QuoteOrderItemFact> quoteOrderItemList) {
		this.quoteOrderItemList = quoteOrderItemList;
	}
    
	public Boolean getShippingFeeFreezed() {
		return shippingFeeFreezed;
	}

	public void setShippingFeeFreezed(Boolean shippingFeeFreezed) {
		this.shippingFeeFreezed = shippingFeeFreezed;
	}

	public String getShippingAccount() {
		return shippingAccount;
	}

	public void setShippingAccount(String shippingAccount) {
		this.shippingAccount = shippingAccount;
	}

	public Double getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(Double actualWeight) {
		this.actualWeight = actualWeight;
	}

	public Double getBillableWeight() {
		return billableWeight;
	}

	public void setBillableWeight(Double billableWeight) {
		this.billableWeight = billableWeight;
	}

	public Integer getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getShipVia() {
		return shipVia;
	}

	public void setShipVia(String shipVia) {
		this.shipVia = shipVia;
	}

	public Integer getShipMethod() {
		return shipMethod;
	}

	public void setShipMethod(Integer shipMethod) {
		this.shipMethod = shipMethod;
	}

	public String getShipCarrier() {
		return shipCarrier;
	}

	public void setShipCarrier(String shipCarrier) {
		this.shipCarrier = shipCarrier;
	}

	public Double getShipTemperature() {
		return shipTemperature;
	}

	public void setShipTemperature(Double shipTemperature) {
		this.shipTemperature = shipTemperature;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Map<String, BigDecimal> getItemDescPriceMap() {
		return itemDescPriceMap;
	}

	public void setItemDescPriceMap(Map<String, BigDecimal> itemDescPriceMap) {
		this.itemDescPriceMap = itemDescPriceMap;
	}

	public String getCustLocation() {
		return custLocation;
	}

	public void setCustLocation(String custLocation) {
		this.custLocation = custLocation;
	}

	public Integer getCustNo() {
		return custNo;
	}

	public void setCustNo(Integer custNo) {
		this.custNo = custNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getCustomizedShippingFee() {
		return customizedShippingFee;
	}

	public void setCustomizedShippingFee(Double customizedShippingFee) {
		this.customizedShippingFee = customizedShippingFee;
	}

	public Double getFedexPrice() {
		return fedexPrice;
	}

	public void setFedexPrice(Double fedexPrice) {
		this.fedexPrice = fedexPrice;
	}

	public Double getJpBiggestShippingFee() {
		return jpBiggestShippingFee;
	}

	public void setJpBiggestShippingFee(Double jpBiggestShippingFee) {
		this.jpBiggestShippingFee = jpBiggestShippingFee;
	}

	public Double getServiceHandlingFee() {
		return serviceHandlingFee;
	}

	public void setServiceHandlingFee(Double serviceHandlingFee) {
		this.serviceHandlingFee = serviceHandlingFee;
	}

	public Double getProductHandlingFee() {
		return productHandlingFee;
	}

	public void setProductHandlingFee(Double productHandlingFee) {
		this.productHandlingFee = productHandlingFee;
	}

	public Double getHandlingFee() {
		return handlingFee;
	}

	public void setHandlingFee(Double handlingFee) {
		this.handlingFee = handlingFee;
	}

	public Double getBaseHandlingFee() {
		return baseHandlingFee;
	}

	public void setBaseHandlingFee(Double baseHandlingFee) {
		this.baseHandlingFee = baseHandlingFee;
	}

	public String getSpecialHandlingFee() {
		return specialHandlingFee;
	}

	public void setSpecialHandlingFee(String specialHandlingFee) {
		this.specialHandlingFee = specialHandlingFee;
	}

	public Double getRegularHandlingFee() {
		return regularHandlingFee;
	}

	public void setRegularHandlingFee(Double regularHandlingFee) {
		this.regularHandlingFee = regularHandlingFee;
	}

	public Double getBaseRegularHandlingFee() {
		return baseRegularHandlingFee;
	}

	public void setBaseRegularHandlingFee(Double baseRegularHandlingFee) {
		this.baseRegularHandlingFee = baseRegularHandlingFee;
	}

	public Double getCustomerCharge() {
		return customerCharge;
	}

	public void setCustomerCharge(Double customerCharge) {
		this.customerCharge = customerCharge;
	}

	public Double getBaseCustomerCharge() {
		return baseCustomerCharge;
	}

	public void setBaseCustomerCharge(Double baseCustomerCharge) {
		this.baseCustomerCharge = baseCustomerCharge;
	}

	public Boolean getIsInternal() {
		return isInternal;
	}

	public void setIsInternal(Boolean isInternal) {
		this.isInternal = isInternal;
	}

	public Double getShippingFeeMul() {
		return shippingFeeMul;
	}

	public void setShippingFeeMul(Double shippingFeeMul) {
		this.shippingFeeMul = shippingFeeMul;
	}

	public Double getExchRate() {
		return exchRate;
	}

	public void setExchRate(Double exchRate) {
		this.exchRate = exchRate;
	}

	public Double getBaseCharge() {
		return baseCharge;
	}

	public void setBaseCharge(Double baseCharge) {
		this.baseCharge = baseCharge;
	}

	public Double getUsdToJPRate() {
		return usdToJPRate;
	}

	public void setUsdToJPRate(Double usdToJPRate) {
		this.usdToJPRate = usdToJPRate;
	}

	public Double getEeiHandlingFee() {
		return eeiHandlingFee;
	}

	public void setEeiHandlingFee(Double eeiHandlingFee) {
		this.eeiHandlingFee = eeiHandlingFee;
	}

	public Double getBaseEeiHandlingFee() {
		return baseEeiHandlingFee;
	}

	public void setBaseEeiHandlingFee(Double baseEeiHandlingFee) {
		this.baseEeiHandlingFee = baseEeiHandlingFee;
	}

	public List<String> getItemTypeList() {
		return itemTypeList;
	}

	public void setItemTypeList(List<String> itemTypeList) {
		this.itemTypeList = itemTypeList;
	}

	public Integer getQuoteOrderNo() {
		return quoteOrderNo;
	}

	public void setQuoteOrderNo(Integer quoteOrderNo) {
		this.quoteOrderNo = quoteOrderNo;
	}

}
