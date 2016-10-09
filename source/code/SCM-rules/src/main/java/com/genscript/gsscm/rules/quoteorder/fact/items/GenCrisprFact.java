/**
 * 
 */
package com.genscript.gsscm.rules.quoteorder.fact.items;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

/**
 * Gen Crispr
 * @author duanjunwei
 *
 */
@SuppressWarnings("serial")
public class GenCrisprFact extends ItemDetailFact {

    private Integer seqLength;

    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
    }

}
