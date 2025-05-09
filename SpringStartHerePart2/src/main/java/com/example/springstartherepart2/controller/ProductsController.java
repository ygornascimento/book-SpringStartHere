package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {
    private final ProductService productService;

    // We use DI through the controller's constructor parameters to get the service bean from the Spring Context.
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping("/products") /* We map the controller action to the /products path. The @RequestMapping annotation, by default, uses the
    HTTP GET method. */
    public String products(Model model) { // We define a Model parameter that we use to send the data to the view.
        var products = productService.findAll(); // We get the product list from the service.
        model.addAttribute("products", products); // We send the products list to the view.
        return "products.html"; // We return the view name, which will be taken and rendered by the dispatcher servlet.
    }
}
