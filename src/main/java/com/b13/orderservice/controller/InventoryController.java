package com.b13.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b13.orderservice.dto.Inventory;
import com.b13.orderservice.service.InventoryService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/inventories")
public class InventoryController {
	final InventoryService service;

	@GetMapping("/{sku}")
	public ResponseEntity<Inventory> getInventory(@PathVariable("sku") String sku){
		return ResponseEntity.of(service.getInventoryById(sku));
	}
	
	@DeleteMapping({"/{sku}", "/"})
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public void deletInventory(@PathVariable("sku") String sku){}
	
	@PostMapping
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public void insertNewInventory(@RequestBody Inventory inventory ){}
	
	@PutMapping("/{sku}")
	public ResponseEntity<?> modifyInventory(@PathVariable("sku") String sku, @RequestBody int quantity){
		return ResponseEntity.of(service.addToInventory(sku, quantity));
	}
}
