package com.forever;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author LENOVO
 */
@SpringBootApplication
@MapperScan("com.forever.mapper")
public class MybatisDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}
}
