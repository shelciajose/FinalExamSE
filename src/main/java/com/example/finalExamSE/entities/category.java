package com.example.finalExamSE.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class category {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Catcode;

    private String Catdesc;



}
