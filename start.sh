#!/usr/bin/env bash


for f in src/main/data/*.properties; do
    src/main/sh/sortUniqueProperties.sh "${f}"
done
for f in src/main/resources/*.properties; do
    src/main/sh/sortUniqueProperties.sh "${f}"
done
./gradlew clean build
#./gradlew clean test --tests "com.caliyeti.PokemonComTest.testPokemonEvolution"

for f in src/main/data/*.properties; do
    src/main/sh/sortUniqueProperties.sh "${f}"
done
for f in src/main/resources/*.properties; do
    src/main/sh/sortUniqueProperties.sh "${f}"
done
open build/reports/tests/test/index.html
