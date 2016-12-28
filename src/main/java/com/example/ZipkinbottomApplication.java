package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ZipkinbottomApplication {

	private static final Logger LOG = Logger.getLogger(ZipkinbottomApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ZipkinbottomApplication.class, args);
	}

    @RequestMapping("/")
    public String home(){
        LOG.log(Level.INFO, "Bottom is being called");
        LOG.log(Level.INFO, "Testing by LWA!");
        return "Hello World|BOTTOM";
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }

}
