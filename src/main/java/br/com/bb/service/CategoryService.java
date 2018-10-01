package br.com.bb.service;

import br.com.bb.model.Category;
import br.com.bb.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryDAO dao;

    @Autowired
    public CategoryService(CategoryDAO dao) {
        this.dao = dao;
    }

    public List<Category> listAll() {
        return dao.findAll();
    }
}
