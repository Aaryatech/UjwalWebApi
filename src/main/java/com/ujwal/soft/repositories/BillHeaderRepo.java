/*package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujwal.soft.models.BillDetails;
import com.ujwal.soft.models.BillHeader;

public interface BillHeaderRepo extends JpaRepository<BillHeader, Integer>{

	//void getBillDetailList(List<BillDetails> billDetList);

	List<BillDetails> saveAll(List<BillDetails> billDetailList);

	void setBillDetailList(List<BillDetails> billDetList);

}
*/