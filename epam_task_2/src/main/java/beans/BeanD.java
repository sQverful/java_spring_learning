package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanD implements CustomBeans {

    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private void initMethod() {
        System.out.println("Init beanD" + System.lineSeparator());
    }

    private void destroyMethod() {
        System.out.println("Destroying of beanD" + System.lineSeparator());
    }



}
