package otherBeans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class OtherBeanB implements OtherBean {
    private String name;
    private int order;

    public OtherBeanB() {
        name = "This is OtherBeanB";
        order = 2;
    }

    @Override
    public void sayName() {
        System.out.println(name);
    }

    @Override
    public void sayOrder() {
        System.out.println("My order = " + order);
    }
}
