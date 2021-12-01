package pl.poznan.put.ces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaRepositories
public class CesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/faculties").allowedOrigins("*");
				registry.addMapping("/faculties/*").allowedOrigins("*");
				registry.addMapping("/faculties/*/courses").allowedOrigins("*");
				registry.addMapping("/faculties/*/courses/*").allowedOrigins("*");
			}
		};
	}
}
