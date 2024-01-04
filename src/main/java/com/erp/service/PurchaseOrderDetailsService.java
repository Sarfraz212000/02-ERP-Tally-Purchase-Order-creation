package com.erp.service;

import java.util.List;

import com.erp.binding.purchaseOrderResponse;
import com.erp.entity.PurchaseOrderDetailsEntity;

public interface PurchaseOrderDetailsService {

	public Boolean saveOrder(PurchaseOrderDetailsEntity entity);

	public List<PurchaseOrderDetailsEntity> saveAllOrder(List<PurchaseOrderDetailsEntity> entities);

	public purchaseOrderResponse getById(Integer id);

	public String deleteOrderById(Integer id);

	public PurchaseOrderDetailsEntity updateOrderDetails(PurchaseOrderDetailsEntity orderEntities,
			Integer purchaseOrderId);

	public List<PurchaseOrderDetailsEntity> findAllByCompanyIdAndUserId(Long companyId, Long userId);
	
	public List<PurchaseOrderDetailsEntity> getAllPurchaseOrder();
	
    public List<PurchaseOrderDetailsEntity>  findByCompanyId(Long companyId);
    
    public List<PurchaseOrderDetailsEntity> findByUserId(Long userId);


}
