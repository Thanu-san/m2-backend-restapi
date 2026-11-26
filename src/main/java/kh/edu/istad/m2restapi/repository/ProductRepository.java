package kh.edu.istad.m2restapi.repository;

import kh.edu.istad.m2restapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
