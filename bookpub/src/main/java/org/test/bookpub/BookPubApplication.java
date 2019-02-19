package org.test.bookpub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
* @SpringBootApplicaton annotation:
* @Configuration
* @EnableAutoConfiguration
* @ComponentScan
@Configuration tells Spring (and not just Spring Boot, as it is a Spring Framework
core annotation) that the annotated class contains Spring configuration definitions
such as the @Bean, @Component, and @Service declarations, and others.
@ComponentScan tells Spring that we want to scan our application packages—starting
from the package of our annotated class as a default package root—for the other
classes that might be annotated with @Configuration, @Controller, and other
applicable annotations, which Spring will automatically include as part of the context
configuration.
@EnableAutoConfiguration is a part of the Spring Boot annotation, which is a meta-annotation
on its own (you will find that Spring libraries rely very heavily on the
meta-annotations in order to group and compose configurations together).It imports
the EnableAutoConfigurationImportSelector and
AutoConfigurationPackages.Registrar classes that effectively instruct Spring to
automatically configure the conditional beans depending on the classes available in
the classpath.
* */

/*
* To run the application:
* mvn spring-boot:run
 * */

@SpringBootApplication
public class BookPubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookPubApplication.class, args);
	}

	@Bean
	public StartupRunner schedulerRunner(){
		return new StartupRunner();
	}
}
