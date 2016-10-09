package com.genscript.gsscm.rules.quoteorder.fact.items;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

public class MutagenesisFact extends ItemDetailFact {

    private static final long serialVersionUID = -1506931467484763577L;

    //序列长度
    private Integer variantSeqLength;

    //突变编号
    private Integer mutationNo;

    public Integer getVariantSeqLength() {
        return variantSeqLength;
    }

    public void setVariantSeqLength(Integer variantSeqLength) {
        this.variantSeqLength = variantSeqLength;
    }

    public Integer getMutationNo() {
        return mutationNo;
    }

    public void setMutationNo(Integer mutationNo) {
        this.mutationNo = mutationNo;
    }

}
