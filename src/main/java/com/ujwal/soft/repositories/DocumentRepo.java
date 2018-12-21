package com.ujwal.soft.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ujwal.soft.models.Document;

public interface DocumentRepo extends JpaRepository<Document, Integer> {

	@Query(value = "SELECT * FROM m_document  "
			+ " WHERE doc_code =:docCode AND del_status=0 AND :curDate BETWEEN from_date AND to_date ", nativeQuery = true)
	Document getDocuData(@Param("docCode") int docCode, @Param("curDate") String curDate);

	@Transactional
	@Modifying
	@Query("UPDATE Document SET srNo =:srNo  WHERE docCode =:docCode")
	int updateDocSrNo(@Param("srNo") int srNo, @Param("docCode") int docCode);

	List<Document> findByDelStatusOrderByDocIdDesc(int i);

}
