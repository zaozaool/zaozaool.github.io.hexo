package com.genscript.gsscm.rules.quoteorder.fact.items;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

/**
 * gene价格计算fact
 */
public class GeneFact extends ItemDetailFact {

    private static final long serialVersionUID = 7946700100614302855L;

    private Double baseBpPrice;

    private Integer seqLength;

    // 1为clone ready
    private Integer cloneReady;

    // 针对日本订单系统可以有gene价格记忆功能
    private Double custGeneMemoBpPrice;

    // 针对日本订单系统可以有gene价格记忆功能
    private Double custGeneMemoMinPrice;

    // 针对日本订单系统可以有gene价格记忆功能
    private Double custGeneMemoFixedPrice;

    public Double getBaseBpPrice() {
        return baseBpPrice;
    }

    public void setBaseBpPrice(Double baseBpPrice) {
        this.baseBpPrice = baseBpPrice;
    }

    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
    }

    public Integer getCloneReady() {
        return cloneReady;
    }

    public void setCloneReady(Integer cloneReady) {
        this.cloneReady = cloneReady;
    }

    public Double getCustGeneMemoBpPrice() {
        return custGeneMemoBpPrice;
    }

    public void setCustGeneMemoBpPrice(Double custGeneMemoBpPrice) {
        this.custGeneMemoBpPrice = custGeneMemoBpPrice;
    }

    public Double getCustGeneMemoMinPrice() {
        return custGeneMemoMinPrice;
    }

    public void setCustGeneMemoMinPrice(Double custGeneMemoMinPrice) {
        this.custGeneMemoMinPrice = custGeneMemoMinPrice;
    }

    public Double getCustGeneMemoFixedPrice() {
        return custGeneMemoFixedPrice;
    }

    public void setCustGeneMemoFixedPrice(Double custGeneMemoFixedPrice) {
        this.custGeneMemoFixedPrice = custGeneMemoFixedPrice;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
