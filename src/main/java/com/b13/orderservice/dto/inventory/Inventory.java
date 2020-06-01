package com.b13.orderservice.dto.inventory;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Version;

import com.b13.orderservice.dto.ProductInformation;
import com.b13.orderservice.exception.InvalidQuantityException;

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
	private int availableUnit;
	private int onHoldUnit;
	private int lowStockLimit = 10;
	private String merchantId;
	@Enumerated(EnumType.STRING)
	private InventoryStatus status;
	private BigDecimal price;
	
	
	private ProductInformation products;
	
	@Version
	private int version;
	
	public InventoryStatus addQuantity(int quantity) {
		this.availableUnit += quantity;
		return updateStatus();
	}
	
	public InventoryStatus removeQuantity(int quantity) {
		if (this.onHoldUnit < quantity)
			throw new InvalidQuantityException();
		this.onHoldUnit -= quantity;
		return updateStatus();
	}
	
	public InventoryStatus putOnHold(int quantity) {
		if (this.availableUnit < quantity)
			throw new InvalidQuantityException();
		this.availableUnit += quantity;
		this.onHoldUnit += quantity;
		return updateStatus();
	}
	
	public InventoryStatus updateStatus() {
		if (this.availableUnit > this.lowStockLimit) {
			this.status = InventoryStatus.AVAILABLE;
		} else if (this.availableUnit == 0) {
			this.status = InventoryStatus.OUT_OF_STOCK;
		} else {
			this.status = InventoryStatus.RESTOCK_NEEDED;
		}
		return this.status;
	}
}
