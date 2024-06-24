package com.example.E_Commerce.Backend.EComm.Repositories;

import com.example.E_Commerce.Backend.EComm.Tables.CategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryMaster, Long> {

}




