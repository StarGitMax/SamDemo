#!/bin/sh
mvn test -f branch-master/AppDemo/pom.xml
cp branch-master/AppDemo/target/ mvn-output/