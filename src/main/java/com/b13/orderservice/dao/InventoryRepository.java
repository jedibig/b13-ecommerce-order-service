package com.b13.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b13.orderservice.dto.inventory.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, String> {

}
