Project 



Please install the below software to run the frame work.
-	Install JAVA VERSION 1.8
-	Install manven 3.6.1
-	Set Environment path for  java and Maven
-	Chrome version should  be ‘103.0.5060.114.

Open CMD and Please run the below commends the below syntax to verify java and maven has been installed properly 
-	mvn –version
-	java –version

Execution instauration:  
- Open intelj or eclipse and open my project.
- Add the Gherkin  Plugins in Intelj
- once open the project , go to Terminal and run the below  comments
   Mvn install

 

-	Once the above is done ,Please  run the below comments to run  in terminal  the projects

mvn clean verify -Dexecution_type=browser -Drunner=DemoRunner.

output will be available in target folder

 Goto target folder --> extent report -- Test report
 
 And open with chorme browser to see the output
 


 

