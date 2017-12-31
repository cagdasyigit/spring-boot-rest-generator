package com.cagdasyigit.bootrestgenerator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class App {

	private final static String sourceFolder = "C:/path/to/projects/example/src/main/java/";

	private final static String mainPackage = "com/example/app";

	private final static String[] entityNames = { "ExampleModel" };

	public static void main(String[] args) {
		parseEntities();
	}

	private static void parseEntities() {
		for (String entityName : entityNames) {
			// Rest Service
			String serviceTemplate = Templates.getServiceTemplate(mainPackage, entityName);
			createFile("rest", entityName + "Service.java", serviceTemplate);
			
			// Dao Object
			String daoTemplate = Templates.getDaoTemplate(mainPackage, entityName);
			createFile("dao", entityName + "Dao.java", daoTemplate);

			// Repository
			String repositoryTemplate = Templates.getRepositoryTemplate(mainPackage, entityName);
			createFile("repositories", entityName + "Repository.java", repositoryTemplate);
		}
	}	

	private static void createFile(String folderName, String fileName, String fileTemplate) {
		PrintWriter writer;

		try {
			writer = new PrintWriter(sourceFolder + mainPackage + "/" + folderName + "/" + fileName, "UTF-8");
			writer.print(fileTemplate);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
