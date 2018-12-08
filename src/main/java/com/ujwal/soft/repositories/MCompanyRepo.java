package com.ujwal.soft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujwal.soft.models.MCompany;

@Repository
public interface MCompanyRepo extends JpaRepository<MCompany, Integer>{

	/*@Query(value="select * from m_company where comp_id=:id",nativeQuery=true)
	public@ResponseBody MCompany getCompanyById(@Param("id") int id);
	*/
	@Transactional
	@Modifying
	@Query(value="update m_company set del_status = 1 where comp_id=:id",nativeQuery=true)
	public int deleteCompany(@Param("id") int id);

	public List<MCompany> findAllByDelStatus(int i);

	public MCompany findByCompIdAndDelStatus(int compId, int delStatus);
	

}
