//package com.example.lsis.ordersapi;
//
//import com.example.lsis.OrderInfo;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.web.client.RestOperations;
//import java.util.List;
//
//import static org.springframework.http.HttpMethod.GET;
//
//public class OrdersClient {
//
//    private String ordersUrl;
//    private RestOperations restOperations;
//
//    public OrdersClient(String ordersUrl, RestOperations restOperations) {
//        this.ordersUrl = ordersUrl;
//        this.restOperations = restOperations;
//    }
//
//    public void addOrder(OrderInfo order) {
//        restOperations.postForEntity(ordersUrl, order, OrderInfo.class);
//    }
//
//    public OrderInfo find(long id) {
//        return restOperations.getForEntity(ordersUrl + "/" + id, OrderInfo.class).getBody();
//    }
//
//    public List<OrderInfo> getOrderss() {
//        ParameterizedTypeReference<List<OrderInfo>> orderListType = new ParameterizedTypeReference<List<OrderInfo>>() {
//        };
//
//        return restOperations.exchange(ordersUrl, GET, null, orderListType).getBody();
//    }
//}
