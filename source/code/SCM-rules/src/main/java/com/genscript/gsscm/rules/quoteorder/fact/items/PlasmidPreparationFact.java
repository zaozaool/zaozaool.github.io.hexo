/**
 * 
 */
package com.genscript.gsscm.rules.quoteorder.fact.items;

import com.genscript.gsscm.rules.quoteorder.fact.ItemDetailFact;

/**
 * Plasmid Preparation Fact
 * @author duanjunwei
 *
 */
@SuppressWarnings("serial")
public class PlasmidPreparationFact extends ItemDetailFact {

    //同Catalog的Item数量
    private Integer sameCatalogNoNums;

    private Double prepWeight;

    private String prepWtUom;

    private String qualityGrade;

    private String additionalAnalysis;

    private String copyNumber;

    public Integer getSameCatalogNoNums() {
        return sameCatalogNoNums;
    }

    public void setSameCatalogNoNums(Integer sameCatalogNoNums) {
        this.sameCatalogNoNums = sameCatalogNoNums;
    }

    public Double getPrepWeight() {
        return prepWeight;
    }

    public void setPrepWeight(Double prepWeight) {
        this.prepWeight = prepWeight;
    }

    public String getPrepWtUom() {
        return prepWtUom;
    }

    public void setPrepWtUom(String prepWtUom) {
        this.prepWtUom = prepWtUom;
    }

    public String getQualityGrade() {
        return qualityGrade;
    }

    public void setQualityGrade(String qualityGrade) {
        this.qualityGrade = qualityGrade;
    }

    public String getAdditionalAnalysis() {
        return additionalAnalysis;
    }

    public void setAdditionalAnalysis(String additionalAnalysis) {
        this.additionalAnalysis = additionalAnalysis;
    }

    public String getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }

}
