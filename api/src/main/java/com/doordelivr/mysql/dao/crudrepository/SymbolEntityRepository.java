package com.doordelivr.mysql.dao.crudrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.doordelivr.mysql.dao.model.SymbolEntity;


public interface SymbolEntityRepository extends CrudRepository<SymbolEntity, String>{
	
	List<SymbolEntity> findAllByOrderByNameAsc();
	SymbolEntity findBySymbol(String symbol);
}
