package com.doordelivr.mysql.dao.crudrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.doordelivr.mysql.dao.model.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
  List<Country> findAllByOrderByNiceNameAsc();
}
