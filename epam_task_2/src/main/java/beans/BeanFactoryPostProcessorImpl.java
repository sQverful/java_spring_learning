package beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("PostProcessBeanFactory started...");
        GenericBeanDefinition bean = new GenericBeanDefinition();
        bean.setBeanClass(BeanB.class);
        bean.setInitMethodName("anotherInitMethod");
        ((DefaultListableBeanFactory) configurableListableBeanFactory).registerBeanDefinition("beanB", bean);
        System.out.println("Changed init method in " + bean.getBeanClassName());
        System.out.println("PostProcessBeanFactory ended...\n");


    }
}
