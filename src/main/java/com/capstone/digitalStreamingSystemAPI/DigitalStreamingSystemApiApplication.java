package com.capstone.digitalStreamingSystemAPI;

import com.sun.istack.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = "com.capstone.digitalStreamingSystemAPI")
public class DigitalStreamingSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalStreamingSystemApiApplication.class, args);
	}
	
	@Configuration
	public static class CorsConfiguration {
		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(@NotNull CorsRegistry registry) {
					registry.addMapping("/**").allowedOrigins("http://localhost:4200");
					registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
					registry.addMapping("/**").allowedHeaders("*");
					registry.addMapping("/**").exposedHeaders("*");
					registry.addMapping("/**").allowCredentials(true);
					registry.addMapping("/**").maxAge(3600);
				}
			};
		}
	}
}

// Scan the package and find the classes that are annotated.
// Cors configuration for allowing cross-origin requests.