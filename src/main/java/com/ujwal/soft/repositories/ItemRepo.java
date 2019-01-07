package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.BillDetails;
import com.ujwal.soft.models.ItemBean;

public interface ItemRepo extends JpaRepository<ItemBean, Integer>{
	@Query(value = "select d.bill_detail_id,d.bill_header_id, d.part_id, p.part_name,t.hsn_code,t.cgst_per,t.sgst_per,t.igst_per,\r\n" + 
		
			"h.cust_id, c.cust_name, h.bill_date, h.tax_per, sum(d.qty) as qty,sum(d.cgst_rs) as cgst,sum(d.sgst_rs) as sgst,h.invoice_no, \r\n" + 
			
			"sum(d.igst_rs) as igst, sum(d.taxable_amount) as taxable_amount, sum(d.total_tax)as total_tax, sum(d.grand_total) as grand_total\r\n" + 
			
			"FROM bill_header h ,bill_details d, m_part p, m_customer c,m_tax t \r\n"+
			
			"WHERE d.part_id = :itemId AND d.bill_header_id=h.bill_header_id AND d.part_id=p.part_id AND h.bill_date BETWEEN :fromDate AND :toDate \r\n" + 
			
			"AND h.cust_id=c.cust_id AND p.part_tax_id=t.tax_id GROUP BY h.bill_date, d.part_id",nativeQuery=true)  
	
	public List<ItemBean> getItemByDateAndId(@Param("itemId") int itemId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	


	@Query(value = "select d.bill_detail_id, d.bill_header_id, d.part_id, p.part_name,t.hsn_code,t.cgst_per,t.sgst_per,t.igst_per,\r\n" + 
			
			"h.cust_id, c.cust_name, h.bill_date, h.tax_per, sum(d.qty) as qty,sum(d.cgst_rs) as cgst,sum(d.sgst_rs) as sgst, h.invoice_no,\r\n" + 
			
			"sum(d.igst_rs) as igst, sum(d.taxable_amount) as taxable_amount, sum(d.total_tax)as total_tax, sum(d.grand_total) as grand_total\r\n" + 
			
			"FROM bill_header h ,bill_details d, m_part p, m_customer c,m_tax t \r\n"+
			
			"WHERE d.bill_header_id=h.bill_header_id AND d.part_id=p.part_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.cust_id=c.cust_id AND t.tax_id=p.part_tax_id GROUP BY h.bill_date, d.part_id",nativeQuery=true)
	
	public List<ItemBean> getItemByDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
}
