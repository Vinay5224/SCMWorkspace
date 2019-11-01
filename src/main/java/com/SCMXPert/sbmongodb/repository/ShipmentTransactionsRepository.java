package com.SCMXPert.sbmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.SCMXPert.sbmongodb.document.ShipmentTransactions;

public interface ShipmentTransactionsRepository extends MongoRepository<ShipmentTransactions, String>, ShipmentDetailsCustom {
	
	@Query("{Customer_Id:'?0'}")
	List<ShipmentTransactions> findByCustomer_Id(String customer_Id);
	
	@Query("{Customer_Id:'?0'}")
	ShipmentTransactions findBySingleCustomer_Id(String customer_Id);

	
	@Query("{Shipment_Id:'?0'}")
	List<ShipmentTransactions> findByShipment_Id(String Shipment_Id);
}
	 
/*	ShipmentTransactions findByshipmentId(String shipmentId);
 
   List<ShipmentTransactions> findByshipmentIdLike(String shipmentId);

	 List<Employee> findByHireDateGreaterThan(Date hireDate); 

   // Supports native JSON query string
   @Query("{ShipmentId:'?0'}")
   List<Devices> findCustomByShipmentId(String RouteID);
*/