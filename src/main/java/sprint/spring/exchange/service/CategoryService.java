package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.Category;
import sprint.spring.exchange.model.JsonMsg;

import java.util.List;

public interface CategoryService {
    JsonMsg addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategory(Long id);
    JsonMsg updateCategory(Category category);
    JsonMsg deleteCategory(Long id);
}
