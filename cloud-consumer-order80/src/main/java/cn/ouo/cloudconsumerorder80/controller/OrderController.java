package cn.ouo.cloudconsumerorder80.controller;

import cn.siwen.cloud.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private static final  String PARMENTURL="http://SPRING-CLOUD-PROVIDER-8001";
    //http://SPRING-CLOUD-PROVIDER-8001:8001/payment/

    @Autowired
    private RestTemplate restTemplate;

    //测试consul
    /*@GetMapping("/getProvide/consul")
    public String getConsul(){
        String result=restTemplate.getForObject(PARMENTURL+"/test/consul",String.class);
        return result;
    }*/


    @GetMapping("/getProvider/{id}")
    public CommonResult getPayment(@PathVariable Long id){
        return restTemplate.getForObject(PARMENTURL+"/payment/"+id,CommonResult.class,id);
    }


    @PostMapping("/addOrder")
    public CommonResult<Payment> orderCreate(Payment payment){
        return restTemplate.postForObject(PARMENTURL+"/payment/insert/",payment,CommonResult.class);
    }




}
