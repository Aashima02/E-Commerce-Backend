package com.example.E_Commerce.Backend.EComm.Repositories;

import com.example.E_Commerce.Backend.EComm.Tables.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductMaster, Integer> {
//    List<ProductMaster> findById(List<Integer> productIds);
 //   Optional<ProductMaster> findProductByName(String productName);

}
