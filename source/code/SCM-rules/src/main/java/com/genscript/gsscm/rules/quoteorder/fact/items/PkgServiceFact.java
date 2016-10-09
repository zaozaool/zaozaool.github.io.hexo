/**
 * 
 */
package com.genscript.gsscm.rules.quoteorder.fact.items;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

/**
 * Package Service的fact对象
 * @author duanjunwei
 *
 */
@SuppressWarnings("serial")
public class PkgServiceFact extends ItemDetailFact {

    private String name;

    private String expressionVolume;

    private String quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpressionVolume() {
        return expressionVolume;
    }

    public void setExpressionVolume(String expressionVolume) {
        this.expressionVolume = expressionVolume;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
