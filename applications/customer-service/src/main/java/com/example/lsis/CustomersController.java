package com.example.lsis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    private CustomersRepository customersRepository;


    public CustomersController(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }


    @GetMapping("{id}")
     public ResponseEntity<Customer> find (@PathVariable Long id){
        Optional<Customer> customer = customersRepository.findById(id);
        ResponseEntity<Customer> entity = null;

        if (customer != null){
            entity = new ResponseEntity(customer, HttpStatus.FOUND);
        }
        else{
            entity = new ResponseEntity(customer, HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> list(){
        return new ResponseEntity(customersRepository.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public String save (@RequestBody Customer customer){
        customersRepository.save(customer);
        return "Customer " +customer+ " added";
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        customersRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}