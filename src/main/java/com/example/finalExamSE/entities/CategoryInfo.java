package com.example.finalExamSE.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// for calculating qty * price
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryInfo {
    private String catCode;
    private String catDesc;
    private Double totalPrice;
}
