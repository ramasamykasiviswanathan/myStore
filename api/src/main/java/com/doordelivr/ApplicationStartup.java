package com.doordelivr;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.doordelivr.mssql.dao.crudrepository.ProductRepository;
import com.doordelivr.mssql.dao.model.Product;
import com.doordelivr.mssql.dao.xml.model.InputParam;
import com.doordelivr.mssql.dao.xml.model.OrderDetails;
import com.doordelivr.mssql.dao.xml.model.SaveOrder;
import com.doordelivr.mysql.dao.crudrepository.SymbolEntityRepository;
import com.doordelivr.mysql.dao.model.SymbolEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	private ProductRepository products;
	
	@Autowired
	private SymbolEntityRepository symbols;
	
	@Autowired
	private ObjectMapper xmlobjectMapper;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			String string = xmlobjectMapper.writeValueAsString(populateObject());
			System.out.println(string);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<? super Object> list = products.Products(0);
		List<Product> products = (List<Product>) list.parallelStream().filter(Objects::nonNull).map( v ->{
			Object[] value = (Object[])v;
			return new Product((Integer)value[0], ((String) value[1]).trim(), (Double)value[2], (Double)value[3]);
		}).collect(Collectors.toList());
		products.forEach(System.out::println);
		List value = symbols.findAllByOrderByNameAsc();
		SymbolEntity symbolEntity = new SymbolEntity();
		symbolEntity.setIndustry("industry");
		symbolEntity.setMarketCap(new BigDecimal("100"));
		symbolEntity.setName("name");
		symbolEntity.setSector("sector");
		symbolEntity.setSymbol("symbol");
		symbols.save(symbolEntity);
	}
	
	InputParam populateObject(){
		InputParam inputParam = new InputParam();
		inputParam.setAppID("1");
		inputParam.setSpType("SaveOrder");
		inputParam.setUserID("");
		inputParam.setRetailerID("");
		inputParam.setOrder(new SaveOrder());
		inputParam.getOrder().setDetails(new LinkedList<>());
		
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setImageLink("");
		orderDetails.setOrderNO("20");
		orderDetails.setOrderDate("2017-12-28");
		orderDetails.setProductID("100001");
		orderDetails.setPrice("10");
		orderDetails.setQuantity("10");
		inputParam.getOrder().getDetails().add(orderDetails);
		orderDetails = new OrderDetails();
		orderDetails.setImageLink("");
		orderDetails.setOrderNO("20");
		orderDetails.setOrderDate("2017-12-28");
		orderDetails.setProductID("100002");
		orderDetails.setPrice("50");
		orderDetails.setQuantity("5");
		inputParam.getOrder().getDetails().add(orderDetails);
		
		return inputParam;
	}
	
}
