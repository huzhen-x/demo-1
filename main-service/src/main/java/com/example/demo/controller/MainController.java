package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController //REST风格控制器
@EnableCircuitBreaker //开启断路器
public class MainController {
	@Autowired  
    RestTemplate restTemplate;//负载均衡
	
	protected static Logger logger=LoggerFactory.getLogger(MainController.class);  
  
	@HystrixCommand(fallbackMethod = "productServiceFallback")//断路器，请求失败后执行的回调方法
    @RequestMapping(value = "/product/hello",method = RequestMethod.GET)  
    public String productHello(){  
        return restTemplate.getForEntity("http://product-service/hello",String.class).getBody();  
    }  
	
	@HystrixCommand(fallbackMethod = "productServiceFallback")
    @RequestMapping(value = "/product_in/hello",method = RequestMethod.GET)  
    public String produc1tHello(){  
        return restTemplate.getForEntity("http://product-service/order_in/hello",String.class).getBody();  
    }  
  
	@HystrixCommand(fallbackMethod = "productServiceFallback")
    @RequestMapping(value = "/order/hello",method = RequestMethod.GET)  
    public String orderHello(){  
		logger.debug("访问hello");  
        return restTemplate.getForEntity("http://order-service/hello",String.class).getBody();  
    }  
    
	@HystrixCommand(fallbackMethod = "productServiceFallback")
    @RequestMapping(value = "/user/tree",method = RequestMethod.GET)  
    public String userTree(){  
        return restTemplate.getForEntity("http://user-service/user/tree",String.class).getBody();  
    }  
	
	@HystrixCommand(fallbackMethod = "productServiceFallback")
    @RequestMapping(value = "/user/grid",method = RequestMethod.GET)  
    public String userGrid(){  
        return restTemplate.getForEntity("http://user-service/user/tree",String.class).getBody();  
    }  
	
    public String productServiceFallback(){  
        return "product服务不见了，稍后再试111";  
    }  
}
