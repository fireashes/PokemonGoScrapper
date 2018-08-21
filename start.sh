#!/usr/bin/env bash


for f in src/main/data/PokemonCom/u*/Gen*/*.properties; do
    src/main/sh/sortUniqueProperties.sh "${f}"
done
./gradlew clean build
#./gradlew clean test --tests "com.caliyeti.PokemonComTest.testPokemonEvolution"

for f in ./src/main/data/PokemonCom/u*/Gen*/*.properties; do
    echo $f;
    src/main/sh/sortUniqueProperties.sh "${f}"
done
open build/reports/tests/test/index.html
