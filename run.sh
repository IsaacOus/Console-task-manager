#!/bin/bash

mvn package -DskipTests 2>&1 > /dev/null

cp target/console-task-manager-1.0-SNAPSHOT-jar-with-dependencies.jar target/console-task-manager.jar

if [ ! -f ~/.consoleagenda/data.json ]; then
    echo "Error : the data.json file is not present."
    echo "Creating data.json file in ~/.consoleagenda"

    mkdir -p ~/.consoleagenda
    touch ~/.consoleagenda/data.json
    sample_data='[{
      "Created": "2022-02-15T22:14:30.536022+01:00",
      "DueDate": null,
      "CloseDate": null,
      "Description": "create a small poc to test formats",
      "State": 2,
      "Tag": null,
      "SubTasks": null
    }]'
    echo $sample_data > ~/.consoleagenda/data.json
fi




echo "Listing tasks :"

/usr/bin/java -jar target/console-task-manager.jar list

echo "Task listed"

echo "Adding task"

/usr/bin/java -jar target/console-task-manager.jar add -c "hello world" -s:done -d:2023-06-01

echo "Check that the task have been added :"

/usr/bin/java -jar target/console-task-manager.jar list


echo "Updating a task :"

/usr/bin/java -jar target/console-task-manager.jar update 1 -c "i love clean-archi"

echo "Check that the task have been updated :"

/usr/bin/java -jar target/console-task-manager.jar list

echo "Deleting a task :"

/usr/bin/java -jar target/console-task-manager.jar remove 1

echo "Check that the task have been deleted :"

/usr/bin/java -jar target/console-task-manager.jar list
