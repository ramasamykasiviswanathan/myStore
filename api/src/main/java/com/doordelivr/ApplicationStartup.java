package com.doordelivr;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.doordelivr.mssql.dao.crudrepository.ProductRepository;
import com.doordelivr.mssql.dao.model.Product;
import com.doordelivr.mysql.dao.crudrepository.SymbolEntityRepository;
import com.doordelivr.mysql.dao.model.SymbolEntity;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	private ProductRepository products;
	
	@Autowired
	private SymbolEntityRepository symbols;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
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
}
