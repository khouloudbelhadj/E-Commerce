package tn.zeros.template.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.zeros.template.entities.Category;
import tn.zeros.template.services.IServices.ICategoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class CategoryController {
    private final ICategoryService categoryService;
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Category category){
        return ResponseEntity.ok().body(categoryService.addCategory(category));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.removeCategory(id);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modify(@RequestBody Category category ){
        return ResponseEntity.ok().body(categoryService.modifyCategory(category));

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(categoryService.retrieveAllCategories());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(categoryService.retrieveCategory(id));

    }
}
