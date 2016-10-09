package com.genscript.gsscm.rules.quoteorder.fact;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.rules.core.BaseFact;

@SuppressWarnings("serial")
public class QuoteOrderItemFact extends BaseFact {

	private Integer quoteOrderItemId;
	private Integer itemNo;

	// 归属的Quote或者Order的编号
	private Integer quoteOrderNo;

	// 产品物料编号
	private String catalogNo;
	// 分类编号
	private int clsId;

	// Item类型，形如：PRODUCT,SERVICE
	private String type;

	private String name;

	private String taxStatus;
	private String itemStatus;

	private Integer shipSchedule;
	
	//创建日期
	private Date creationDate;
	
	//CC日期
	private Date confirmDate;

	// 生产周期
	private Integer schdlProdCmpltDays;
	
	// item自身的生产周期天数，而预计生产完成天数字段schdl_prod_cmplt_days含义为根据上下文得出的最终预计生产完成天数
	private Integer timeline;

	// Item的产品属性，质量，重量等
	private Integer quantity;
	private String qtyUom;
	private Double size;
	private String sizeUom;
	private Double domShipWeight;
	private Double intlShipWeight;

	// Item单价，成本
	private BigDecimal unitPrice;
	private BigDecimal agentUnitPrice;
	private BigDecimal calculatedPrice;
	private BigDecimal basePrice;
	private BigDecimal cost;

	private String tbdFlag;
	private String dfcltSeqFlag;

	// 价格
	private BigDecimal amount;
	private BigDecimal baseAmount;
	private BigDecimal itemAmount;
	private BigDecimal agentAmount;

	// 税
	private BigDecimal tax;
	private BigDecimal baseTax;
	private BigDecimal agentTax;

	// 折扣
	private String prodGiftFlag;
	private Integer promotionId;
	private BigDecimal discount;
	private BigDecimal baseDiscount;
	private BigDecimal agentDiscount;

	// 发货，发票地址
	private Integer billtoAddrId;
	private Integer shiptoAddrId;
	private Integer soldtoAddrId;

	// 发货方式
	private String shippable;
	private Integer shipMethod;
	private Integer preShipMethod;
	private String shippingRoute;
	private Integer shippingImmediately;

	private String parentId;
	private String preParentId;

	// 仓库
	private Integer warehouseId;
	private Integer storageId;

	private String currencyCode;

	private String virusSeqFlag;
	private String prmtGiftFlag;
	private String iqrFlag;
	private String nonStandardFlag;

	// 温度
	private Double temperature;// shipping pack（）时候用。
	private Double storageTemperature;

	private BigDecimal transferPriceP;
	private BigDecimal transferPriceS;
	private BigDecimal minimumPrice;

	// 订单时间管控项目 - 抗体 含有特殊Catalog No则返回SPC，没有特殊的Catalog No但是含有抗体服务则返回ANTI
	private String containAntibodyType;

	// 是否为定制化产品，Y/N
	private String customizedFlag;
	private String customizedStorageTemp;
	private String customizedShipTemp;
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Integer getQuoteOrderItemId() {
		return quoteOrderItemId;
	}

	public void setQuoteOrderItemId(Integer quoteOrderItemId) {
		this.quoteOrderItemId = quoteOrderItemId;
	}

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public Integer getQuoteOrderNo() {
		return quoteOrderNo;
	}

	public void setQuoteOrderNo(Integer quoteOrderNo) {
		this.quoteOrderNo = quoteOrderNo;
	}

	public String getCatalogNo() {
		return catalogNo;
	}

	public void setCatalogNo(String catalogNo) {
		this.catalogNo = catalogNo;
	}

	public int getClsId() {
		return clsId;
	}

