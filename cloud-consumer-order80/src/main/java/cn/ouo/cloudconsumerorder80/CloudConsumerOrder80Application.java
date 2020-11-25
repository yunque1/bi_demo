package cn.ouo.cloudconsumerorder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudConsumerOrder80Application {

    @Bean
    @LoadBalanced//启用负载均衡机制
    public RestTemplate restTemplate(){
        return new RestTemplate();

    }

    public static void main(String[] args)
    {
        SpringApplication.run(CloudConsumerOrder80Application.class, args);
    }

}
