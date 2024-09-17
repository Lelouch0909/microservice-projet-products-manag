package com.lontsi.inventoryservice;

import com.lontsi.inventoryservice.model.Inventory;
import com.lontsi.inventoryservice.repository.InventoryRepository;
import com.lontsi.inventoryservice.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InventoryService inventoryService, InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setQuantity(10);
			inventory.setSkuCode("test");

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("test2");
			inventory2.setQuantity(20);

			Inventory inventory3 = new Inventory();
			inventory3.setSkuCode("test3");
			inventory3.setQuantity(0);

			inventoryRepository.saveAll(List.of(inventory, inventory2, inventory3));
		};
	}
}