	public void setClsId(int clsId) {
		this.clsId = clsId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Integer getShipSchedule() {
		return shipSchedule;
	}

	public void setShipSchedule(Integer shipSchedule) {
		this.shipSchedule = shipSchedule;
	}

	public Integer getSchdlProdCmpltDays() {
		return schdlProdCmpltDays;
	}

	public void setSchdlProdCmpltDays(Integer schdlProdCmpltDays) {
		this.schdlProdCmpltDays = schdlProdCmpltDays;
	}

	public Integer getTimeline() {
		return timeline;
	}

	public void setTimeline(Integer timeline) {
		this.timeline = timeline;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getQtyUom() {
		return qtyUom;
	}

	public void setQtyUom(String qtyUom) {
		this.qtyUom = qtyUom;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public String getSizeUom() {
		return sizeUom;
	}

	public void setSizeUom(String sizeUom) {
		this.sizeUom = sizeUom;
	}

	public Double getDomShipWeight() {
		return domShipWeight;
	}

	public void setDomShipWeight(Double domShipWeight) {
		this.domShipWeight = domShipWeight;
	}

	public Double getIntlShipWeight() {
		return intlShipWeight;
	}

	public void setIntlShipWeight(Double intlShipWeight) {
		this.intlShipWeight = intlShipWeight;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getAgentUnitPrice() {
		return agentUnitPrice;
	}

	public void setAgentUnitPrice(BigDecimal agentUnitPrice) {
		this.agentUnitPrice = agentUnitPrice;
	}

	public BigDecimal getCalculatedPrice() {
		return calculatedPrice;
	}

	public void setCalculatedPrice(BigDecimal calculatedPrice) {
		this.calculatedPrice = calculatedPrice;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getTbdFlag() {
		return tbdFlag;
	}

	public void setTbdFlag(String tbdFlag) {
		this.tbdFlag = tbdFlag;
	}

	public String getDfcltSeqFlag() {
		return dfcltSeqFlag;
	}

	public void setDfcltSeqFlag(String dfcltSeqFlag) {
		this.dfcltSeqFlag = dfcltSeqFlag;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(BigDecimal baseAmount) {
		this.baseAmount = baseAmount;
	}

	public BigDecimal getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(BigDecimal itemAmount) {
		this.itemAmount = itemAmount;
	}

	public BigDecimal getAgentAmount() {
		return agentAmount;
	}

	public void setAgentAmount(BigDecimal agentAmount) {
		this.agentAmount = agentAmount;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getBaseTax() {
		return baseTax;
	}

	public void setBaseTax(BigDecimal baseTax) {
		this.baseTax = baseTax;
	}

	public BigDecimal getAgentTax() {
		return agentTax;
	}

	public void setAgentTax(BigDecimal agentTax) {
		this.agentTax = agentTax;
	}

	public String getProdGiftFlag() {
		return prodGiftFlag;
	}

	public void setProdGiftFlag(String prodGiftFlag) {
		this.prodGiftFlag = prodGiftFlag;
	}

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getBaseDiscount() {
		return baseDiscount;
	}

	public void setBaseDiscount(BigDecimal baseDiscount) {
		this.baseDiscount = baseDiscount;
	}

	public BigDecimal getAgentDiscount() {
		return agentDiscount;
	}

	public void setAgentDiscount(BigDecimal agentDiscount) {
		this.agentDiscount = agentDiscount;
	}

	public Integer getBilltoAddrId() {
		return billtoAddrId;
	}

	public void setBilltoAddrId(Integer billtoAddrId) {
		this.billtoAddrId = billtoAddrId;
	}

	public Integer getShiptoAddrId() {
		return shiptoAddrId;
	}

	public void setShiptoAddrId(Integer shiptoAddrId) {
		this.shiptoAddrId = shiptoAddrId;
	}

	public Integer getSoldtoAddrId() {
		return soldtoAddrId;
	}

	public void setSoldtoAddrId(Integer soldtoAddrId) {
		this.soldtoAddrId = soldtoAddrId;
	}

	public String getShippable() {
		return shippable;
	}

	public void setShippable(String shippable) {
		this.shippable = shippable;
	}

	public Integer getShipMethod() {
		return shipMethod;
	}

	public void setShipMethod(Integer shipMethod) {
		this.shipMethod = shipMethod;
	}

	public Integer getPreShipMethod() {
		return preShipMethod;
	}

	public void setPreShipMethod(Integer preShipMethod) {
		this.preShipMethod = preShipMethod;
	}

	public String getShippingRoute() {
		return shippingRoute;
	}

	public void setShippingRoute(String shippingRoute) {
		this.shippingRoute = shippingRoute;
	}

	public Integer getShippingImmediately() {
		return shippingImmediately;
	}

	public void setShippingImmediately(Integer shippingImmediately) {
		this.shippingImmediately = shippingImmediately;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getPreParentId() {
		return preParentId;
	}

	public void setPreParentId(String preParentId) {
		this.preParentId = preParentId;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getStorageId() {
		return storageId;
	}

	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getVirusSeqFlag() {
		return virusSeqFlag;
	}

	public void setVirusSeqFlag(String virusSeqFlag) {
		this.virusSeqFlag = virusSeqFlag;
	}

	public String getPrmtGiftFlag() {
		return prmtGiftFlag;
	}

	public void setPrmtGiftFlag(String prmtGiftFlag) {
		this.prmtGiftFlag = prmtGiftFlag;
	}

	public String getIqrFlag() {
		return iqrFlag;
	}

	public void setIqrFlag(String iqrFlag) {
		this.iqrFlag = iqrFlag;
	}

	public String getNonStandardFlag() {
		return nonStandardFlag;
	}

	public void setNonStandardFlag(String nonStandardFlag) {
		this.nonStandardFlag = nonStandardFlag;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getStorageTemperature() {
		return storageTemperature;
	}

	public void setStorageTemperature(Double storageTemperature) {
		this.storageTemperature = storageTemperature;
	}

	public BigDecimal getTransferPriceP() {
		return transferPriceP;
	}

	public void setTransferPriceP(BigDecimal transferPriceP) {
		this.transferPriceP = transferPriceP;
	}

	public BigDecimal getTransferPriceS() {
		return transferPriceS;
	}

	public void setTransferPriceS(BigDecimal transferPriceS) {
		this.transferPriceS = transferPriceS;
	}

	public BigDecimal getMinimumPrice() {
		return minimumPrice;
	}

	public void setMinimumPrice(BigDecimal minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	public String getContainAntibodyType() {
		return containAntibodyType;
	}

	public void setContainAntibodyType(String containAntibodyType) {
		this.containAntibodyType = containAntibodyType;
	}

	public String getCustomizedFlag() {
		return customizedFlag;
	}

	public void setCustomizedFlag(String customizedFlag) {
		this.customizedFlag = customizedFlag;
	}

	public String getCustomizedStorageTemp() {
		return customizedStorageTemp;
	}

	public void setCustomizedStorageTemp(String customizedStorageTemp) {
		this.customizedStorageTemp = customizedStorageTemp;
	}

	public String getCustomizedShipTemp() {
		return customizedShipTemp;
	}

	public void setCustomizedShipTemp(String customizedShipTemp) {
		this.customizedShipTemp = customizedShipTemp;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

}
