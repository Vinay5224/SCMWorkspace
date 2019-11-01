package com.SCMXPert.sbmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.SCMXPert.sbmongodb.document.BusinessPartner;

public interface BusinessPartnerRepository extends MongoRepository<BusinessPartner, String> {

}

/*
 * BusinessPartner findByBPId(String BPId);
 * 
 * List<BusinessPartner> findByBPIdLike(String BPId);
 * 
 * List<Employee> findByHireDateGreaterThan(Date hireDate);
 * 
 * // Supports native JSON query string
 * 
 * @Query("{BPId:'?0'}") List<Devices> findCustomByBPId(String BPIds);
 */