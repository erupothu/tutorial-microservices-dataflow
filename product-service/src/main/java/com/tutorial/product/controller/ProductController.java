package com.tutorial.product.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.product.Product;

@RestController
public class ProductController {
	
//	@Autowired
//    Source source;
	
	@Autowired
    private MessageChannel output;

	@GetMapping("/publish")
	public List<Product> publishEvent() {
		List<Product> products= Stream.of(new Product(101,"Mobile",8000),new Product(102,"book",6000))
				.collect(Collectors.toList());
//		Product product = new Product(101,"Mobile",8000);
//		product.setId(101);
//		product.setName("Harish");
//		product.setPrice(8000);
		output.send(MessageBuilder.withPayload(products).build());
		return products;
	}

}
