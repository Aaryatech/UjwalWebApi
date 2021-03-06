package com.ujwal.soft.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="m_model")
public class MModelBean {
	@Id
	private int modelId;
	private String modelName;
	private String modelNo;
	private String productionDate;
	private int delStatus;
	private int companyId;
	private int extraTax;
	
		
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
	public int getExtraTax() {
		return extraTax;
	}
	public void setExtraTax(int extraTax) {
		this.extraTax = extraTax;
	}
	@Override
	public String toString() {
		return "MModelBean [modelId=" + modelId + ", modelName=" + modelName + ", modelNo=" + modelNo
				+ ", productionDate=" + productionDate + ", delStatus=" + delStatus + ", companyId=" + companyId
				+ ", extraTax=" + extraTax + "]";
	}
		
}
