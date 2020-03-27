#!/bin/bash
_ROOT=$(pwd)
echo $PATH
mvn -v
echo "starting test-script from directory: $_ROOT"
ls $_ROOT
#cd _ROOT/AppDemo/
#mvn test