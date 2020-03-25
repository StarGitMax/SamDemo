#!/bin/sh
mvn test -f $1/AppDemo/pom.xml
cp $1/AppDemo/target/ mvn-output/