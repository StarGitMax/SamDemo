#!/bin/bash
_ROOT=$(pwd)
echo $PATH
mvn -v
echo "starting test-script from directory: $_ROOT"
cd "/SamDemo/AppDemo/"
mvn test