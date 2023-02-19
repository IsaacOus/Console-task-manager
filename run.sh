#!/bin/bash

mvn package

/usr/bin/java -jar target/console-task-manager-1.0-SNAPSHOT-jar-with-dependencies.jar list
