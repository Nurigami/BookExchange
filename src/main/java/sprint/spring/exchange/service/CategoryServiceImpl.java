package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.Category;
import sprint.spring.exchange.model.JsonMsg;
import sprint.spring.exchange.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public JsonMsg addCategory(Category category) {
        categoryRepository.save(category);
        return null;
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
    public JsonMsg updateCategory(Category category) {
        for(Category c: categoryRepository.findAll()){
            if(c.getId().equals(category.getId())){
                c.setName(category.getName());
                categoryRepository.save(c);
                return new JsonMsg("Category is updated");
            }
        }
        return new JsonMsg("Category with id " + category.getId() + " does not exist");
    }

    @Override
    public JsonMsg deleteCategory(Long id) {
        for(Category c: categoryRepository.findAll()){
            if(c.getId().equals(id)){
                categoryRepository.delete(c);
                return new JsonMsg("Category is removed");
            }
        }
        return new JsonMsg("Category with id " + id + " does not exist");
    }
}
