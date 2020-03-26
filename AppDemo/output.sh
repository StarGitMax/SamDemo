#!/bin/bash
set -e -x
echo $PATH
java -version
mvn -v
cd branch-master/AppDemo/
mvn test