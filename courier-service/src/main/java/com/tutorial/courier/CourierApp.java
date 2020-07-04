package com.tutorial.courier;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class CourierApp {
	
	Logger logger = LoggerFactory.getLogger(CourierApp.class);

//    @StreamListener(Sink.INPUT)
//	@StreamListener("input")
	@StreamListener(Sink.INPUT)
    public void orderDispatched(String products) {
//		List<Product> test = products.get(0).toString();
//		List<Product> prod = products;
		logger.info("Order dispatched to your mailing address : " + products);
//        products.forEach(product -> {
//            logger.info("Order dispatched to your mailing address : " + product.toString());
//        });
    }

    public static void main(String[] args) {
        SpringApplication.run(CourierApp.class, args);
    }

}
