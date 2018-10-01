package br.com.bb.controller;

import br.com.bb.model.Product;
import br.com.bb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    final
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/listByCategory/{categoryId}")
    public List<Product> listByCategory(@PathVariable Long categoryId){
        return productService.findByCategory(categoryId);
    }
}
