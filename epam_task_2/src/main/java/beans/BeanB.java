package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@PropertySource("bean-configurator.properties")
public class BeanB implements CustomBeans {

    @Value("${beanB.name}")
    private String name;

    @Value("${beanB.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private void initMethod() {
        System.out.println("Init of beanB" + System.lineSeparator());
    }

    private void anotherInitMethod() {
        System.out.println("Another init of beanB" + System.lineSeparator());
    }

    private void destroyMethod() {
        System.out.println("Destroying of beanB" + System.lineSeparator());
    }

}
