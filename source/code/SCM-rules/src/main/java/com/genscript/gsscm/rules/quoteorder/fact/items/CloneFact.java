package com.genscript.gsscm.rules.quoteorder.fact.items;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

/**
 * clone价格计算fact
 */
public class CloneFact extends ItemDetailFact {

    private static final long serialVersionUID = -7393321074671138105L;

    private Integer seqLength;

    private String vectorArkFlag;

    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
    }

    public String getVectorArkFlag() {
        return vectorArkFlag;
    }

    public void setVectorArkFlag(String vectorArkFlag) {
        this.vectorArkFlag = vectorArkFlag;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
