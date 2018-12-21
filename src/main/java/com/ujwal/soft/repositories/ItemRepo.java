package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.BillDetails;
import com.ujwal.soft.models.ItemBean;

public interface ItemRepo extends JpaRepository<ItemBean, Integer>{

	@Query(value = "SELECT part.part_id, part.part_name,part.part_tax_id, tax.hsn_code, sum(bill.cgst_rs) AS cgst_rs , sum(bill.sgst_rs) AS sgst_rs, sum(bill.igst_rs) AS igst_rs,bill.taxable_amount, billhead.bill_header_id\r\n" + 
			"FROM m_part part, bill_details bill, m_tax tax, bill_header billhead\r\n" + 
			"WHERE tax.tax_id=part.part_tax_id AND\r\n" + 
			"bill.bill_header_id= billhead.bill_header_id AND \r\n" + 
			"bill.part_id=part.part_id AND\r\n" + 
			" billhead.bill_date > :fromDate AND billhead.bill_date < :toDate AND\r\n" + 
			" bill.part_id=:itemId GROUP BY bill.part_id",nativeQuery=true)
	public List<ItemBean> getItemByDateAndId(@Param("itemId") int itemId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	


	@Query(value = "SELECT part.part_id, part.part_name,part.part_tax_id, tax.hsn_code, sum(bill.cgst_rs) AS cgst_rs , sum(bill.sgst_rs) AS sgst_rs, sum(bill.igst_rs) AS igst_rs,bill.taxable_amount, billhead.bill_header_id\r\n" + 
			"FROM m_part part, bill_details bill, m_tax tax, bill_header billhead\r\n" + 
			"WHERE tax.tax_id=part.part_tax_id AND\r\n" + 
			"bill.bill_header_id= billhead.bill_header_id AND \r\n" + 
			"bill.part_id=part.part_id AND\r\n" + 
			" billhead.bill_date >= :fromDate AND billhead.bill_date <= :toDate GROUP BY bill.part_id",nativeQuery=true)
	public List<ItemBean> getItemByDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
}
