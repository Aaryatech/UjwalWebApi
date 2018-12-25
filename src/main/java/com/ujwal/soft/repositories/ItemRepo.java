package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.BillDetails;
import com.ujwal.soft.models.ItemBean;

public interface ItemRepo extends JpaRepository<ItemBean, Integer>{
	@Query(value = "select d.bill_detail_id, d.part_id, p.part_name,t.hsn_code,t.cgst_per,t.sgst_per,t.igst_per,\r\n" + 
			"h.cust_id, c.cust_name, h.bill_date, sum(d.qty) as qty,sum(cgst_amt) as cgst,sum(sgst_amt) as sgst, \r\n" + 
			"sum(igst_amt) as igst,sum(taxable_amt) as taxable_amt,sum(total_tax)as total_tax, sum(d.grand_total) as grand_total\r\n" + 
			"from bill_header h ,bill_details d, m_part p, m_customer c,m_tax t WHERE h.bill_date BETWEEN :fromDate AND :toDate \r\n" + 
			"AND d.part_id=p.part_id AND h.bill_header_id=d.bill_header_id AND h.cust_id IN(itemId) AND h.cust_id=c.cust_id \r\n" + 
			"and t.tax_id=p.part_tax_id GROUP BY h.bill_date, d.part_id",nativeQuery=true)
	
	public List<ItemBean> getItemByDateAndId(@Param("itemId") int itemId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	


	@Query(value = "select d.bill_detail_id, d.part_id, p.part_name,t.hsn_code,t.cgst_per,t.sgst_per,t.igst_per,\r\n" + 
			"h.cust_id, c.cust_name, h.bill_date, sum(d.qty) as qty,sum(cgst_amt) as cgst,sum(sgst_amt) as sgst, \r\n" + 
			"sum(igst_amt) as igst,sum(taxable_amt) as taxable_amt,sum(total_tax)as total_tax, sum(d.grand_total) as grand_total\r\n" + 
			"from bill_header h ,bill_details d, m_part p, m_customer c,m_tax t WHERE h.bill_date BETWEEN :fromDate AND :toDate \r\n" + 
			"AND d.part_id=p.part_id AND h.bill_header_id=d.bill_header_id AND h.cust_id=c.cust_id \r\n" + 
			"and t.tax_id=p.part_tax_id GROUP BY h.bill_date, d.part_id",nativeQuery=true)
	public List<ItemBean> getItemByDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
}
/*select d.bill_detail_id, d.part_id, p.part_name,t.hsn_code,t.cgst_per,t.sgst_per,t.igst_per,
h.cust_id, c.cust_name, h.bill_date, sum(d.qty) as qty,sum(cgst_amt) as cgst,sum(sgst_amt) as sgst, 
sum(igst_amt) as igst,sum(taxable_amt) as taxable_amt,sum(total_tax)as total_tax, sum(d.grand_total) as grand_total
from bill_header h ,bill_details d, m_part p, m_customer c,m_tax t WHERE h.bill_date BETWEEN '2018-12-01' AND '2018-12-21' 
AND d.part_id=p.part_id AND h.bill_header_id=d.bill_header_id AND h.cust_id IN(9) AND h.cust_id=c.cust_id 
and t.tax_id=p.part_tax_id GROUP BY h.bill_date, d.part_id*/