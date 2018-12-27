package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ujwal.soft.models.CustReport;

public interface GetCustReportRepo extends JpaRepository<CustReport, Integer>{
	/*@Query(value = "select h.bill_header_id,\r\n" + 
			"h.bill_date,\r\n" + 
			"h.company_id,\r\n" + 
			"c.comp_name,\r\n" + 
			"h.cust_id,\r\n" + 
			"cust.cust_gstn,\r\n" + 
			"cust.cust_name,\r\n" + 
			"h.loc_id,\r\n" + 
			"l.location_name,\r\n" + 
			"h.disc_amt,\r\n" + 
			"h.igst_amt,\r\n" + 
			"h.sgst_amt,\r\n" + 
			"h.cgst_amt,\r\n" + 
			"h.tax_per,\r\n" + 
			"h.user_id,\r\n" + 
			"u.user_name,\r\n" + 
			"h.round_off,\r\n" + 
			"h.tota_tax,\r\n" + 
			"h.taxable_amt,\r\n" + 
			"h.grand_total\r\n" + 
			" from bill_header h,m_user u,m_location l,m_company c,m_customer cust where \r\n" + 
			"h.user_id=u.user_id and l.location_id=h.loc_id and c.comp_id=h.company_id and"
			+ " cust.cust_id=h.cust_id and h.del_status=0 and h.cust_id=:custId and"
			+ " h.bill_date  BETWEEN  :fromDate AND :toDate  \r\n" + 
			"\r\n" ,nativeQuery = true)*/
	
	@Query(value="SELECT h.bill_header_id, h.company_id, h.bill_date,h.cust_id, c.cust_name, c.cust_gstn, b.cgst_rs, b.sgst_rs, b.igst_rs, b.total_tax, b.taxable_amount, b.grand_total\r\n" + 
			"FROM bill_details b, bill_header h, m_customer c\r\n" + 
			"WHERE h.cust_id=:custId AND h.cust_id=c.cust_id AND h.bill_header_id=b.bill_header_id AND h.bill_date BETWEEN :fromDate AND :toDate",nativeQuery=true)
	List<CustReport> getCustBetweenDate(String fromDate, String toDate, int custId);

}
