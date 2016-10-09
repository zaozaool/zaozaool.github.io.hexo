package com.genscript.gsscm.rules.quoteorder.fact.items;

import java.util.List;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

public class PeptideFact extends ItemDetailFact {

    private static final long serialVersionUID = 7193466099123859506L;

    //纯度
    private String purity;

    //序列内容
    private String sequence;

    //序列长度
    private Integer seqLength;

    //数量
    private Integer quantity;

    //修饰列表，一个多肽Item可以有多个修饰，NTTerminal和CTerminal也是一种特殊的修饰会加入到该列表中
    private List<String> modifications;

    private String NTerminal;

    private String CTerminal;

    //二硫键
    private String disulfideBridge;

    //修饰需要花费的生产周期
    private Integer modificationDays;

    public String getPurity() {
        return purity;
    }

    public void setPurity(String purity) {
        this.purity = purity;
    }

    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<String> getModifications() {
        return modifications;
    }

    public void setModifications(List<String> modifications) {
        this.modifications = modifications;
    }

    public Integer getModificationDays() {
        return modificationDays;
    }

    public void setModificationDays(Integer modificationDays) {
        this.modificationDays = modificationDays;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getNTerminal() {
        return NTerminal;
    }

    public void setNTerminal(String nTerminal) {
        NTerminal = nTerminal;
    }

    public String getCTerminal() {
        return CTerminal;
    }

    public void setCTerminal(String cTerminal) {
        CTerminal = cTerminal;
    }

    public String getDisulfideBridge() {
        return disulfideBridge;
    }

    public void setDisulfideBridge(String disulfideBridge) {
        this.disulfideBridge = disulfideBridge;
    }

}
