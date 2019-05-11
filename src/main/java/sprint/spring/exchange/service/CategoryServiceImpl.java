package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.Category;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Message addCategory(Category category) {
        categoryRepository.save(category);
        return new Message("New category is saved");
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        for(Category c: categoryRepository.findAll()){
            if(c.getId().equals(id)) return categoryRepository.getOne(id);
        }
        return null;
    }

    @Override
    public Message updateCategory(Category category) {
        for(Category c: categoryRepository.findAll()){
            if(c.getId().equals(category.getId())){
                c.setName(category.getName());
                categoryRepository.save(c);
                return new Message("Category is updated");
            }
        }
        return new Message("Category with id " + category.getId() + " does not exist");
    }

    @Override
    public Message deleteCategory(Long id) {
        for(Category c: categoryRepository.findAll()){
            if(c.getId().equals(id)){
                categoryRepository.delete(c);
                return new Message("Category is removed");
            }
        }
        return new Message("Category with id " + id + " does not exist");
    }
}
