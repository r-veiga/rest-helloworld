package roberto.pruebas.rest.helloworld;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import roberto.pruebas.rest.helloworld.config.RestHelloWorldConfig;

public class MySpringMvcDispatcherServletInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer 
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { RestHelloWorldConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/*" };
	}

}
