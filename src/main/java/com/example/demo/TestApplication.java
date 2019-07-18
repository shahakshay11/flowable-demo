package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.editor.language.json.converter.BpmnJsonConverter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);

		BpmnJsonConverter bpmnJsonConverter = new BpmnJsonConverter();	
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		File file = new File(classLoader.getResource("samplebpmn.json").getFile());

		JSONParser parser = new JSONParser();
		try {

//			InputStream resource = new ClassPathResource(
//				      "resources/samplebpmn.json").getInputStream();

			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));

			ObjectMapper mapper = new ObjectMapper();

			InputStream exampleInput = new FileInputStream(file);

			JsonNode rootNode = mapper.readTree(exampleInput);
			
			BpmnModel bpmnModel = bpmnJsonConverter.convertToBpmnModel(rootNode);
			
			/* Update the userTask or the service task on the bpmn model using the id
			 * 
			 * */
			
			
			

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
