package springConfigs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"otherBeans", "injectionOfOtherBeans", "beanLists"})
public class SpringConfigForOtherBeans {
}
