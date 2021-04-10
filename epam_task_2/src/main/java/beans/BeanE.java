package beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE implements CustomBeans{
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @PostConstruct
    private void onPostConstruct() {
        System.out.println("PostConstructing of beanE" + System.lineSeparator());
    }

    @PreDestroy
    private void onPreDestroy() {
        System.out.println("PreDestroying of beanE" + System.lineSeparator());
    }
}
