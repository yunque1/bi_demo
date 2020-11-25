package cn.siwen.cloud.controller;

import cn.siwen.cloud.pojo.CommonResult;
import cn.siwen.cloud.pojo.Payment;
import cn.siwen.cloud.service.PyamentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    String port;
    @Autowired
    private PyamentService pyamentService;

    //ces
    @GetMapping(value = "/index")
    public String sb(){
        return "哈哈";
    }

    //测试
    @GetMapping(value = "/test/consul")
    public String paymentConsul(){
        return "springcloud with consul:"+port+"\t"+ UUID.randomUUID().toString();
    }

    //查
    @GetMapping(value = "/payment/{id}")
    public CommonResult select(@PathVariable Integer id){
        System.out.println("测试"+id);
       /* try {
            Thread.sleep(7000);
        }catch (InterruptedException e){
            e.printStackTrace();;
        }*/
       Payment payments= pyamentService.select(id);
       if (payments!=null){
           return new CommonResult(200,"成功",port);
       }else{
           return new CommonResult(999, "失败");
       }
    }

    //添加
    @PostMapping(value = "/payment/insert")
    public CommonResult insert(@RequestBody Payment payment){
        int i=pyamentService.add(payment);
    if (i>0){
        return new CommonResult(200,"成功",payment.toString());
    }else{
        return new CommonResult(999,"失败");
    }

    }


    //删除
    @GetMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int i=pyamentService.delete(id);
        if (i>0){
            return new CommonResult(200,"成功");
        }else{
            return new CommonResult(999,"失败");
        }
    }

    //改
    @PostMapping(value = "/update")
    public CommonResult update(Payment payment){
        int i=pyamentService.update(payment);
        if (i>0){
            return new CommonResult(200,"成功");
        }else{
            return new CommonResult(999,"失败");
        }
    }
}
