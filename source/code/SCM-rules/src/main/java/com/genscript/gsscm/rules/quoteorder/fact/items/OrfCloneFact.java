package com.genscript.gsscm.rules.quoteorder.fact.items;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

public class OrfCloneFact extends ItemDetailFact {

    private static final long serialVersionUID = -3877160622133578630L;

    //分析级别
    private String syntheticLevel;

    //序列长度
    private Integer seqLength;

    private Integer stockFlag;

    public String getSyntheticLevel() {
        return syntheticLevel;
    }

    public void setSyntheticLevel(String syntheticLevel) {
        this.syntheticLevel = syntheticLevel;
    }

    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
    }

    public Integer getStockFlag() {
        return stockFlag;
    }

    public void setStockFlag(Integer stockFlag) {
        this.stockFlag = stockFlag;
    }

}
