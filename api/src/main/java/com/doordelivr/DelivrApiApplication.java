package com.doordelivr;

import org.hibernate.validator.internal.xml.XmlMappingParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
@ComponentScan(basePackages="com.doordelivr")
public class DelivrApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelivrApiApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplateConfigurer(RestTemplateBuilder builder)
	{
		return builder.build();
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
