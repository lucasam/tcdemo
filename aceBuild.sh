#!/bin/bash

FULLPATH=`readlink -f $0`
THISDIR=`dirname $FULLPATH`
installers_dir="$(dirname "$THISDIR")/output/installers"
artifacts_dir="$installers_dir/artifacts"

# check for existing build
if [[ -d "$artifacts_dir" ]]; then
    echo "Found existing build outputs in '$artifacts_dir'"
    echo "Will not rebuild. Build skipped."
    exit 0
fi

# You can add the build instructions here instead the folowing.

# Use custom JAVA_HOME if defined
if [ "$JAVA_HOME" == "" ]
then
    export JAVA_HOME=/usr/lib/jvm/jdk1.7.0_60
fi
# Use custom ANT_HOME if defined
if [ "$ANT_HOME" == "" ]
then
    export ANT_HOME=/usr/local/apache-ant-1.9.4
fi
# Use custom PARALLEL_HOME if defined
if [ "$PARALLEL_HOME" == "" ]
then
    export PARALLEL_HOME=/usr/local/parallel
fi
# Use custom IVY_HOME if defined
if [ "$IVY_HOME" == "" ]
then
    # put in a backup location instead of ~root/.ant
    export IVY_HOME=/opt/ivycache
fi

export PATH=$ANT_HOME/bin:$JAVA_HOME/bin:$PARALLEL_HOME/bin:$PATH
echo "BUILDPATH=$PATH"

#Build ddm
cd build/ddm
ant -Dfile.encoding=windows-1252

cd ../../build/tf
ant

cd ../../build/butterfly
ant

cd ../../build/gce
ant main -XX:PermSize=512m -XX:MaxPermSize=512m

exit 0

