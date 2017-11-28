package gateway.springzuul;

import java.lang.reflect.InvocationTargetException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Application {
	
	
	
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		 SpringApplication.run(Application.class, args);

	}
	
	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
	

}
