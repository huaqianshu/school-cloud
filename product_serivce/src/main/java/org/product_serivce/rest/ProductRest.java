package org.product_serivce.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shangze/car/bihu")
public class ProductRest {
	@Autowired
	private LoadBalancerClient loadBalancer;
	@Autowired
	private RestTemplate restTemplate;
	
	
	private <T> T post(String service, String company, String method, Object request, Class<T> a) {
		String uri = loadBalancer.choose(service).getUri() + "/shangze/car/" + company + "/" + method;
		return restTemplate.postForObject(uri, request, a);
	}

	
	
}
