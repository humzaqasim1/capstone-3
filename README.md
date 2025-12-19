# Capstone 3: **_EasyShop_** - by Humza Qasim

This project contains a Java Spring Boot backend and a static HTML/CSS/JavaScript frontend.

---

## Requirements

* **Java Development Kit (JDK) 17**
* **IntelliJ IDEA Community Edition** (latest)
* **MySQL Server** (e.g., MySQL 8.x)
* **MySQL Workbench** (to run the database script)
* Internet browser (Chrome, Firefox, Edge, Safari, etc.)


---

## Project Description

This project contains a digital storefront for EasyShop; a store that sells clothing, electronics, and home/cooking wares. 
Code was provided for most of the backend of this project, though adjustments, additions, and bug fixes were made by me.
I fixed the category functionality of the program as well as solved bugs involving the search feature and accidental product duplication.
I had hoped to create a functional shopping cart feature but struggled to get the code to work in time.
---

## Application Screen Images
![CapstoneScreenshot1](https://github.com/user-attachments/assets/6dc13e9b-1be0-4226-94c0-c3e3edf23e60)
![CapstoneScreenshot2](https://github.com/user-attachments/assets/962df57d-5322-4cd0-b82d-4580a12374c2)
![CapstoneScreenshot3](https://github.com/user-attachments/assets/49c59486-de42-43d7-8d80-65845f53589e)

---

## Interesting Code

One piece of code I found interesting and exciting to make was the CategoriesController. This class implemented methods from multiple DAOs and contained request mapping as well as response statuses.
```java
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

```
---

## Future Goals

I hope to complete the shopping cart, user login, and checkout functions to create a fully operational website.




