package cloudconsumerhystrix80.hystrix80.controller;

import cn.siwen.cloud.pojo.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@DefaultProperties(defaultFallback = "fallBackMethod") // 指定一个类的全局熔断方法
public class UserController {
    private static final  String PARMENTURL="http://SPRING-CLOUD-PROVIDER-8001";
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getProvider/{id}")
    //用来声明一个降级逻辑的方法(fallbackMethod = "queryUserByIdFallBack")
    @HystrixCommand
    public CommonResult getPayment(@PathVariable Long id){
        if(id==1){
            throw  new RuntimeException("太忙了");
        }
        return restTemplate.getForObject(PARMENTURL+"/payment/"+id,CommonResult.class,id);
    }

    public CommonResult queryUserByIdFallBack(Long id){
        return new CommonResult(300,"请求繁忙，请稍后再试！");
    }

    //全局熔断方法
    /**
     * 熔断方法
     * 返回值要和被熔断的方法的返回值一致
     * 熔断方法不需要参数
     * @return
     */
    public CommonResult fallBackMethod(){
        return new CommonResult(300,"请求繁忙，请稍后再试！");
    }


}
