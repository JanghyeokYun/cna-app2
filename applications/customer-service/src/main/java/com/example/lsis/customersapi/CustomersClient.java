//package com.example.lsis.customersapi;
//
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.web.client.RestOperations;
//import java.util.List;
//
//import static org.springframework.http.HttpMethod.GET;
//
//public class CustomersClient {
//
//    private String customerUrl;
//    private RestOperations restOperations;
//
//    public CustomersClient(String customersUrl, RestOperations restOperations) {
//        this.customerUrl = customersUrl;
//        this.restOperations = restOperations;
//    }
//
//    public void addCustomer(CustomerInfo customer) {
//        restOperations.postForEntity(customerUrl, customer, CustomerInfo.class);
//    }
//
//    public CustomerInfo find(long id) {
//        return restOperations.getForEntity(customerUrl + "/" + id, CustomerInfo.class).getBody();
//    }
//
//    public List<CustomerInfo> getCustomerss() {
//        ParameterizedTypeReference<List<CustomerInfo>> customerListType = new ParameterizedTypeReference<List<CustomerInfo>>() {
//        };
//
//        return restOperations.exchange(customerUrl, GET, null, customerListType).getBody();
//    }
//}
