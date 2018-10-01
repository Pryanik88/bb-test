package br.com.bb.repository;

import br.com.bb.model.Category;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface CategoryDAO extends Repository<Category, Long> {


    List<Category> findAll();

    Category findOne(Long id);

}
