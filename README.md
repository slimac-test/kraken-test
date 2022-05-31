# kraken-test
Small repo for kraken API test suite

Project file contains following directories:

-	target\gatling results from example run
-	target\test-classes\ compiled Gatling/Scala code to execute test 
-	src\test\ main testo source directory
*	scala\config contains files with configuration classes. In this place we set defaults that can be further changed with gatling run parameters.
*	scala\requests contains classes for each witch http request level functions. Here we are configuring http requests headers, parameters, parsing response doing checks. 
*	scala\scenarios here we are grouping requests into scenarios and configuring scenarios 
*	scala\simulations here we are keeping simulation that are grouping scenarios and configuring parameters for whole simulation (run). Simulation is top level concept and means – single gatling run. 
-	pom.xml project configuration file used to build project with MVN
