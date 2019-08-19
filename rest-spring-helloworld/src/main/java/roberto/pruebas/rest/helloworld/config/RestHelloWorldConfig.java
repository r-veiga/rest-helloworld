package roberto.pruebas.rest.helloworld.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("roberto.pruebas.rest.helloworld")
public class RestHelloWorldConfig {

}
