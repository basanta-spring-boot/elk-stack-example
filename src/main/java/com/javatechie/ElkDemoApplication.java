package com.javatechie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ElkDemoApplication {

    Logger logger = LoggerFactory.getLogger(ElkDemoApplication.class);

    @GetMapping("/covid19/{report}")
    public String covid19(@PathVariable String report) {
        if (report.equals("negative")) {
        	logger.info("Input Parameter {}",report);
            return "Thanks to God (Stay at home)";
        } else {
            try {
                throw new Exception("Please consult with doctor");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Exception occured {}",e.getMessage());
            }
        }
        return "";
    }

    public static void main(String[] args) {
        SpringApplication.run(ElkDemoApplication.class, args);
    }

}
