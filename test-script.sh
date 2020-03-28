#!/bin/bash
echo $PATH
mvn -v
_ROOT=$(pwd)
echo "starting test-script from directory: $_ROOT"
echo "Input Argument: $1"
cd $_ROOT/$1/AppDemo/
mvn test -Dpwd=$_ROOT
_ROOT1=$(pwd)
echo "ending test-script from directory: $_ROOT1"
echo "Source directory: $_ROOT1/target/"
echo "Target directory: $_ROOT/mvn-output/"
cp -R $_ROOT1/target/* $_ROOT/mvn-output/
echo "Hi, I'm sleeping for 2 minutes..."
sleep 2m
echo "all Done."