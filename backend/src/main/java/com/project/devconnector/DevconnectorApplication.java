package com.project.devconnector;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

@SpringBootApplication
public class DevconnectorApplication {
	@Bean
	public Cloudinary cloudinaryConfig() {
	    Cloudinary cloudinary = null;
	    Map config = new HashMap();
	    config.put("cloud_name", "");
	    config.put("api_key", "");
	    config.put("api_secret", "");
	    cloudinary = new Cloudinary(config);
	    return cloudinary;
	}
	public static void main(String[] args) {
		SpringApplication.run(DevconnectorApplication.class, args);
	}

}
