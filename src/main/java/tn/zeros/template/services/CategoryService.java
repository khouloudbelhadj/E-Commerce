package tn.zeros.template.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.zeros.template.entities.Category;
import tn.zeros.template.repositories.CategoryRepository;
import tn.zeros.template.services.IServices.ICategoryService;

import java.util.List;
@RequiredArgsConstructor
@Service
@Slf4j
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository ;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> retrieveAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category retrieveCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category modifyCategory(Category category) {
        return categoryRepository.save(category);
    }
}
