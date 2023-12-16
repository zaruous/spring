package org.kyj.gargoyle.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Gargoyle Service", version = "1.0", description = "Gargoyle Service"))
public class GargoyleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GargoyleServiceApplication.class, args);
	}

}
