package com.ujwal.soft.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MonthlyReport {
	
	@Id
	private float totaTax;
	private float taxableAmt;
	private float grandTotal;
	public float getTotaTax() {
		return totaTax;
	}
	public void setTotaTax(float totaTax) {
		this.totaTax = totaTax;
	}
	public float getTaxableAmt() {
		return taxableAmt;
	}
	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}
	public float getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
	@Override
	public String toString() {
		return "MonthlyReport [totaTax=" + totaTax + ", taxableAmt=" + taxableAmt + ", grandTotal=" + grandTotal + "]";
	}
	
	
}
