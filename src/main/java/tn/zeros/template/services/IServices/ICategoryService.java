package tn.zeros.template.services.IServices;

import tn.zeros.template.entities.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);

    public void removeCategory(Long id);

    public List<Category> retrieveAllCategories();

    public Category retrieveCategory(Long id);

    public Category modifyCategory(Category category);

}
