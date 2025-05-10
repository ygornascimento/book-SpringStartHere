package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.Product;
import com.example.springstartherepart2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {
    private final ProductService productService;

    // We use DI through the controller's constructor parameters to get the service bean from the Spring Context.
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

//    /* We map the controller action to the /products path. The @RequestMapping annotation, by default, uses the HTTP GET method. */
//    @RequestMapping("/products")
    @GetMapping("/products") // Maps the GET request with a specific path to the controller's action.
    public String products(Model model) { // We define a Model parameter that we use to send the data to the view.
        var products = productService.findAll(); // We get the product list from the service.
        model.addAttribute("products", products); // We send the products list to the view.
        return "products.html"; // We return the view name, which will be taken and rendered by the dispatcher servlet.
    }

//    @RequestMapping(value = "/products", method = RequestMethod.POST) /* We map the controller action to the /products path.
//    We use the method attribute of the @RequestMapping annotation to change the HTTP method to POST . */
    @PostMapping("/products") // Maps the POST request with a specific path to the controller's action.
    public String addProduct(@RequestParam String name, @RequestParam double price, Model model) { /* We get the name and
    the price for the product to add using request parameters.
    */
        // We build a new Product instance and add it to the list by calling the service use case method.
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.addProduct(product);

        // We get the list of products and send it to the view.
        var products = productService.findAll();
        model.addAttribute("products", products);

        // We return the name of the view to be redered.
        return "products.html";
    }
}
