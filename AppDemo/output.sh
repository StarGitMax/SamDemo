#!/bin/bash
_ROOT=$(pwd)
echo $PATH
mvn -v
echo "starting test-script from directory: $ROOT"
ls _ROOT/*
cd _ROOT/AppDemo/
mvn test