package com.erp.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "PURCHASE_ORDER_DETAILS_TAB")
public class PurchaseOrderDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purchaseOrderId;

	@NotBlank(message = "Please enter proper partyName name")
	@Size(min = 2, message = "orderNo should be atleast 3 characters")
	@Size(max = 50, message = "orderNo should not be greater than 50 characters")
	@Pattern(regexp = "^[^\\s*\"':?;/]+$", message = "orderNo should not contain spaces or specified characters (*-'\":?;/)")
	private String orderNo;

	@NotBlank(message = "Please enter proper partyName name")
	@Size(min = 3, message = "partyName should be atleast 3 characters")
	@Size(max = 50, message = "partyName should not be greater than 50 characters")
	@Pattern(regexp = "^[a-zA-Z]+( [a-zA-Z]+)?$", message = "partyName should contain only alphabets with an optional single space")
	@Column(name = "PARTY_NAME")
	private String partyName;

	@NotNull(message = "currentBalance cannot be null ")
	private Double currentBalance;

	@NotBlank(message = "Please enter proper itemName name")
	@Size(min = 3, message = "itemName should be atleast 3 characters")
	@Size(max = 50, message = "itemName should not be greater than 50 characters")
	@Pattern(regexp = "^[a-zA-Z]+( [a-zA-Z]+)?$", message = "itemName should contain only alphabets with an optional single space")
	@Column(name = "ITEM_NAME")
	private String itemName;

	@NotNull(message = "Quantity cannot be null")
	@Positive(message = "Quantity must be greater than 0")
	@Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Quantity must be a valid integer")
	private Long quantity;

	@NotNull(message = "Rate cannot be null")
	@DecimalMin(value = "0.0", inclusive = false, message = "Rate must be greater than 0")
	private Double rate;

	@NotNull(message = "unit cannot be null")
	@Min(value = 1, message = "unit must be greater than 0")
	private Long unit;

	@NotNull(message = "discount cannot be null")
	@DecimalMin(value = "0.0", inclusive = false, message = "Rate must be greater than 0")
	private Double discount;

	@NotNull(message = "amount cannot be null")
	@DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0")
	private Double amount;

	@NotBlank(message = "description is cannot be empty")
	@Size(min = 10, message = "description should be atleast 10 characters")
	@Size(max = 250, message = "description should not be greater than 250 characters")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Description should contain only alphabets with an optional single space")
	@Column(name = "DESCCRIPTION")
	private String description;

	@CreationTimestamp
	private LocalDate date;

	@NotBlank(message = "Days cannot be blank")
	@Column(name = "DAYS")
	private String days;

	@NotNull(message = "userId cannot be null")
	@Positive(message = "UserId Must be grater than zero")
	@Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "userId must be a valid number")
	private Long userId;

	@NotNull(message = "companyId cannot be null")
	@Positive(message = "companyId Must be grater than zero")
	@Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "companyId must be a valid number")
	private Long companyId;

}
