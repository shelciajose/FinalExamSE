package com.example.finalExamSE;

import com.example.finalExamSE.entities.category;
import com.example.finalExamSE.entities.items;
import com.example.finalExamSE.entities.sales;
import com.example.finalExamSE.repositories.categoryRepository;
import com.example.finalExamSE.repositories.itemsRepository;
import com.example.finalExamSE.repositories.salesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(itemsRepository iRepository, categoryRepository cRepository, salesRepository saleRepository) {
        return args -> {


            cRepository.save(new category("101", "School Supplies"));
            cRepository.save(new category("102", "Drinks"));
            cRepository.save(new category("103", "Dog Items"));

            if(saleRepository.count() == 0)
            {
                saleRepository.save(new sales(null, 155,"J102A",new Date(), 2.5));

            }


            iRepository.save(new items("J102A","102",  "Coke", 5.0f));
            iRepository.save(new items("J101B","101",  "Vines Paper pad", 4.0f));
            iRepository.save(new items("J103B","103",  "Pepsi", 4.0f));
            iRepository.save(new items("J103C","103",  "Dog Food", 22.5f));
            iRepository.save(new items("J101C","101",  "Xyz Eraser", 1.5f));
            iRepository.save(new items("J103D","103",  "Dog Chew Toy", 13.5f));


        };
    }

}
