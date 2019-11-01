package com.SCMXPert.sbmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.SCMXPert.sbmongodb.document.Shipments;


public interface ShipmentsRepository extends MongoRepository<Shipments, String>, ShipmentDetailsCustom {
	
	@Query("{Customer_Id:'?0'}")
	Shipments findByCustomer_Id(String Customer_Id); 

}



/*
Shipments findBycustomerId(String customerId);

List<Shipments> findBycustomerIdLike(String customerId);

 List<Employee> findByHireDateGreaterThan(Date hireDate); 

// Supports native JSON query string
@Query("{Customer_Id:'?0'}")
List<Shipments> findCustomByRouteID(String RouteID);*/




