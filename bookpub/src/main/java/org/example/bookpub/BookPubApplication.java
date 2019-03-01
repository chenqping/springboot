package org.example.bookpub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

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

@EnableScheduling, as many other annotations that we have discussed and will discuss in this book, is
not a Spring Boot; it is a Spring Context module annotation. Similar to the @SpringBootApplication and
@EnableAutoConfiguration annotations, this is a meta-annotation and internally
imports SchedulingConfiguration via the @Import(SchedulingConfiguration.class) instruction, which can be
found inside ScheduledAnnotationBeanPostProcessor that will be created by the imported configuration and
will scan the declared Spring beans for the presence of the @Scheduled annotations. For every annotated
method without arguments, the appropriate executor thread pool will be created. It will manage the
scheduled invocation of the annotated method.

@Bean is a method-level annotation and a direct analog of the XML <bean/> element. The annotation supports
most of the attributes offered by <bean/>, such as: init-method, destroy-method, autowiring, lazy-init,
dependency-check, depends-on and scope.

* */

/*
* To run the application:
* mvn spring-boot:run
 * */

@SpringBootApplication
@EnableScheduling
public class BookPubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookPubApplication.class, args);
	}

	@Bean
	public StartupRunner schedulerRunner(){
		return new StartupRunner();
	}
}
