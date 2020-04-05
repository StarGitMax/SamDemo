#!/bin/bash
echo $PATH
echo ${HOME}
mvn -v
_ROOT=$(pwd)
echo "starting test-script from directory: $_ROOT"
echo "Input Argument: $1"
M2_HOME=${HOME}/.m2
mkdir -p ${M2_HOME}
M2_LOCAL_REPO="${_ROOT}/.m2"
mkdir -p "${M2_LOCAL_REPO}/repository"
cat > ${M2_HOME}/settings.xml <<EOF
 
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          https://maven.apache.org/xsd/settings-1.0.0.xsd">
      <localRepository>${M2_LOCAL_REPO}/repository</localRepository>
</settings>
 
EOF
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