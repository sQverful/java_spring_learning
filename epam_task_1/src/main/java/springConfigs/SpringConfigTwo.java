package springConfigs;

import beans3.BeanD;
import beans3.BeanF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"beans2"})
public class SpringConfigTwo {

    @Bean
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    public BeanF beanF() {
        return new BeanF();
    }
}
