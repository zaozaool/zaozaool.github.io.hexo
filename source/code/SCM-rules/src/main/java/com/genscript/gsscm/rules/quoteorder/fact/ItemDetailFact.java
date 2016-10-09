package com.genscript.gsscm.rules.quoteorder.fact;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.rules.core.BaseFact;

/**
 * 用于price\timeline计算的fact
 */
public class ItemDetailFact extends BaseFact {

    private static final long serialVersionUID = -480781503555275968L;

    // 计算对应的quote或order NO
    private String srcNo;

    // Quote或者Order No
    private String quoteOrderNo;

    private Integer quoteOrderItemId;

    //所属Quote/Order的Item数量
    private Integer itemNums;

    //父Item的信息
    private String parentItemCatalogNo;

    private String parentItemId;

    private Integer itemNo;

    private String catalogNo;

    private Integer clsId;

    //客户信息
    private String custLocation;

    //==== 01. 价格计算逻辑变量定义
    private String baseCurrency;

    private Double basePrice;

    private String tpCurrency;

    private Double transferPriceS;

    private Double transferPriceP;

    private Double minimumPrice;

    //==== 02.难度与标准定义  
    private Integer difficultFlag; //1为难度，0为非难度

    private Integer nonStandardFlag; //1为非标准，0为标准

    // Y为vip，针对日本订单系统
    private String vipFlag;

    //==== 03.生产周期计算变量定义
    private Integer leadTime; //服务的交货周期值，在物料里面维护的值

    private Integer parentItemTimeline;

    private Integer parentItemScheduleDays;

    private Integer timeline;

    private Date targetDate;

    private Integer scheduleDays;//deadline

    public Integer getDifficultFlag() {
        return difficultFlag;
    }

    public void setDifficultFlag(Integer difficultFlag) {
        this.difficultFlag = difficultFlag;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Double getTransferPriceS() {
        return transferPriceS;
    }

    public void setTransferPriceS(Double transferPriceS) {
        this.transferPriceS = transferPriceS;
    }

    public Double getTransferPriceP() {
        return transferPriceP;
    }

    public void setTransferPriceP(Double transferPriceP) {
        this.transferPriceP = transferPriceP;
    }

    public String getCatalogNo() {
        return catalogNo;
    }

    public void setCatalogNo(String catalogNo) {
        this.catalogNo = catalogNo;
    }

    public String getTpCurrency() {
        return tpCurrency;
    }

    public void setTpCurrency(String tpCurrency) {
        this.tpCurrency = tpCurrency;
    }

    public String getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(String vipFlag) {
        this.vipFlag = vipFlag;
    }

    public String getSrcNo() {
        return srcNo;
    }

    public void setSrcNo(String srcNo) {
        this.srcNo = srcNo;
    }

    public String getQuoteOrderNo() {
        return quoteOrderNo;
    }

    public void setQuoteOrderNo(String quoteOrderNo) {
        this.quoteOrderNo = quoteOrderNo;
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

    public Double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Integer getTimeline() {
        return timeline;
    }

    public void setTimeline(Integer timeline) {
        this.timeline = timeline;
    }

    public Integer getNonStandardFlag() {
        return nonStandardFlag;
    }

    public void setNonStandardFlag(Integer nonStandardFlag) {
        this.nonStandardFlag = nonStandardFlag;
    }

    public Integer getClsId() {
        return clsId;
    }

    public void setClsId(Integer clsId) {
        this.clsId = clsId;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Integer getScheduleDays() {
        return scheduleDays;
    }

    public void setScheduleDays(Integer scheduleDays) {
        this.scheduleDays = scheduleDays;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public String getParentItemCatalogNo() {
        return parentItemCatalogNo;
    }

    public void setParentItemCatalogNo(String parentItemCatalogNo) {
        this.parentItemCatalogNo = parentItemCatalogNo;
    }

    public Integer getParentItemTimeline() {
        return parentItemTimeline;
    }

    public void setParentItemTimeline(Integer parentItemTimeline) {
        this.parentItemTimeline = parentItemTimeline;
    }

    public String getCustLocation() {
        return custLocation;
    }

    public void setCustLocation(String custLocation) {
        this.custLocation = custLocation;
    }

    public String getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }

    public Integer getItemNums() {
        return itemNums;
    }

    public void setItemNums(Integer itemNums) {
        this.itemNums = itemNums;
    }

    public Integer getParentItemScheduleDays() {
        return parentItemScheduleDays;
    }

    public void setParentItemScheduleDays(Integer parentItemScheduleDays) {
        this.parentItemScheduleDays = parentItemScheduleDays;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
