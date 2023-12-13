package com.example.finalExamSE.repositories;

import com.example.finalExamSE.entities.sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface salesRepository extends JpaRepository<sales, Long> {

    boolean existsByRecnoAndIcode(int recno, String icode);

    List<sales> findByIcode(String icode);

}
