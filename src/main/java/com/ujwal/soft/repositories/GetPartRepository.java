package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ujwal.soft.models.MGetPart;
import com.ujwal.soft.models.MPart;

public interface GetPartRepository extends JpaRepository<MGetPart, Integer>
{
	@Query(value="select p.part_id,p.part_tax_id,p.part_name,p.part_no,p.part_register_no,p.part_specification,p.part_uom_id,p.part_ro_no,p.part_del_status,p.part_mrp,t.tax_desc,t.tax_per,t.tax_id,t.igst_per,t.sgst_per,t.cess_per,t.cgst_per,t.hsn_code,u.uom_id,u.uom_name\r\n" + 
			"			from m_part p,m_tax t,m_uom u\r\n" + 
			"			where p.part_tax_id=t.tax_id and p.part_id=:id",nativeQuery=true)
	     	MGetPart findByPart(@Param("id")int id);

	@Query(value="select p.part_id,p.part_tax_id,p.part_name,p.part_no,p.part_register_no,p.part_specification,p.part_uom_id,p.part_ro_no,p.part_del_status,p.part_mrp,t.tax_desc,t.igst_per,t.sgst_per,t.cess_per,t.cgst_per,t.hsn_code,t.tax_id,t.tax_per,u.uom_name\r\n" + 
			"from m_part p,m_tax t,m_uom u\r\n" + 
			"where p.part_tax_id=t.tax_id and p.part_uom_id=u.uom_id and p.part_del_status=0",nativeQuery=true)
	List<MGetPart> findByPartList();
}
