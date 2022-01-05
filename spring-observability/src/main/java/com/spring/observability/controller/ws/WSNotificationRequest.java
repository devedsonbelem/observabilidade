package com.spring.observability.controller.ws;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
public class WSNotificationRequest {
    private String notificationType;
    private String channel;
}
