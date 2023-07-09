package com.shivanshu.springdepinj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.shivanshu.springdepinj",
		"com.shivanshu.util"
})
public class SpringDepInjApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringDepInjApplication.class, args);
	}

}
