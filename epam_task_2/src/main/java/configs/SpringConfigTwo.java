package configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SpringConfigOne.class)
public class SpringConfigTwo {
}
