#!/bin/bash
echo $PATH
mvn -v
_ROOT=$(pwd)
echo "starting test-script from directory: $_ROOT"
echo $1
cd $_ROOT/$1/AppDemo/
mvn test
_ROOT1=$(pwd)
echo "ending test-script from directory: $_ROOT1"