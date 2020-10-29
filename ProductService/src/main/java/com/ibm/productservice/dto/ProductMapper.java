package com.ibm.productservice.dto;

import com.ibm.productservice.domain.Product;

public class ProductMapper {
	
	public ProductDTO convertProductToProductDTO(Product product) {
		
		ProductDTO productDTO=new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setDiscount(product.getDiscount());
		productDTO.setPrice(product.getPrice());
		
		productDTO.setProductName(product.getProductName());
		productDTO.setQuantity(product.getQuantity());
		
		return productDTO;
		
	}
	
	public Product convertProductDTOToProduct(ProductDTO dto) {
		
		Product product=new Product();
		product.setDiscount(dto.getDiscount());
		product.setPrice(dto.getPrice());
		product.setProductName(dto.getProductName());
		product.setQuantity(dto.getQuantity());
		
		return product;
	}
			

}
