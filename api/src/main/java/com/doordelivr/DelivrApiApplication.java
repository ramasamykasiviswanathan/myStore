package com.doordelivr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@SpringBootApplication
@ComponentScan(basePackages="com.doordelivr")
public class DelivrApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelivrApiApplication.class, args);
	}
	
	@Bean
	public ObjectMapper initializeObjectMapper() {
		JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
		jacksonXmlModule.setDefaultUseWrapper(false);		
		ObjectMapper objectMapper = new XmlMapper(jacksonXmlModule);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		return objectMapper;
	}
}
