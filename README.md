#### Rest Service Generator For Spring Boot Projects

Hello, purpose of this little app is automating to create spring boot rest api classes. I have tired and bored to create dao, repo, endpoint classes for every model in every project. This app does create very generic forms of these classes. Standard crud operations will be implemented for every model name you write in App.java.

##### Configuration:
Simply open App.java file and replace configuration variables for your own project.

Type your project source folder path:  
`private final static String sourceFolder = "C:/path/to/projects/example/src/main/java/";`

Type your main app package:  
`private final static String mainPackage = "com/example/app";`

Type your entity class names (like User, Employee, Role etc)  
`private final static String[] entityNames = { "ExampleModel" };`

Your folder structure must be like this:

Project Folder  
|  
|-> src/main/java/  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-> com/example/app/  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-> dao/  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-> model/  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-> rest/  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-> repositories/  
		
If your directory structure must be different, then you need to change templates inside this folder:
`src/main/resources/templates/`

#### Note: This little helper application only generates Rest services, repositories and dao classes from existing models. So you need to type models manually.

I hope this will save your time, have fun!
