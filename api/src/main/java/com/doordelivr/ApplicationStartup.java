package com.doordelivr;

import java.util.LinkedList;
import java.util.function.Function;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.doordelivr.mssql.dao.model.Product;
import com.doordelivr.mssql.dao.xml.model.fetchcategory.Parameters;
import com.doordelivr.mssql.dao.xml.model.saveorder.InputParam;
import com.doordelivr.mssql.dao.xml.model.saveorder.OrderDetails;
import com.doordelivr.mssql.dao.xml.model.saveorder.SaveOrder;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		/*List<Product> productList = null;
		try {
			String string = xmlobjectMapper.writeValueAsString(populateObject());
			string = xmlobjectMapper.writeValueAsString( populateFetchCategory());
			System.out.println(string);
			productList = (List<Product>) products.getProducts(0, string).parallelStream().filter(Objects::nonNull).map(this.myFunction).collect(Collectors.toList());
			productList.forEach(System.out::println);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		symbols.findAllByOrderByNameAsc();
		SymbolEntity symbolEntity = new SymbolEntity();
		symbolEntity.setIndustry("industry");
		symbolEntity.setMarketCap(new BigDecimal("100"));
		symbolEntity.setName("name");
		symbolEntity.setSector("sector");
		symbolEntity.setSymbol("symbol");
		symbols.save(symbolEntity);*/
	}
	
	Function<Object, Product> myFunction = (input) ->{
		Object[] value = (Object[])input;
		return new Product((Integer)value[0], ((String) value[1]).trim(), (Double)value[2], (Double)value[3]);
	};
	
	com.doordelivr.mssql.dao.xml.model.fetchcategory.InputParam populateFetchCategory(){
			com.doordelivr.mssql.dao.xml.model.fetchcategory.InputParam inputParam = new com.doordelivr.mssql.dao.xml.model.fetchcategory.InputParam();
			inputParam.setAppID("1");
			inputParam.setSpType("FetchProducts");
			inputParam.setRetailerID("1");
			inputParam.setParameters(new Parameters());
			inputParam.getParameters().setSearchProducts("Milk");
			return inputParam;
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
