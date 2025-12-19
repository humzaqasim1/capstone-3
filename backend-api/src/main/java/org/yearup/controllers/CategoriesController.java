package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

// added the annotations to make this a REST controller
// added annotation to allow cross site origin requests
@RestController
@CrossOrigin
public class CategoriesController
{

    private CategoryDao categoryDao;
    private ProductDao productDao;

    // created an Autowired controller to inject the categoryDao and ProductDao
    @Autowired
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao){
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }

    // added the appropriate annotation for a get action
    @RequestMapping (path = "/categories", method = RequestMethod.GET)
    public List<Category> getAll()
    {
        // finds and returns all categories

        return this.categoryDao.getAllCategories();
    }

    // added the appropriate annotation for a get action
    @RequestMapping (path = "/categories/{id}", method = RequestMethod.GET)
    @ResponseStatus (value = HttpStatus.OK)
    public Category getById(@PathVariable int id)
    {
        // gets the category by id
        Category result = this.categoryDao.getById(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return result;
    }

    // added the appropriate annotation for a get action
    @GetMapping("categories/{categoryId}/products")
    @ResponseStatus (value = HttpStatus.OK)
    public List<Product> getProductsById(@PathVariable int categoryId)
    {
        // gets a list of product by categoryId
        return this.productDao.listByCategoryId(categoryId);
    }

    // added annotation to call this method for a POST action
    // added annotation to ensure that only an ADMIN can call this function
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping (path = "/categories", method = RequestMethod.POST)
    @ResponseStatus (value = HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category)
    {
        // inserts the category
        return this.categoryDao.create(category);
    }

    // added annotation to call this method for a PUT (update) action
    // added annotation to ensure that only an ADMIN can call this function
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping (path = "/categories/{id}", method = RequestMethod.PUT)
    @ResponseStatus (value = HttpStatus.OK)
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        // updates the category by id
        this.categoryDao.update(id, category);
    }

    // added annotation to call this method for a DELETE action
    // added annotation to ensure that only an ADMIN can call this function
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping (path = "/categories/{id}", method = RequestMethod.DELETE)
    @ResponseStatus (value = HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id)
    {
        // deletes the category by id
        this.categoryDao.delete(id);
    }
}
