package com.ujwal.soft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.MCompany;
import com.ujwal.soft.models.MCustomer;

public interface MCustomerRepo extends JpaRepository<MCustomer, Integer>{

	List<MCustomer> findAllByCustDelStatus(int i);

	MCustomer findByCustIdAndCustDelStatus(int id, int i);
	@Transactional
	@Modifying
	@Query(value="update m_customer set cust_del_status = 1 where cust_id=:id",nativeQuery=true)
	public int deleteCustomer(@Param("id") int id);
	
	@Transactional
	@Modifying
	@Query(value="update m_customer set cust_del_status = 1 where cust_id IN(:custIds)",nativeQuery=true)
	int deleteMultiCompany(@Param("custIds") List<Integer> custIds);

	//int deleteCustomer(int id);

}
