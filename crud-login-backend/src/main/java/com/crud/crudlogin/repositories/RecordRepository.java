package com.crud.crudlogin.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.crudlogin.entites.People;

@Repository
public interface RecordRepository extends JpaRepository<People,Long>{
	
	
}