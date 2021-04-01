package injectionOfOtherBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import otherBeans.OtherBeanA;
import otherBeans.OtherBeanB;

/**
 * This bean shows the Dependency Injection
 * of bean 'OtherBeanB' via setter.
 */

@Component
public class OtherBeanBinjection {
    private OtherBeanB otherBeanB;
    private OtherBeanA otherBeanA;

    public OtherBeanBinjection() {
    }

    public void sayAllNames() {
        otherBeanB.sayName();
        otherBeanA.sayName();
    }

    @Autowired
    public void setOtherBeanB(OtherBeanB otherBeanB) {
        this.otherBeanB = otherBeanB;
    }

    @Autowired
    public void setOtherBeanA(OtherBeanA otherBeanA) {
        this.otherBeanA = otherBeanA;
    }
}
