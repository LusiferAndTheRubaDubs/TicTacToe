# Late term assignment
# TicTacToe

## Hugbúnaðarfræði T-303-HUGB 2015

###### Björg Thorber Sigurðardóttir
###### Guðmundur Bjarni Kristinsson
###### Guðríður Sturludóttir
###### Heiðar Berg Hallgrímsson
###### Hólmfríður Guðlaug Einarsdóttir
###### Tómas Helgi Stefánsson
###### Magnús Vilhelm Björnsson

**The Board**

   1    |    2    |    3
 ------ | ------- | -------
   4    |    5    |    6
   7    |    8    |    9

This is a project in the course Hugbúnaðarfræði T-303-HUGB at Reykjavík University
.
Implement the game TicTacToe where the user can play against the computer, or against another human player.
The main focus is on the infrastructure and best coding practices.
1. The code base is stored in source control system on GitHub from early start of
the project
2. The system is setup with automatic build that must run all unit tests.
3. The output is a deployable or executable artifact, such as a jar/war or equival
ent.
4. The build script has deploy/install target that deploys the executable outside
of the working directory or on external server.
5. The business logic is coded using Test Driven Development.
6. The code is loosely coupled and follows good object oriented design practices.
7. Extra points

# Setup
1. Fork this repository
2. Clone the repository to your machine

# Build and Run
1. Be located at the root of the project and enter the command:

	$ sh ./bin/buildAndRun

# Development
The project was programmed in Java using:

1. Java 1.8.0_66
2. Gradle 2.8
3. Sparks 2.3
4. Travis CI 
5. Heroku
6. Selinium