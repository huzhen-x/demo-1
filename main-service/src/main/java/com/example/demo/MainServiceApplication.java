package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy  //开启网关服务
@EnableDiscoveryClient //注册服务客户端，可以被注册中心发现
@MapperScan("com.example.demo.model.dao")//主要作用是扫包
public class MainServiceApplication {

	//负载均衡
	@Bean  
    @LoadBalanced  
    RestTemplate restTemplate(){  
        return new RestTemplate();  
    }  
	public static void main(String[] args) {
		SpringApplication.run(MainServiceApplication.class, args);
	}
}
