package beanLists;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import otherBeans.OtherBean;
import springConfigs.SpringConfigForOtherBeans;

import java.util.ArrayList;
import java.util.List;

/**
 * OtherBeanA has a @Primary annotation
 */

@Component
public class BeanContainerForTask8 {
    private List<OtherBean> otherBeanList;

    public BeanContainerForTask8(OtherBean otherBean1,
                                 @Qualifier("otherBeanB") OtherBean otherBean2,
                                 @Qualifier("otherBeanC")OtherBean otherBean3) {
        otherBeanList = new ArrayList<>();

        otherBeanList.add(otherBean1);
        otherBeanList.add(otherBean2);
        otherBeanList.add(otherBean3);
    }

    public void printAllElements() {
        for (OtherBean bean : otherBeanList) {
            bean.sayName();
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigForOtherBeans.class);
        BeanContainerForTask8 beanContainer = (BeanContainerForTask8) context.getBean("beanContainerForTask8");
        beanContainer.printAllElements();
    }
}
