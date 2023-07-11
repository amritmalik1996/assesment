package com.accenture.assesment.updateProduct;

import com.accenture.assesment.updateProduct.binding.ProductType;
import com.accenture.assesment.updateProduct.binding.RequestType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AssesmentApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(AssesmentApplication.class, args);
		RequestType requestType = new RequestType();
		ProductType productType = new ProductType();
		productType.setId(8);
		productType.setQuantity(45);
		ProductType productType1 = new ProductType();
		productType1.setId(45);
		productType1.setQuantity(450);
		List<ProductType> productTypeList = new ArrayList<ProductType>();
		productTypeList.add(productType);
		productTypeList.add(productType1);
		requestType.setProductTypeList(productTypeList);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(requestType);
		System.out.println(json);
	}

}
