/**
 * 
 */
package com.genscript.gsscm.rules.quoteorder.fact.items;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

/**
 * RNA服务Fact
 * @author duanjunwei
 *
 */
@SuppressWarnings("serial")
public class RnaFact extends ItemDetailFact {

    //序列长度
    private Integer seqLength;

    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
    }

}
