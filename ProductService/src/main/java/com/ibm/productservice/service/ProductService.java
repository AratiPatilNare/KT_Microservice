package com.ibm.productservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.productservice.domain.Product;
import com.ibm.productservice.dto.ProductDTO;
import com.ibm.productservice.dto.ProductMapper;
import com.ibm.productservice.repository.ProductRepository;


@Service
public class ProductService {
	private static Logger logger= LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	ProductRepository productRepository;
	
	//final RestClient restClient;
	
	/**@Autowired
	public ProductService(RestClient restClient) {
		this.restClient=restClient;
	}**/
	

	public ProductDTO getProductById(Long id) {
		Optional<Product> product= productRepository.findById(id);
		ProductDTO productDTO=null;
		if(product.isPresent()) {
			
			ProductMapper mapper=new ProductMapper();
			 productDTO=mapper.convertProductToProductDTO(product.get());
			 logger.info("calling tax service to get the tax for given product name:"+productDTO.getProductName());
			 //Long tax= restClient.getTax(productDTO.getProductName());
			 //logger.info("Product Service: Tax service return the tax:"+tax);
			 //productDTO.setTax(tax);
		}
		
		return productDTO;
	}

	public ProductDTO taxServiceFallback(Long id) {
		
		Optional<Product> product= productRepository.findById(id);
		ProductDTO productDTO=null;
		if(product.isPresent()) {
			
			ProductMapper mapper=new ProductMapper();
			 productDTO=mapper.convertProductToProductDTO(product.get());
			 productDTO.setTax(3L);
		}
		
		return productDTO;
	}
	
	public ProductDTO createProduct(ProductDTO dto) {
		
		ProductMapper mapper=new ProductMapper();
		Product product= mapper.convertProductDTOToProduct(dto);
		
		Product product1= productRepository.save(product);
		       return mapper.convertProductToProductDTO(product1);
		
	}
	
	public void deleteProduct(Long id) {
		productRepository.delete(productRepository.findById(id).get());
		
	}
	
	public ProductDTO getProductByName(String name) {
		Product product=productRepository.findByProductName(name);
		ProductMapper mapper=new ProductMapper();
		return mapper.convertProductToProductDTO(product);
		
	}
}
