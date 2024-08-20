package tn.zeros.template.services.IServices;

import tn.zeros.template.entities.Product;

import java.util.List;

public interface IProductService {
    Product addProduct (Product product);

    public void removeProduct(Long id);
    public List<Product> retrieveAllProducts();
    public Product retrieveProduct(Long id);

    public Product modifyProduct(Product product);
    List<Product> retrieveProductsByCategory(Long categoryId);


}
