package otherBeans;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Primary
@Order(3)
public class OtherBeanA implements OtherBean {
    private String name;
    private int order;

    public OtherBeanA() {
        name = "This is OtherBeanA";
        order = 3;
    }

    @Override
    public void sayName() {
        System.out.println(name);;
    }

    @Override
    public void sayOrder() {
        System.out.println("My order = " + order);
    }


}


