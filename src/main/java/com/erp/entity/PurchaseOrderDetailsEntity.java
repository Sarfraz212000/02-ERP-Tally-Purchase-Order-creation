package com.erp.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "PURCHASEORDER_TAB")
public class PurchaseOrderDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purchaseOrderId;
	
	private String orderNo;
	
	private String partyName;
	
	private Double currentBalance;
	
	private String itemName;
	
	private Long quantity;
	
	private Double rate;
	
	private Long unit;
	
	private Double discount;
	
	private Double amount;
	
	private String description;
	
	@CreationTimestamp
	private LocalDate date;
	
	private String days;
	
	private Long userId;
	
	private Long companyId;
	
}
