package beanLists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Component;
import otherBeans.OtherBean;
import springConfigs.SpringConfigForOtherBeans;

import java.util.List;

/**
 * Implementation of task 7.
 * In this task we use beans from otherBeans pkg.
 *
 * OtherBeanA has @Order(3)
 * OtherBeanB has @Order(2)
 * OtherBeanC has @Order(1)
 */
@Component
public class BeanContainer {
    @Autowired
    private List<OtherBean> otherBeanList;

    public void printAllElements() {
        for (OtherBean bean : otherBeanList) {
            bean.sayName();
            bean.sayOrder();
        }
    }

}

