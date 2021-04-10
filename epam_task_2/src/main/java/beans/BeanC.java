package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@PropertySource("bean-configurator.properties")
public class BeanC implements CustomBeans{

    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private void initMethod() {
        System.out.println("Init beanC" + System.lineSeparator());
    }

    private void destroyMethod() {
        System.out.println("Destroying of beanC" + System.lineSeparator());
    }

}
