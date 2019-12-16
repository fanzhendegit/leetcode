package com.fz.leetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fanzhen
 * @date 2018-06-22 19:31
 */
@SpringBootApplication(scanBasePackages = {"com.fz.leetcode"})
public class ApplicationOne {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationOne.class, args);
	}

}