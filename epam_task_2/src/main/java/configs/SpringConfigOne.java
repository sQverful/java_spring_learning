package configs;

import beans.*;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:bean-configurator.properties")
public class SpringConfigOne {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

    @Bean
    public static BeanFactoryPostProcessorImpl beanFactoryPostProcessorImpl() {
        return new BeanFactoryPostProcessorImpl();
    }

    @Bean
    public static BeanPostProcessorImpl beanPostProcessor() {
        return new BeanPostProcessorImpl();
    }
}
