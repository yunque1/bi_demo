package cn.ouo.cloudconsumerorder80.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "SPRING-CLOUD-PROVIDER-8001", configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
