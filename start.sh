#!/usr/bin/env bash
netstat -vanp tcp | grep 8081
sudo lsof -i tcp:8081
# kill -9 <PID>

sortUnique(){
    echo "${1}"
    src/main/sh/sortUniqueProperties.sh "${1}"
}

for f in $( find ./src/main/data/PokemonCom -name *.txt -o -name *.properties | sort); do
    sortUnique "${f}"
done

#./gradlew clean build
./gradlew clean test --tests "com.caliyeti.PokemonComTest"

for f in $( find ./src/main/data/PokemonCom -name *.txt -o -name *.properties | sort); do
    sortUnique "${f}"
done

open build/reports/tests/test/index.html
