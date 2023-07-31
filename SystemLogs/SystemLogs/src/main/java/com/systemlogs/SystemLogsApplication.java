package com.systemlogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemLogsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SystemLogsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SystemLogsApplication.class, args);

//		LOGGER.debug("Debug log message");
		LOGGER.info("Info log message");
		LOGGER.warn("Warning log message");
		LOGGER.error("Error log message");
		System.out.println("Successful");
//		System.out.println(LOGGER);
	}
}
