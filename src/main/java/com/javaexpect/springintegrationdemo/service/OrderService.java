package com.javaexpect.springintegrationdemo.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.javaexpect.springintegrationdemo.model.Order;

@Service
public class OrderService {
    
    @ServiceActivator(inputChannel="request-in-channel", outputChannel="order-process-channel")
    public Message<Order> placeOrder(Message<Order> order) {
        return order;
    }

    @ServiceActivator(inputChannel="order-process-channel", outputChannel="order-reply-channel")
    public Message<Order> processOrder(Message<Order> order) {
        order.getPayload().setOrderStatus("order successfully placed!!!!");
        return order;
    }

    @ServiceActivator(inputChannel="order-reply-channel")
    public Message<Order> replyOrder(Message<Order> order) {
        return MessageBuilder.withPayload(order.getPayload()).build();
    }
}
