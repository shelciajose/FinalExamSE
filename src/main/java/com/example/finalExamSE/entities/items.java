package com.example.finalExamSE.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class items {

    @Id
    private String Icode;

   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Catcode;



    private String Idesc;


    private Float Price;

}
