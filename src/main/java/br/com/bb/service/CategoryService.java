package br.com.bb.service;

import br.com.bb.model.Category;
import br.com.bb.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.Normalizer;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

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

    public Category getByLetter(String letter) {
        return dao.findAll().stream().max(Comparator.comparing(category -> count(category.getName(), letter))).orElse(null);
    }

    private int count(String srcStr, String letter) {
        return StringUtils.countOccurrencesOf(stripAccents(srcStr).toLowerCase(), letter);
    }

    //copiado sem vergonha de Apache StringUtils
    private String stripAccents(final String input) {
        if (input == null) {
            return null;
        }
        final Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");//$NON-NLS-1$
        final StringBuilder decomposed = new StringBuilder(Normalizer.normalize(input, Normalizer.Form.NFD));
        convertRemainingAccentCharacters(decomposed);
        // Note that this doesn't correctly remove ligatures...
        return pattern.matcher(decomposed).replaceAll("");
    }

    private void convertRemainingAccentCharacters(final StringBuilder decomposed) {
        for (int i = 0; i < decomposed.length(); i++) {
            if (decomposed.charAt(i) == '\u0141') {
                decomposed.deleteCharAt(i);
                decomposed.insert(i, 'L');
            } else if (decomposed.charAt(i) == '\u0142') {
                decomposed.deleteCharAt(i);
                decomposed.insert(i, 'l');
            }
        }
    }

}
