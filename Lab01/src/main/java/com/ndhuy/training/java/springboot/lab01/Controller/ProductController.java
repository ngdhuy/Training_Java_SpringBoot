package com.ndhuy.training.java.springboot.lab01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ProductController {
    // localhost:8080/product/list
    @RequestMapping("/product/list")
    public String ListOfProduct(){
        return "listOfProduct";
    }

    // localhost:8080/product/2
    @RequestMapping("/product/{id}")
    public String GetProductInfo(@PathVariable(value = "id", required = true) String id){
        System.out.println("--> Get product info: id = " + id);
        return "getProductInfo";
    }

    // localhost:8080/product?name=iphoneX&type=phone
    @RequestMapping("/product")
    public String FindProduct(@RequestParam(value = "name", required = true) String productName,
                              @RequestParam(value = "type", required = true) String productType,
                              HttpSession session){
        System.out.println("--> Find product name: " + productName + " -  type: " + productType);
        // Set value to session
        session.setAttribute("productName", productName);
        return "findProduct";
    }
}
