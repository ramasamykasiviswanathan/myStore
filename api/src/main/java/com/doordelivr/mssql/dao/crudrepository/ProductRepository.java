package com.doordelivr.mssql.dao.crudrepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.doordelivr.mssql.dao.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	@Query(value = "EXECUTE Dsp_GetProducts :mode, :xml", nativeQuery = true)
	public List<Object> getProducts(@Param("mode") Integer mode, @Param("xml") String xml);
	
}
