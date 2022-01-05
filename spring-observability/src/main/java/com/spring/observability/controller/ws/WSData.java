package com.spring.observability.controller.ws;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 
@Getter
@Setter
@NoArgsConstructor
public class WSData {
    private WSCustomer userData;
    private String notificationStatus;
    private String quote;
}
