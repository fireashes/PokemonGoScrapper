#!/usr/bin/env bash
# netstat -vanp tcp | grep 8081
# lsof -i tcp:8081
# kill -9 <PID>

sortUnique(){
    for f in $(find ./src/main/data/PokemonCom -name *.txt -o -name *.properties | sort); do
        echo "${f}"
        src/main/sh/sortUniqueProperties.sh "${f}"
    done
}

sortUnique

./gradlew clean build
#./gradlew clean test --tests "com.caliyeti.PokemonComTest"

cat log.log | grep "Pokemon name and" | sed "s/.*PokemonComTest - //g" >> src/main/data/PokemonCom/log.txt

sortUnique

open build/reports/tests/test/index.html
