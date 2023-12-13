package com.example.finalExamSE.repositories;

import com.example.finalExamSE.entities.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepository extends JpaRepository<category, String> {

    //List<category> findCategorybyId(String cc);

}
