package beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean, CustomBeans {
    private String name;
    private int value;

    public BeanA() {

    }

    public BeanA(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After properties set of beanA..." + System.lineSeparator());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying of beanA..." + System.lineSeparator());
    }


}
