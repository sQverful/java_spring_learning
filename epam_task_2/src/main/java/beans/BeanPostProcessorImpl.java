package beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("PostProcessBeforeInitialization started...");
        Class beanClass = bean.getClass();
        if (bean instanceof CustomBeans) {
            try {
                Field nameField = beanClass.getDeclaredField("name");
                nameField.setAccessible(true);
                Field valueField = beanClass.getDeclaredField("value");
                valueField.setAccessible(true);

                String nameStr = (String) nameField.get(bean);
                int valueInt = (int) valueField.get(bean);

                if (nameStr == null || valueInt <= 0) {
                    System.err.println(beanName + " VALIDATION FAILED. Bean contains null name or value <=0. " + bean);
                    return bean;
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

            System.out.println("Validation done. Everything is OK!");
        }
        System.out.println("bean=" + bean + ", beanName=" + beanName);
        System.out.println("PostProcessBeforeInitialization ended...\n");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("PostProcessAfterInitialization started...");
        System.out.println("Doing nothing...");
        System.out.println("bean=" + bean + ", beanName=" + beanName);
        System.out.println("PostProcessAfterInitialization ended...\n");
        return bean;
    }
}
