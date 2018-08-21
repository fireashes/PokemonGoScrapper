#!/usr/bin/env bash

sortUnique(){
    echo "${1}"
    src/main/sh/sortUniqueProperties.sh "${1}"
}
for f in ./src/main/data/PokemonCom/*/*/*.properties ./src/main/data/PokemonCom/*.txt; do
    sortUnique "${f}"
done

./gradlew clean build
#./gradlew clean test --tests "com.caliyeti.PokemonComTest.testPokemonEvolution"

for f in ./src/main/data/PokemonCom/*/*/*.properties ./src/main/data/PokemonCom/*.txt; do
    sortUnique "${f}"
done

open build/reports/tests/test/index.html
