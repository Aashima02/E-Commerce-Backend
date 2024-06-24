package com.example.E_Commerce.Backend.EComm.Repositories;

import com.example.E_Commerce.Backend.EComm.Tables.CartMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartMaster,Long> {
}
