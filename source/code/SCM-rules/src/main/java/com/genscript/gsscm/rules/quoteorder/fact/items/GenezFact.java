package com.genscript.gsscm.rules.quoteorder.fact.items;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

/**
 * genez价格计算fact
 */
public class GenezFact extends ItemDetailFact {

    private static final long serialVersionUID = 2731514803255312768L;

    private Integer seqLength;

    private Double fixedListingPrice;

    private Double fixedTransferPriceS;

    private Double fixedTransferPriceP;

    private Double fixedMinimumPrice;

    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
    }

    public Double getFixedListingPrice() {
        return fixedListingPrice;
    }

    public void setFixedListingPrice(Double fixedListingPrice) {
        this.fixedListingPrice = fixedListingPrice;
    }

    public Double getFixedTransferPriceS() {
        return fixedTransferPriceS;
    }

    public void setFixedTransferPriceS(Double fixedTransferPriceS) {
        this.fixedTransferPriceS = fixedTransferPriceS;
    }

    public Double getFixedTransferPriceP() {
        return fixedTransferPriceP;
    }

    public void setFixedTransferPriceP(Double fixedTransferPriceP) {
        this.fixedTransferPriceP = fixedTransferPriceP;
    }

    public Double getFixedMinimumPrice() {
        return fixedMinimumPrice;
    }

    public void setFixedMinimumPrice(Double fixedMinimumPrice) {
        this.fixedMinimumPrice = fixedMinimumPrice;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
