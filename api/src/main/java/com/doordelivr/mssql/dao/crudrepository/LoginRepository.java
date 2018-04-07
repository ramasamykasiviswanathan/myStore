package com.doordelivr.mssql.dao.crudrepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.doordelivr.mssql.dao.model.Product;

public interface LoginRepository extends CrudRepository<Product, Long> {
	
	@Query(value="EXECUTE CA_ExecuteSP :xml", nativeQuery = true)
	public String user(@Param("xml") String xml);
	
	@Query(value="EXECUTE CA_ExecuteSP :xml", nativeQuery = true)
    public Object shops(@Param("xml") String xml);
}
