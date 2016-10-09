/**
 * 
 */
package com.genscript.gsscm.rules.quoteorder.fact.items;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

/**
 * Cust Cloning的Fact对象
 * @author duanjunwei
 *
 */
@SuppressWarnings("serial")
public class CustCloningFact extends ItemDetailFact {

    //序列长度
    private Integer seqLength;
    
    //Pkg Service的相关属性
    private String pkgTargetType;

    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
    }

    public String getPkgTargetType() {
        return pkgTargetType;
    }

    public void setPkgTargetType(String pkgTargetType) {
        this.pkgTargetType = pkgTargetType;
    }

}
