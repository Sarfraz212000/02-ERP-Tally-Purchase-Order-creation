package com.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.entity.PurchaseOrderDetailsEntity;

public interface PurchaseOrderDetailsRepo extends JpaRepository<PurchaseOrderDetailsEntity, Integer> {
	
	 List<PurchaseOrderDetailsEntity> findAllByCompanyIdAndUserId(Long companyId, Long userId);

}
