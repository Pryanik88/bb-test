package br.com.bb.service;

import br.com.bb.model.Product;
import br.com.bb.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO dao;

    @Autowired
    public ProductService(ProductDAO dao) {
        this.dao = dao;
    }

    public List<Product> findByCategory(Long categoryId) {
        return dao.findByCategory(categoryId);
    }
}
