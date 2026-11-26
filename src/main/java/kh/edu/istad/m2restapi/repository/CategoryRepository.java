package kh.edu.istad.m2restapi.repository;

import kh.edu.istad.m2restapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
