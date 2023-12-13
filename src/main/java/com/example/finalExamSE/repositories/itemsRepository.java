package com.example.finalExamSE.repositories;

import com.example.finalExamSE.entities.items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itemsRepository extends JpaRepository<items, String> {
    //float findItemPriceByCatCode(String catCode);

    //List<items> finditembyId(Integer rec);

}
