package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.Category;
import sprint.spring.exchange.model.Message;

import java.util.List;

public interface CategoryService {
    Message addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategory(Long id);
    Message updateCategory(Category category);
    Message deleteCategory(Long id);
}
