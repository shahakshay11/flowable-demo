package com.example.demo.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.flowable.engine.DynamicBpmnService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BpmnParserService {

	@Autowired
	DynamicBpmnService dynamicBpmnService;

	public void parseBPMNJson() {

		/*
		 * 1. Read the samplebpmn into json object 2.
		 * 
		 * 
		 **/

		// BpmnModel bpmnModel = new BpmnModel();

		// dynamicBpmnService.get
		// File f = new File("processes/samplebpmn.json");
		
		

		//File file = new File(getClass().getResource("resources/samplebpmn.json").getFile());

		// JsonNode mySchema = JsonLoader.fromFile(file);

//		JSONParser parser = new JSONParser();
//        //Use JSONObject for simple JSON and JSONArray for array of JSON.
//        JSONObject data = (JSONObject) parser.parse(
//              new FileReader("/resources/config.json"));//path to the JSON file.
		
//		ClassLoader classLoader = getClass().getClassLoader();
//		File file2 = new File(classLoader.getResource("jsonschema.json").getFile());
//		JsonNode mySchema = JsonLoader.fromFile(file);

		//TODO Not getting the file here FIX this.
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

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
