package com.ujwal.soft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.MPart;

public interface MPartRepo extends JpaRepository<MPart, Integer> {

	List<MPart> findAllByPartDelStatus(int i);

	//int delPart(int id);

	MPart findByPartIdAndPartDelStatus(int id, int i);

	@Transactional
	@Modifying
	@Query(value="update m_part set part_del_status = 1 where part_id=:id",nativeQuery=true)
	public int deletePart(@Param("id") int id);

	@Transactional
	@Modifying
	@Query(value="update m_part set part_del_status = 1 where part_id IN(:partIds)",nativeQuery=true)
	int deleteMultiPart(@Param("partIds") List<Integer> custIds);

	
	
	//int deleteMultiCompany(List<Integer> partIds);
}
