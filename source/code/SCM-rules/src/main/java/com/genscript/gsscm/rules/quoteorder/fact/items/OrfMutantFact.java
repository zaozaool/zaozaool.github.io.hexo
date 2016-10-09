/**
 * 
 */
package com.genscript.gsscm.rules.quoteorder.fact.items;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

/**
 * @author duanjunwei
 *
 */
@SuppressWarnings("serial")
public class OrfMutantFact extends ItemDetailFact {

    private Integer mutationNo;

    
    public Integer getMutationNo() {
        return mutationNo;
    }

    
    public void setMutationNo(Integer mutationNo) {
        this.mutationNo = mutationNo;
    }
    
    
}
