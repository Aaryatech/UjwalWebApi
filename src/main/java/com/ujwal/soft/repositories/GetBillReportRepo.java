package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.BillHeader;

public interface GetBillReportRepo extends JpaRepository<BillHeader, Integer>{
	@Query(value = "select h.*\r\n" + 
			"from bill_header h \r\n" + 
			"where h.del_status=0  BETWEEN  :fromDate AND :toDate ",
			 nativeQuery = true)
	List<BillHeader> getBillBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
/*select h.*,c.comp_name,c1.comp_
from bill_header h,m_company c
where h.bill_date between '2018-01-01' and '2018-12-31' AND c.comp_id=h.company_id 

*
*
------
SELECT c.mat_header_id,c.issue_no,c.contr_id,c.date,c.user_id,SUM(c.total)as total,SUM(c.qty_total)"
			+ " as qty_total,c.del_status,n.contr_name ,n.contr_mob,c.ex_int1,c.ex_int2,c.ex_int3,c.ex_var1,c.ex_var2,c.ex_var3,"
			+ "c.ex_date1,c.ex_date2,c.ex_bool1, c.ex_bool2,coalesce((SELECT SUM(w.quantity)   FROM t_weighing w WHERE w.del_status=1 "
			+ "AND w.contra_id=c.contr_id GROUP BY w.contra_id),'0') as weigh_contr_qty FROM t_mat_issue_contra_header c,m_contractor "
			+ "n WHERE c.del_status=1 AND c.contr_id=n.contr_id AND  c.date  BETWEEN  :fromDate AND :toDate "
			+ "GROUP BY c.contr_id", nativeQuery = true
*/