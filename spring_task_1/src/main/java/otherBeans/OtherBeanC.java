package otherBeans;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class OtherBeanC implements OtherBean {
    private String name;
    private int order;

    public OtherBeanC() {
        name = "This is OtherBeanC";
        order = 1;
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
