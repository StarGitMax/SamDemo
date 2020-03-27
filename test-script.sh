#!/bin/bash
echo $PATH
mvn -v
_ROOT=$(pwd)
echo "starting test-script from directory: $_ROOT"
echo $1
cd $_ROOT/SamDemo/AppDemo/
mvn test