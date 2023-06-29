package com.javaexpect.springintegrationdemo.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

import com.javaexpect.springintegrationdemo.model.Order;

@MessagingGateway
public interface OrderGateway {
    
    @Gateway(requestChannel="request-in-channel", replyChannel="order-reply-channel")
    Message<Order> placeOrder(Order order);
}
