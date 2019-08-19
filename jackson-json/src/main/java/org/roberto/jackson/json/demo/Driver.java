package org.roberto.jackson.json.demo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Driver {
	private static final File pathOutputJsonFolder = new File("src/main/resources/json/output");
	private static final File pathInputJsonFolder = new File("src/main/resources/json/input");
	private static File inputJsonFile;
	private static File outputJsonFile;
	
	{
		for (File f : pathOutputJsonFolder.listFiles()) {
			f.delete();
		}
	}

	private ObjectMapper mapeador = new ObjectMapper(); 	// objeto Jackson
															// imprescindible para
															// transformar

	public static void main(String[] args) 
	throws JsonGenerationException, JsonMappingException, IOException 
	{
		Driver driver = new Driver();
		
		// -------------------------------------------------------------
		// (1) Lee un JSON y crea un objeto instancia de StudentBasico
		// -------------------------------------------------------------
		
		inputJsonFile = new File(pathInputJsonFolder, "sample-studentbasico.json");
		StudentBasico miEstudiante = driver._Json2Pojo_StudentBasico(inputJsonFile);
		
		System.out.println("Creado POJO a partir de JSON:\n" + miEstudiante.toString());
		
		// -------------------------------------------------------------
		// (2) Crea un nuevo JSON a partir de un objeto StudentBasico
		// -------------------------------------------------------------
		
		outputJsonFile = new File(pathOutputJsonFolder, "output-studentbasico.json");
		driver._Pojo2Json_StudentBasico(outputJsonFile, miEstudiante);
		
		System.out.println("\nCreado desde un POJO el JSON:\n" + outputJsonFile.getAbsolutePath());
				
		// -------------------------------------------------------------
		// (3) Lee un JSON y crea un objeto instancia de StudentComplejo
		// -------------------------------------------------------------
		
		inputJsonFile = new File(pathInputJsonFolder, "sample-studentcomplejo.json");
		StudentComplejo miEstudiante2 = driver._Json2Pojo_StudentComplejo(inputJsonFile);
		
		System.out.println("\nCreado POJO a partir de JSON:\n" + miEstudiante2.toString());
		
		// -------------------------------------------------------------
		// (4) Crea un nuevo JSON a partir de un objeto StudentComplejo
		// -------------------------------------------------------------
		
		outputJsonFile = new File(pathOutputJsonFolder, "output-studentcomplejo.json");
		driver._Pojo2Json_StudentComplejo(outputJsonFile, miEstudiante2);
		
		System.out.println("\nCreado desde un POJO el JSON:\n" + outputJsonFile.getAbsolutePath());
				
		// -------------------------------------------------------------
		// (5) Lee un JSON y crea un objeto instancia de StudentBasicoIgnoraPropiedadesJson
		//     En este caso, el JSON tiene más propiedades que el POJO 
		//     lo que debería lanzar una excepción en ejecución 
		//     pero se evita con la anotación @JsonIgnoreProperties 
		//     que se emplea en la clase StudentBasicoIgnoraPropiedadesJson
		// -------------------------------------------------------------
		
		inputJsonFile = new File(pathInputJsonFolder, "sample-studentcomplejo.json");
//		miEstudiante = driver._Json2Pojo_StudentBasico(inputJsonFile);
		miEstudiante = driver._Json2Pojo_StudentBasicoIgnoraPropiedadesJson(inputJsonFile);
		
		System.out.println(
				"\nCreado POJO a partir de JSON con datos de más, no declarados en el POJO:\n" 
				+ miEstudiante.toString());
		
	}

	private StudentBasico _Json2Pojo_StudentBasico(File jsonFile) 
	throws JsonParseException, JsonMappingException, IOException 
	{
		StudentBasico auxStudent = null;
		auxStudent = mapeador.readValue(jsonFile, StudentBasico.class);
		return auxStudent;
	}
	
	private void _Pojo2Json_StudentBasico(File jsonOutput, StudentBasico estudiante) 
			throws JsonGenerationException, JsonMappingException, IOException 
	{
		estudiante.setActive(!estudiante.isActive());	// Toggle estudiante.active
		
		mapeador.enable(SerializationFeature.INDENT_OUTPUT);
		mapeador.writeValue(jsonOutput, estudiante);
	}

	private StudentComplejo _Json2Pojo_StudentComplejo(File jsonFile) 
	throws JsonParseException, JsonMappingException, IOException 
	{
		StudentComplejo auxStudent = null;
		auxStudent = mapeador.readValue(jsonFile, StudentComplejo.class);
		return auxStudent;
	}
	
	
	private void _Pojo2Json_StudentComplejo(File jsonOutput, StudentComplejo estudiante) 
	throws JsonGenerationException, JsonMappingException, IOException 
	{
		estudiante.setActive(!estudiante.isActive());	// Toggle estudiante.active
		
		mapeador.enable(SerializationFeature.INDENT_OUTPUT);
		mapeador.writeValue(jsonOutput, estudiante);
	}
	
	private StudentBasico _Json2Pojo_StudentBasicoIgnoraPropiedadesJson(File jsonFile) 
			throws JsonParseException, JsonMappingException, IOException 
	{
		StudentBasico auxStudent = null;
		auxStudent = mapeador.readValue(jsonFile, StudentBasicoIgnoraPropiedadesJson.class);
		return auxStudent;
	}

}
