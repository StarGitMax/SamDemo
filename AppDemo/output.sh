#!/bin/bash
_ROOT=$(pwd)
echo $PATH
mvn -v
echo "starting test-script from directory: $_ROOT"
cd $_ROOT
ls
#ls /tmp/build/
#cd _ROOT/AppDemo/
#mvn test