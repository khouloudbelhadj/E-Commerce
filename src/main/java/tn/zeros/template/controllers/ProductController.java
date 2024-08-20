package tn.zeros.template.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.zeros.template.entities.Product;
import tn.zeros.template.services.IServices.IProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class ProductController {
    private final IProductService productService;
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.addProduct(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productService.removeProduct(id);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modify(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.modifyProduct(product));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(productService.retrieveAllProducts());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.retrieveProduct(id));
    }

    @GetMapping("/getByCategory/{categoryId}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok().body(productService.retrieveProductsByCategory(categoryId));
    }
}
