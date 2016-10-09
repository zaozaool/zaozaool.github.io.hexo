package com.genscript.gsscm.rules.quoteorder.fact.promotion;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.rules.core.BaseFact;

/**
 * 用于日本代理商折扣计算的fact
 */
public class AgentDiscountFact extends BaseFact {

    private static final long serialVersionUID = -1454324445013299774L;

    private String vipFlag;

    private String catalogNo;

    private Double agentDiscount;

    // Quote或者Order No
    private String quoteOrderNo;

    private Integer itemNo;

    public String getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(String vipFlag) {
        this.vipFlag = vipFlag;
    }

    public String getCatalogNo() {
        return catalogNo;
    }

    public void setCatalogNo(String catalogNo) {
        this.catalogNo = catalogNo;
    }

    public Double getAgentDiscount() {
        return agentDiscount;
    }

    public void setAgentDiscount(Double agentDiscount) {
        this.agentDiscount = agentDiscount;
    }

    public String getQuoteOrderNo() {
        return quoteOrderNo;
    }

    public void setQuoteOrderNo(String quoteOrderNo) {
        this.quoteOrderNo = quoteOrderNo;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
