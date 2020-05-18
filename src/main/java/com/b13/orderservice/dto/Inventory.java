package com.b13.orderservice.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
	@Id
	private String sku;
	private int quantity;
	private InventoryStatus status;
	@Version
	private int version;
}
