package com.genscript.gsscm.rules.quoteorder.fact.items;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

/**
 * crispr rnp价格计算fact
 */
public class CrisprRnpFact extends ItemDetailFact {

    private static final long serialVersionUID = -5268005247283375591L;

    private String quantity;

    private Integer tube;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Integer getTube() {
        return tube;
    }

    public void setTube(Integer tube) {
        this.tube = tube;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
