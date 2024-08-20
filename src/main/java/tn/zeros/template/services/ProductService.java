package tn.zeros.template.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.zeros.template.entities.Product;
import tn.zeros.template.repositories.ProductRepository;
import tn.zeros.template.services.IServices.IProductService;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService implements IProductService {
    private final ProductRepository productRepository ;
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product retrieveProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product modifyProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> retrieveProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}
