package br.com.bb.repository;


import br.com.bb.model.Product;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductDAO extends Repository<Product, Long> {


    List<Product> findByCategory(Long category);

    List<Product> findAll();

    Product findOne(Long id);

}
