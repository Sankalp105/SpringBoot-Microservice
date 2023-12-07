package com.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ms.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
