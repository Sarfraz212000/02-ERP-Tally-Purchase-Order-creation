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
@Table(name = "COMPANY_TAB")
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	private String companyName;
	private String address;

	private String statutoryComplianceFor; // country
	private String state;
	private Integer pincode;
	private Long telephoneNo;
	private String email;
	private String currencySymbol;
	private String maintain;

	@CreationTimestamp
	private LocalDate financialYearFrom;
	@CreationTimestamp
	private LocalDate booksBeginningFrom;

	private String tallyVaultPassword;
	private String useSecurityControl;

	private String baseCurrencySymbol;
	private String formalName;
	private Integer numberOfDecimalPlaces;
	private String isSymbolSuffixedToAmounts;

	

}
