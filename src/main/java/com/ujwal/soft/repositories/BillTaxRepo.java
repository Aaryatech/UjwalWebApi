package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ujwal.soft.models.TaxBillBean;

@Repository
public interface BillTaxRepo extends JpaRepository<TaxBillBean, Integer> {

	@Query(value = "SELECT bill.bill_detail_id, billhead.bill_header_id, billhead.company_id, billhead.cust_id, billhead.bill_date, cust.cust_name, bill.taxable_amount, billhead.tax_per,"
			+ "billhead.grand_total, cust.cust_gstn,bill.cgst_per, bill.sgst_per, bill.igst_per, sum(bill.taxable_amount) AS taxableAmount, bill.grand_total as billAmount \r\n" + 
			"FROM bill_details bill, bill_header billhead, m_customer cust\r\n" + 
			"WHERE billhead.company_id = :comp_id AND billhead.bill_date >= :fromDate AND billhead.bill_date <= :toDate AND bill.bill_header_id = billhead.bill_header_id AND cust.cust_id = billhead.cust_id\r\n" + 
			"group by bill.igst_per, billhead.bill_header_id",nativeQuery=true)
	
	public List<TaxBillBean> getBillTaxReportById(@Param("comp_id") int comp_id, @Param("fromDate") String froDate, @Param("toDate") String toDate);

	
	@Query(value = "SELECT bill.bill_detail_id, billhead.bill_header_id, billhead.company_id, billhead.cust_id, billhead.bill_date, cust.cust_name, bill.taxable_amount,bill.grand_total as billAmount, billhead.tax_per,"
			+ "billhead.grand_total, cust.cust_gstn, bill.cgst_per, bill.sgst_per, bill.igst_per, sum(bill.taxable_amount) AS taxableAmount \r\n" + 
			"FROM bill_details bill, bill_header billhead, m_customer cust\r\n" + 
			"WHERE billhead.bill_date >= :fromDate AND billhead.bill_date <= :toDate AND bill.bill_header_id = billhead.bill_header_id AND cust.cust_id = billhead.cust_id\r\n" + 
			"group by bill.igst_per, billhead.bill_header_id",nativeQuery=true)
	
	public List<TaxBillBean> getBillTaxReport(@Param("fromDate") String froDate, @Param("toDate") String toDate);



}
