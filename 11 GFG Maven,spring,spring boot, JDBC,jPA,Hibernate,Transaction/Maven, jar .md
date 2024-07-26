JAR(Java ARchive)
   - Whenever we want to bundle up our classes so that it can be used somewhere.
   - It is the compressed version of all the sourcecode  that we have in our project
   - doesnot include external libraries only contain POM xml but FAT jAR include external libraries
   - ADVANTAGE
       - whenever we want to use 1 class from one project in another project
       

STEPS TO CREATE JAR:
   - Go to File->  project Structure
   - Go to Artifacts
   - Click + and jar
   - From modules with dependencies
   - Then Build -> build Artifacts -> build

IMPORT JAR INSIDE THE NEW PROJECT :
   - Inside the new/client project. Go to File-> project Structure
   - Go to modules -> dependencies
   - Apply then ok 
   - You can use the functions inside the jars.

DISADVANTAGES OF USING JAR :
   - For any changes happening in the jar, we need to re-integrate with the new jar.
   - Task is manual, and keeping track of the versions is very tuff. 



MAVEN
   - Maven is a powerful build automation tool that is primarily used for JAVA projects.
   - Based on the concept of POMs (Project Object Model), dynamically download JAVA libraries or plugins from 
   one or more repositories such as maven central and store them in the local cache.
   - Follows conventions over configuration.
   - Creation of a jar with a version makes importing and exporting easy.
   - Different Commands are present to help installing and importing the jars.

   - Whenever we r creating any maven project we require to tell
         - GroupId    -> com.amazon/org.gfg
         - ArtifactId -> unique identifier for our project
         - Version    -> 1.0-SNAPSHOT / 2.0 / 2.X

   - We r adding only MYSQL connector but why other 2 dependencies added bcoz all transitive dependencies that
   we would require those will be coming in our external id's.


WHERE WE ARE STORING MAVEN
   - .m2 folder : locally store all dependencies, centralized caches
   - our java code 1st see from .m2 folder if it get then it will return from there itself but it will not get
   then it will go to central MAVEN repository. so it will return the response and also it will keep that in 
   .m2 folder so that it can be used later time


STEPS TO MAKE MAVEN PROJECT
   1) File -> new project/From Existing Sources
   2) Build System -> Maven
   3) Advanced Setting -> Set GroupId and the ArtifactId

IMPORT MAVEN PROJECT INSIDE NEW PROJECT :
   1) Just add artifact, group id and the version accordingly 
   2) Refresh the maven 


WHEN TO USE MAVEN:
   - If there are too many dependencies for the project.
   - When the dependencies version changes frequently.
   - Continuous builds, integration and testing can be easily handled by using maven.
   - When one needs an easy way to generate documentation from the source code, compiling the source code, 
   packaging the compiled code into JARs or ZIP files.
   - mvn dependency:tree is to see the dependency tree


LIFECYCLE OF MAVEN:
   - clean: mvn clean -> will clean out Target folder.
   - validate: mvn validate -> just validate we have main and test directory.
   - compile: mvn compile -> compile and check if we have compiled it correctly but only for main folder
   - test: mvn test -> compile and check if we have compiled test and main correctly.
   - package: mvn package -> creates a jar with compilation 
   - verify: mvn verify-> checks if jar is present or not  
   - install: mvn install -> just install jar and pom to m2 folder
   - site: mvn site -> create a site which consists of some reports so that someone can use it.
   - deploy: mvn deploy -> uses some pipeline to deploy your project to some server.



WHEN JAR SHOULD BE USED
  - source code is available
  - Dependent on Language
  i.e whenever we see utility method

WHEN API SHOULD BE USED
  - Dont need source code
  - Language Independent
  i.e whenever we see diff. service



