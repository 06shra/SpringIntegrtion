package com.javaexpect.springintegrationdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.javaexpect.springintegrationdemo.gateway.OrderGateway;
import com.javaexpect.springintegrationdemo.model.Order;

@RestController
public class OrderController {

    @Autowired
    public OrderGateway orderGateway;

    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody Order order) {
        Message<Order> replyObj = orderGateway.placeOrder(order);
        Order responseObj = replyObj.getPayload();
        return responseObj;
    }
}
