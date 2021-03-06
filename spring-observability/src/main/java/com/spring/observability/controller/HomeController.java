package com.spring.observability.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.observability.controller.ws.WSCustomer;
import com.spring.observability.controller.ws.WSData;
import com.spring.observability.controller.ws.WSNotificationRequest;
import com.spring.observability.controller.ws.WSNotificationResponse;
import com.spring.observability.controller.ws.WSQuote;

@RestController
@RequestMapping("/api")
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/data")
	public ResponseEntity<WSCustomer> getData(@RequestBody WSCustomer request) {
		WSCustomer registerUser =  registerCustomers(request) ;
        WSNotificationResponse notificationResponse = sendNotification();
		  WSQuote quote = getRandomQuote();
		  WSData data = new WSData();
		  data.setUserData(registerUser);
		  data.setNotificationStatus(notificationResponse.getResult());
		  data.setQuote(quote.getQuote());
 
		return ResponseEntity.ok(registerUser);
	}

	private WSCustomer registerCustomers(WSCustomer customers) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<WSCustomer> entity = new HttpEntity<>(customers, headers);
		ResponseEntity<WSCustomer> responseEntity = restTemplate.exchange("http://localhost:8082/api/register",
				HttpMethod.POST, entity, WSCustomer.class);
		return responseEntity.getBody();
	}

    private WSNotificationResponse sendNotification() {
        WSNotificationRequest request = new WSNotificationRequest();
        request.setChannel("Email");
        request.setNotificationType("Registration Email");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <WSNotificationRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<WSNotificationResponse> responseEntity = restTemplate.exchange("http://localhost:8083/api/notification", HttpMethod.POST,
                entity, WSNotificationResponse.class);
        return responseEntity.getBody();
    }

    private WSQuote getRandomQuote() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <WSQuote> entity = new HttpEntity<>(headers);
        ResponseEntity<WSQuote> responseEntity = restTemplate.exchange("http://localhost:8084/api/tips/random", HttpMethod.GET,
                entity, WSQuote.class);
        return responseEntity.getBody();
    }
}
