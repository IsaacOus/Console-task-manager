#!/bin/bash

mvn test

if [ "${?}" -eq 0 ]; then
  echo "All tests passed"
else
  echo "Tests failed"
fi
