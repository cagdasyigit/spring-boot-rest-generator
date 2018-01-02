package com.cagdasyigit.bootrestgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class App {

	private final static String sourceFolder = "C:/path/to/projects/example/src/main/java/";

	private final static String mainPackage = "com/example/app";

	private static List<String> entityNames = new ArrayList<String>();

	public static void main(String[] args) {
		// Uncomment this line for adding manuel model name
		// entityNames.add("MyModel");		
		
		// Use this method for auto parsing model classes
		parseEntityNamesFromFolder("model");
		parseEntities();
	}

	private static void parseEntityNamesFromFolder(String modelFolder) {
		try {
			File dir = new File(sourceFolder.concat(mainPackage).concat("/" + modelFolder));
			File[] directoryListing = dir.listFiles();
			if (directoryListing != null) {
				for (int i = 0; i < directoryListing.length; i++) {
					File child = directoryListing[i];
					String temp = child.getName().replace(".java", "");
					entityNames.add(temp);
				}

			} else {
				// Handle the case where dir is not really a directory.
				// Checking dir.isDirectory() above would not be sufficient
				// to avoid race conditions with another process that deletes
				// directories.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
