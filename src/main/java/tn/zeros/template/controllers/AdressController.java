package tn.zeros.template.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.zeros.template.entities.Adress;
import tn.zeros.template.services.IServices.IAdressService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adress")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class AdressController {
    private final IAdressService adressService;
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Adress adress){
        return ResponseEntity.ok().body(adressService.addAdress(adress));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        adressService.removeAdress(id);
        return ResponseEntity.ok().body(true);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modify(@RequestBody Adress adress){
        return ResponseEntity.ok().body(adressService.modifyAdress(adress));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(adressService.retrieveAllAdresses());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok().body(adressService.retrieveAdress(id));

    }
}
