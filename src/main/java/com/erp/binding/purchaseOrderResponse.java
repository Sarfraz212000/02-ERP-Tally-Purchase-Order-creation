package com.erp.binding;

import lombok.Data;

@Data
public class purchaseOrderResponse {
	
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

	private String days;
}
