#!/bin/bash
set -eux
echo $PATH
java -version
mvn -v
cd branch-dev/AppDemo/
mvn test