package ru.stoupin.jsfdemo;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.Forward;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.springframework.context.annotation.Configuration;


@RewriteConfiguration	
@Configuration
public class JsfRewriteConfiguration  extends HttpConfigurationProvider {
	static final Logger log = LogManager.getLogger(JsfRewriteConfiguration.class);
	@Override
	public org.ocpsoft.rewrite.config.Configuration getConfiguration(ServletContext context) {
		 log.info("Binding mappings");

		return ConfigurationBuilder.begin()
			       .addRule()
			         .when(Direction.isInbound().and(Path.matches("/")))
			         .perform(Forward.to("/hello.jsf"))
			       .addRule()
			         .when(Direction.isInbound().and(Path.matches("/cars")))
			         .perform(Forward.to("/cars.jsf"))				  
			       .addRule()
			         .when(Direction.isInbound().and(Path.matches("/some-param/{exampleParam}")))
			         .perform(Forward.to("/hello.jsf?myParam={exampleParam}"));
	}

	@Override
	public int priority() {
		// TODO Auto-generated method stub
		return 0;
	}

}
