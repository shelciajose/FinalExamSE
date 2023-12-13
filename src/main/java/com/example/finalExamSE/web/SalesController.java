package com.example.finalExamSE.web;


/*Name : Shelcia Jose
        ID : 300365479
        Git : https://github.com/shelciajose/FinalExamSE*/

import com.example.finalExamSE.entities.*;
import com.example.finalExamSE.repositories.categoryRepository;
import com.example.finalExamSE.repositories.itemsRepository;
import com.example.finalExamSE.repositories.salesRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;




@SessionAttributes({"a", "e", "rec", "qtys", "exists"})
@Controller
@AllArgsConstructor
public class SalesController {

    private static int num = 0;

    private salesRepository saleRepository;
    private itemsRepository itemRepository;

    private categoryRepository cRepository;




    @GetMapping(path = "/index")
    public String saless(Model model, ModelMap mm, @RequestParam(name = "keyword", defaultValue = "") String keyword) {

        List<sales> sale;
        List<items> item;
        List<category> categories;


        categories = cRepository.findAll();
        model.addAttribute("listcategory", categories);
            //Long key = Long.parseLong(keyword);
            //categories = cRepository.findCategorybyId(keyword);

        sale = saleRepository.findAll();
        model.addAttribute("listsales", sale);
        model.addAttribute("sales", new sales());

        item = itemRepository.findAll();
        model.addAttribute("listitems", item);

        List<CategoryInfo> categoryInfoList = new ArrayList<>();

        for (sales s : sale) {
            String icode = s.getIcode();
            items item1 = itemRepository.findById(icode).orElse(null);

            if (item != null) {
                String catCode = item1.getCatcode();
                category cat = cRepository.findById(catCode).orElse(null);

                if (cat != null) {
                    String catDesc = cat.getCatdesc();
                    Double totalPrice = s.getQty() * item1.getPrice();

                    CategoryInfo categoryInfo = new CategoryInfo(catCode, catDesc, totalPrice);
                    categoryInfoList.add(categoryInfo);
                }
            }
        }

        model.addAttribute("exists", 1);
        model.addAttribute("a", 0);
        model.addAttribute("e", 0);
        model.addAttribute("a", 1);
        model.addAttribute("e", 1);

        model.addAttribute("categoryInfoList", categoryInfoList);
        return "sales";
    }

    @ModelAttribute("sales")
    public sales setUpSales(){
        return new sales();
    }


    @GetMapping("/delete")
    public String delete(Long id) {
        saleRepository.deleteById(id);

        return "redirect:/index";
    }

    @GetMapping("formSales")
    public String formSales(Model model) {
        model.addAttribute("sales", new sales());

        return "formSales";
    }

    @PostMapping(path="/save")
    public String save(Model model, @ModelAttribute("sales") sales sale, BindingResult bindingResult, ModelMap mm, HttpSession session) {


        if (bindingResult.hasErrors()) {
            return "sales";
        } else {

            if (saleRepository.existsByRecnoAndIcode(sale.getRecno(), sale.getIcode())) {
                // Display an error message
                model.addAttribute("exists", 0);
                model.addAttribute("a", 0);
                model.addAttribute("e", 0);
                model.addAttribute("a", 1);
                model.addAttribute("e", 1);
                return "redirect:/index";
            }

            else{
                saleRepository.save(sale);
                if (num == 2) {
                    if(sale.getRecno() == 0){
                        model.addAttribute("rec", 0);
                        model.addAttribute("qtys", 1);
                        model.addAttribute("exists", 1);
                        model.addAttribute("a", 1);
                        model.addAttribute("e", 1);
                        Long id = sale.getId();
                        saleRepository.deleteById(id);
                    }
                    else if(sale.getQty() == null){
                        model.addAttribute("qtys", 0);
                        model.addAttribute("rec", 1);
                        model.addAttribute("exists", 1);
                        Long id = sale.getId();
                        saleRepository.deleteById(id);
                    }
                    else{
                        model.addAttribute("a", 1);
                        model.addAttribute("e", 2);
                        model.addAttribute("rec", 1);
                        model.addAttribute("qtys", 1);
                        model.addAttribute("exists", 1);
                    }
                }
                else {
                    if(sale.getRecno() == 0){
                        model.addAttribute("rec", 0);
                        model.addAttribute("qtys", 1);
                        model.addAttribute("exists", 1);
                        Long id = sale.getId();
                        saleRepository.deleteById(id);
                    }
                    else if(sale.getQty() == null){
                        model.addAttribute("qtys", 0);
                        model.addAttribute("rec", 1);
                        model.addAttribute("exists", 1);
                        Long id = sale.getId();
                        saleRepository.deleteById(id);
                    }
                    else{

                        model.addAttribute("a", 0);
                        model.addAttribute("e", 1);
                        model.addAttribute("rec", 1);
                        model.addAttribute("qtys", 1);
                        model.addAttribute("exists", 1);
                    }
                }
            }
            return "redirect:/index";
            }


    }



    @GetMapping("/editSales")
    public String editSales(Model model, Long id, HttpSession session) {
        num = 2;
        session.setAttribute("e", 2);
        session.setAttribute("a", 1);

        sales sale = saleRepository.findById(id).orElse(null);
        if(sale==null)
            throw new RuntimeException("sale does not exist");
        model.addAttribute("sale", sale);
        return "editSales";
    }


}
