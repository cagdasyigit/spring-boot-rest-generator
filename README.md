#### Rest Service Generator For Spring Boot Projects

Simply open App.java file and replace configuration variables for your own project.

Type your project source folder path:
private final static String sourceFolder = "C:/path/to/projects/example/src/main/java/";

Type your main app package:
private final static String mainPackage = "com/example/app";

Type your entity class names (like User, Employee, Role etc)
private final static String[] entityNames = { "ExampleModel" };

Your folder structure must be like this:

Project Folder
|
|-> src/main/java/
	|
	|-> com/example/app/
		|
		|-> dao/
		|-> model/
		|-> rest/
		|-> repositories/
		
If your directory structure must be different, then you need to change templates inside this folder:
src/main/resources/templates/

#### Note: This little helper application only generates Rest services, repositories and dao classes from existing models. So you need to type models manually.

I hope this will save your time, have fun!