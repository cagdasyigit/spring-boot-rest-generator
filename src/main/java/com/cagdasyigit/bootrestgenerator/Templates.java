package com.cagdasyigit.bootrestgenerator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Templates {

	public static String getServiceTemplate(String mainPackage, String entityName) {	
		String mainPackageName = mainPackage.replaceAll("/", ".");
		String fileTemplate = getFile("templates/rest.service.tmpl");
		fileTemplate = fileTemplate.replace("{{mainPackageName}}", mainPackageName);
		fileTemplate = fileTemplate.replace("{{entityName}}", entityName);
		fileTemplate = fileTemplate.replace("{{serviceName}}", entityName.toLowerCase());
		fileTemplate = fileTemplate.replace("{{restServicePrefix}}", "/rest");
		
		return fileTemplate;
	}
	
	public static String getDaoTemplate(String mainPackage, String entityName) {
		String mainPackageName = mainPackage.replaceAll("/", ".");
		String fileTemplate = getFile("templates/dao.tmpl");
		fileTemplate = fileTemplate.replace("{{mainPackageName}}", mainPackageName);
		fileTemplate = fileTemplate.replace("{{entityName}}", entityName);
		
		return fileTemplate;
	}
	
	public static String getRepositoryTemplate(String mainPackage, String entityName) {
		String mainPackageName = mainPackage.replaceAll("/", ".");
		String fileTemplate = getFile("templates/repository.tmpl");
		fileTemplate = fileTemplate.replace("{{mainPackageName}}", mainPackageName);
		fileTemplate = fileTemplate.replace("{{entityName}}", entityName);
		
		return fileTemplate;
	}
	
	private static String getFile(String fileName) {
		StringBuilder result = new StringBuilder("");
		ClassLoader classLoader = Templates.class.getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}
}
