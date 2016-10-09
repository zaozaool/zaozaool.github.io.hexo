/**
 * 
 */
package com.genscript.gsscm.rules.quoteorder.fact;

import com.genscript.gsscm.rules.core.BaseFact;

/**
 * 结对的Fact组合，一部分规则计算场景，会同时判断两个Fact的计算结果，或者取其并集，或者求和，或者取最大值等
 * 规范此类场景的调用，避免使用ArrayList导致代码可读性下降，添加此对象
 * @author duanjunwei
 *
 */
public class PairingFacts {

    //主Fact
    private ItemDetailFact primary;

    //从Fact
    private ItemDetailFact secondary;

    public ItemDetailFact getPrimary() {
        return primary;
    }

    public void setPrimary(ItemDetailFact primary) {
        this.primary = primary;
    }

    public ItemDetailFact getSecondary() {
        return secondary;
    }

    public void setSecondary(ItemDetailFact secondary) {
        this.secondary = secondary;
    }

}
