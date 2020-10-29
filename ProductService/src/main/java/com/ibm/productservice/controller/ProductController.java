package com.ibm.productservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.productservice.dto.ProductDTO;
import com.ibm.productservice.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("product")
@RestController
public class ProductController {
	
	
	
	@Autowired
	ProductService productService;
	
	
	
	@ApiOperation("This will provide products for given product ID.")
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> searchByProductID(@PathVariable(value="id") Long id) {
		
					
		return ResponseEntity.ok().body(productService.getProductById(id));
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		
		ProductDTO dto=productService.createProduct(productDTO);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value="id") Long id){
		
		productService.deleteProduct(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("This will provide products for given product name.")
	@GetMapping("product")
	public ResponseEntity<ProductDTO> searchByProductName(@RequestParam(value="name") String name) {
		
					
		return ResponseEntity.ok().body(productService.getProductByName(name));
		
	}
	
	

}
