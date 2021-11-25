package com.erc.his;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Harun ERGUL
 * @date 11.03.2021
 * @note Entry point for application
 */

@SpringBootApplication
public class ServerRunner implements Serializable{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		SpringApplication.run(ServerRunner.class, args);
	}
}
