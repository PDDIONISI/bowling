# How to run?

##### After cloning the repository, run the following Maven commands

```mvn clean install```

```mvn exec:java -Dexec.args="${absolute path to input file} ${filename}"```

##### Example

```mvn exec:java -Dexec.args="/Users/user/Repos/challenge/src/main/resources/ game.txt"```

##### Run tests

```mvn clean test```
