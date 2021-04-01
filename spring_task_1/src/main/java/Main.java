import beanLists.BeanContainer;
import beanLists.BeanContainerForTask8;
import injectionOfOtherBeans.OtherBeanAinjection;
import injectionOfOtherBeans.OtherBeanBinjection;
import injectionOfOtherBeans.OtherBeanCinjection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springConfigs.SpringConfigForOtherBeans;
import springConfigs.SpringConfigOne;
import springConfigs.SpringConfigTwo;


public class Main {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigOne.class);
        System.out.println("===============TASK 3. Components scan of beans1 package=================");
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }
        System.out.println("=============================END================================");

        ////////////////////////////////

        context = new AnnotationConfigApplicationContext(SpringConfigTwo.class);
        System.out.println("===============TASK 4.Components scan of beans1 package=================");
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }
        System.out.println("=============================END================================");

        ///////////////////////////////

        context = new AnnotationConfigApplicationContext(SpringConfigForOtherBeans.class);
        System.out.println("=======================TASK 6===================================");
        System.out.println("DI via constructor");
        OtherBeanAinjection otherBeanAinjection = (OtherBeanAinjection) context.getBean("otherBeanAinjection");
        otherBeanAinjection.sayBothNames();

        System.out.println("DI via setter");
        OtherBeanBinjection otherBeanBinjection = (OtherBeanBinjection) context.getBean("otherBeanBinjection");
        otherBeanBinjection.sayAllNames();

        System.out.println("DI via fields");
        OtherBeanCinjection otherBeanCinjection = (OtherBeanCinjection) context.getBean("otherBeanCinjection");
        otherBeanCinjection.sayAllNames();
        System.out.println("========================END=====================================");

        ///////////////////////////////

        System.out.println("=======================TASK 7===================================");
        BeanContainer beanContainer = (BeanContainer) context.getBean("beanContainer");
        beanContainer.printAllElements();
        System.out.println("========================END=====================================");

        //////////////////////////////

        System.out.println("=======================TASK 8===================================");
        BeanContainerForTask8 beanContainerForTask8 = (BeanContainerForTask8) context.getBean("beanContainerForTask8");
        beanContainerForTask8.printAllElements();
        System.out.println("========================END=====================================");


    }
}
