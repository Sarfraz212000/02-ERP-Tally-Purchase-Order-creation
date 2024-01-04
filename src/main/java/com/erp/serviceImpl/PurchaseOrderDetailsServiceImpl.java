package com.erp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.binding.purchaseOrderResponse;
import com.erp.entity.PurchaseOrderDetailsEntity;
import com.erp.repository.PurchaseOrderDetailsRepo;
import com.erp.service.PurchaseOrderDetailsService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PurchaseOrderDetailsServiceImpl implements PurchaseOrderDetailsService {

	@Autowired
	private PurchaseOrderDetailsRepo purchaseOrderRepo;

	@Override
	public Boolean saveOrder(PurchaseOrderDetailsEntity entity) {

		purchaseOrderRepo.save(entity);

		return true;
	}

	@Override
	public List<PurchaseOrderDetailsEntity> saveAllOrder(List<PurchaseOrderDetailsEntity> entities) {
		return purchaseOrderRepo.saveAll(entities);
	}

	@Override
	public purchaseOrderResponse getById(Integer id) {
		purchaseOrderResponse response = new purchaseOrderResponse();
		Optional<PurchaseOrderDetailsEntity> findById = purchaseOrderRepo.findById(id);
		if (findById.isPresent()) {
			PurchaseOrderDetailsEntity entity = findById.get();
			BeanUtils.copyProperties(entity, response);

			Double productPrice = entity.getAmount();
			Double discount = entity.getDiscount();
			Long quantity = entity.getQuantity();
			Double discountPrice = ((productPrice * discount) / 100) * quantity;
			response.setDiscount(discountPrice);
			response.setAmount((productPrice * quantity) - discountPrice);
			return response;
		}
		return null;
	}

	@Override
	public String deleteOrderById(Integer id) {
		purchaseOrderRepo.deleteById(id);
		return "deleted order";
	}

	@Override
	public PurchaseOrderDetailsEntity updateOrderDetails(PurchaseOrderDetailsEntity orderEntities, Integer purchaseOrderId) {
		Optional<PurchaseOrderDetailsEntity> optionalOrder = purchaseOrderRepo.findById(purchaseOrderId);
		if (optionalOrder.isPresent()) {
			PurchaseOrderDetailsEntity entity = optionalOrder.get();
			BeanUtils.copyProperties(orderEntities, entity);
			entity.setPurchaseOrderId(purchaseOrderId);
			return purchaseOrderRepo.save(entity);
		}
		return null;
	}

	@Override
	public List<PurchaseOrderDetailsEntity> findAllByCompanyIdAndUserId(Long companyId, Long userId) {
		return purchaseOrderRepo.findAllByCompanyIdAndUserId(companyId, userId);
	}

	@Override
	public List<PurchaseOrderDetailsEntity> getAllPurchaseOrder() {
		return purchaseOrderRepo.findAll();
		 
	}

	@Override
	public List<PurchaseOrderDetailsEntity> findByCompanyId(Long companyId) {
		 return  purchaseOrderRepo.findAllByCompanyId(companyId);
	   
	}

	@Override
	public List<PurchaseOrderDetailsEntity> findByUserId(Long userId) {
		return	purchaseOrderRepo.findAllByUserId(userId);
		
	}

}
