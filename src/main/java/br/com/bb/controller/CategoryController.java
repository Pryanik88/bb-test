package br.com.bb.controller;

import br.com.bb.model.Category;
import br.com.bb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/listAll")
    public List<Category> listAll(){
        return categoryService.listAll();
    }

    @GetMapping("/getByLetter/{letter}")
    public Category getByLetter(@PathVariable String letter){
        return categoryService.getByLetter(letter);
    }
}
