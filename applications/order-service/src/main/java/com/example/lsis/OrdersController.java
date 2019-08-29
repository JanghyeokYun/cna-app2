package com.example.lsis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrdersRepository ordersRepository;

    private final String customerURL = "http://localhost:8081/customer";

    public OrdersController(OrdersRepository ordersRepository) {

        this.ordersRepository = ordersRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderInfo> findById (@PathVariable Long id) {
        return new ResponseEntity(getOrderInfo(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity list(){
        return new ResponseEntity(ordersRepository.findAll(), HttpStatus.ACCEPTED);
    }


    private OrderInfo getOrderInfo(Long id)    {
        OrderInfo info = new OrderInfo();
        Optional<Order> order = ordersRepository.findById(id);

        if (order.isPresent())
        {
            Customer customer = new RestTemplate().getForObject(customerURL +"/"+id, Customer.class);
            info.setOrder(order.get());
            info.setCustomer(customer);
        }

        return info;
    }

    public String save (@RequestBody Order order){
        try{
            ordersRepository.save(order);
        }catch(Exception e)
        {
            throw e;
        }

        return "order " +order+ " added";
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ordersRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }




//    @GetMapping("{id}")
//    public ResponseEntity<Order> find (@PathVariable Long id){
//        Optional<Order> order = ordersRepository.findById(id);
//        ResponseEntity<Order> entity = null;
//
//        if (order != null){
//            entity = new ResponseEntity(order, HttpStatus.FOUND);
//        }
//        else{
//            entity = new ResponseEntity(order, HttpStatus.NOT_FOUND);
//        }
//
//        return entity;
//    }

//    @GetMapping
//    public ResponseEntity<List<Order>> list(){
//        return new ResponseEntity(ordersRepository.findAll(), HttpStatus.ACCEPTED);
//    }

//    @PostMapping
//    public String save (@RequestBody Order order){
//        ordersRepository.save(order);
//        return "order " +order+ " added";
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity delete(@PathVariable Long id) {
//        ordersRepository.deleteById(id);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }

//    private OrdersRepository ordersRepository;
//
//
//    public OrdersController(OrdersRepository customersRepository) {
//
//        this.ordersRepository = customersRepository;
//    }
//
//    @PostMapping
//    public void addAlbum(@RequestBody Order customer) {
//
//        ordersRepository.addOrder(customer);
//    }
//
//    @GetMapping
//    public List<Order> index() {
//
//        return ordersRepository.getOrders();
//    }
//
//    @GetMapping("/{orderId}")
//    public Order details(@PathVariable long albumId) {
//
//        return ordersRepository.find(albumId);
//    }

}
