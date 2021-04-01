package injectionOfOtherBeans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import otherBeans.OtherBean;
import otherBeans.OtherBeanB;
import otherBeans.OtherBeanC;
import springConfigs.SpringConfigForOtherBeans;

/**
 * This bean shows the Dependency Injection
 * of bean 'OtherBeanB' via field.
 */
@Component
public class OtherBeanCinjection {
    public OtherBeanCinjection() {

    }

    @Autowired
    @Qualifier("otherBeanC")
    private OtherBean otherBeanOne;

    @Autowired
    private OtherBeanB otherBeanTwo;

    public void sayAllNames() {
        otherBeanOne.sayName();
        otherBeanTwo.sayName();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigForOtherBeans.class);
        OtherBeanCinjection otherBeanCinjection = (OtherBeanCinjection) context.getBean("otherBeanCinjection");
        otherBeanCinjection.sayAllNames();
    }
}
