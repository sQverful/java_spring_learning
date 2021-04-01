package injectionOfOtherBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import otherBeans.OtherBean;
import otherBeans.OtherBeanA;
import springConfigs.SpringConfigForOtherBeans;


/**
 * This bean shows the Dependency Injection
 * of bean 'OtherBeanA' via constructor.
 */

@Component
public class OtherBeanAinjection {
    private OtherBean otherBeanOne;
    private OtherBean otherBeanTwo;


    @Autowired
    public OtherBeanAinjection(@Qualifier("otherBeanA") OtherBean otherBeanOne,
                               @Qualifier("otherBeanB") OtherBean otherBeanTwo) {
        this.otherBeanOne = otherBeanOne;
        this.otherBeanTwo = otherBeanTwo;

    }

    public void sayBothNames() {
        otherBeanOne.sayName();
        otherBeanTwo.sayName();
    }


}
