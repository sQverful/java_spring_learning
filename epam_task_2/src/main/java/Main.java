import beans.BeanD;
import beans.BeanF;
import configs.SpringConfigTwo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigTwo.class);
        System.out.println("\nPrinting all beans from context... \n");
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }

        BeanD beanD = (BeanD) context.getBean("beanD");

        System.out.println(System.lineSeparator() + "Getting from context beanF (@Lazy)..." + System.lineSeparator());
        BeanF beanF = (BeanF) context.getBean("beanF");
    }
}
