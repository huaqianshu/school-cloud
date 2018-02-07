package org.product_serivce.rest;

import javax.servlet.http.HttpServletRequest;

import org.bson.Document;
import org.product_serivce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.school.base.entity.Product;
import com.school.base.messanger.Result;

@RestController
@RequestMapping("/schoolshoping/product")
public class ProductRest {
	@Autowired
	private LoadBalancerClient loadBalancer;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private ProductService productService;
	private <T> T post(String service, String target, String method, Object request, Class<T> a) {
		String uri = loadBalancer.choose(service).getUri() + "/schoolshoping/" + target + "/" + method;
		return restTemplate.postForObject(uri, request, a);
	}

	
	@CrossOrigin(origins = "*")
	@RequestMapping("saveProduct")
	public Result saveProduct() {
		try {
			String ownerid = request.getParameter("userid");
			String price = request.getParameter("price");
			String name = request.getParameter("name");
			Product product = new Product();
			product.setName(name);
			product.setOwnerId(ownerid);
			product.setPrice(price);
			Result result = this.post("product-service", "product", "save", product, Result.class);
			return result;
		}catch(Exception e) {
			return new Result(-1,"fail");
		}
	}
	@CrossOrigin(origins = "*")
	@RequestMapping("save")
	public Result save(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
}
