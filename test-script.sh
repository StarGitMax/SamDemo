#!/bin/bash
echo $PATH
mvn -v
_ROOT=$(pwd)
echo "starting test-script from directory: $_ROOT"
cd $_ROOT/AppDemo/
mvn test