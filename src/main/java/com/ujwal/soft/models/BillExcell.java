package com.ujwal.soft.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BillExcell {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private int billHeaderId;
	//private int billDetailId;
	private String invoiceNo;
	private Date billDate;
	private String custName;
	private String modelName;
	private float taxableAmt;
	private float cgstPer;
	private float sgstPer;
	private float igstPer;
	private float cgstAmt;
	private float sgstAmt;
	private float totalTax;
	private float invoiceAmt;
	private String gstNo;
	private String address;
	private String phone;
	
	
	public String getGstNo() {
		return gstNo;
	}




	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}




	public String getaddress() {
		return address;
	}




	public void setaddress(String address) {
		this.address = address;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public int getBillHeaderId() {
		return billHeaderId;
	}




	public void setBillHeaderId(int billHeaderId) {
		this.billHeaderId = billHeaderId;
	}




	/*
	 * public int getBillDetailId() { return billDetailId; }
	 * 
	 * 
	 * 
	 * 
	 * public void setBillDetailId(int billDetailId) { this.billDetailId =
	 * billDetailId; }
	 */




	
	public Date getBillDate() {
		return billDate;
	}


	public String getInvoiceNo() {
		return invoiceNo;
	}




	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}




	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}


	public String getCustName() {
		return custName;
	}




	public void setCustName(String custName) {
		this.custName = custName;
	}




	public String getModelName() {
		return modelName;
	}




	public void setModelName(String modelName) {
		this.modelName = modelName;
	}




	public float getTaxableAmt() {
		return taxableAmt;
	}




	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}




	public float getCgstPer() {
		return cgstPer;
	}




	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}




	public float getSgstPer() {
		return sgstPer;
	}




	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}




	public float getIgstPer() {
		return igstPer;
	}




	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}




	public float getCgstAmt() {
		return cgstAmt;
	}




	public void setCgstAmt(float cgstAmt) {
		this.cgstAmt = cgstAmt;
	}




	public float getSgstAmt() {
		return sgstAmt;
	}




	public void setSgstAmt(float sgstAmt) {
		this.sgstAmt = sgstAmt;
	}




	public float getTotalTax() {
		return totalTax;
	}




	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}




	public float getInvoiceAmt() {
		return invoiceAmt;
	}




	public void setInvoiceAmt(float invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}




	@Override
	public String toString() {
		return "BillExcell [id=" + id + ", billHeaderId=" + billHeaderId + ", invoiceNo=" + invoiceNo + ", billDate="
				+ billDate + ", custName=" + custName + ", modelName=" + modelName + ", taxableAmt=" + taxableAmt
				+ ", cgstPer=" + cgstPer + ", sgstPer=" + sgstPer + ", igstPer=" + igstPer + ", cgstAmt=" + cgstAmt
				+ ", sgstAmt=" + sgstAmt + ", totalTax=" + totalTax + ", invoiceAmt=" + invoiceAmt + ", gstNo=" + gstNo
				+ ", Address=" + address + ", phone=" + phone + "]";
	}




	

	
	
}
