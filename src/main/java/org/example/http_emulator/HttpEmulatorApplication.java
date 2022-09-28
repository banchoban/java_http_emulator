package org.example.http_emulator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.nio.file.Paths;

@SpringBootApplication
public class HttpEmulatorApplication {

	public static void main(String[] args) {

		File file = new File(".\\src\\main\\resources\\log4j2.xml");

		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		context.setConfigLocation(file.toURI());

		Logger logger = LogManager.getRootLogger();
		logger.info(Paths.get(".").toAbsolutePath().normalize().toString());

		SpringApplication.run(HttpEmulatorApplication.class, args);
	}

}
