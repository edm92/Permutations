#!/bin/bash

mvn clean install
mvn cobertura:cobertura
bash <(curl -s https://codecov.io/bash) -t 6a3bd938-ddd1-4e59-a381-1585eba8a301
