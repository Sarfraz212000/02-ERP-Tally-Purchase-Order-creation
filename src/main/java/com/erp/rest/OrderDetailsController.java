package com.erp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erp.binding.purchaseOrderResponse;
import com.erp.entity.PurchaseOrderDetailsEntity;
import com.erp.service.PurchaseOrderDetailsService;

@RestController
public class OrderDetailsController {

	@Autowired
	private PurchaseOrderDetailsService orderService;

	@PostMapping("/saveorder")
	public ResponseEntity<String> saveOrder(@RequestBody PurchaseOrderDetailsEntity entity) {
		Boolean saveOrder = orderService.saveOrder(entity);
		if (saveOrder) {
			return new ResponseEntity<String>("purchase order save", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("purchase order not save", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@PostMapping("/saveorders")
	public ResponseEntity<List<PurchaseOrderDetailsEntity>> saveAllOrder(
			@RequestBody List<PurchaseOrderDetailsEntity> orders) {
		List<PurchaseOrderDetailsEntity> saveAllOrder = orderService.saveAllOrder(orders);
		return new ResponseEntity<List<PurchaseOrderDetailsEntity>>(saveAllOrder, HttpStatus.CREATED);

	}

	@GetMapping("order/{id}")
	public ResponseEntity<purchaseOrderResponse> getByIdPurchaseOrder(@PathVariable Integer id) {
		purchaseOrderResponse entity = orderService.getById(id);

		if (entity != null) {

			return new ResponseEntity<purchaseOrderResponse>(entity, HttpStatus.OK);
		} else {
			return new ResponseEntity<purchaseOrderResponse>(entity, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable Integer id) {
		String deleteOrder = orderService.deleteOrderById(id);
		return new ResponseEntity<>(deleteOrder, HttpStatus.OK);
	}

	@PutMapping("/updateorder")
	public ResponseEntity<PurchaseOrderDetailsEntity> updateOrderDetails(@RequestBody PurchaseOrderDetailsEntity entity) {
		PurchaseOrderDetailsEntity updateOrderDetails = orderService.updateOrderDetails(entity);
		if (updateOrderDetails != null) {
			return new ResponseEntity<>(updateOrderDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateOrderDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
