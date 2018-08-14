#!/usr/bin/env bash


for f in src/main/resources/*.properties; do
    src/main/sh/sortUniqueProperties.sh "${f}"
done
./gradlew clean build
#./gradlew clean test --tests "com.caliyeti.PokemonComTest.testPokemonEvolution"

# ./gradlew clean test --tests "com.caliyeti.PokemonComTest.*801_806"
# ./gradlew clean test \
# --tests "com.caliyeti.PokemonComTest.testPokemonComU*Pokedex*_*_*" \
# --tests "com.caliyeti.PokemonComTest.*1_100" \
# --tests "com.caliyeti.PokemonComTest.*101_151" \
# --tests "com.caliyeti.PokemonComTest.*152_200" \
# --tests "com.caliyeti.PokemonComTest.*201_251" \
# --tests "com.caliyeti.PokemonComTest.*252_300" \
# --tests "com.caliyeti.PokemonComTest.*301_386" \
# --tests "com.caliyeti.PokemonComTest.*387_400" \
# --tests "com.caliyeti.PokemonComTest.*401_487" \
# --tests "com.caliyeti.PokemonComTest.*488_492" \
# --tests "com.caliyeti.PokemonComTest.*493_493" \
# --tests "com.caliyeti.PokemonComTest.*495_500" \
# --tests "com.caliyeti.PokemonComTest.*501_600" \
# --tests "com.caliyeti.PokemonComTest.*601_649" \
# --tests "com.caliyeti.PokemonComTest.*650_700" \
# --tests "com.caliyeti.PokemonComTest.*701_721" \
# --tests "com.caliyeti.PokemonComTest.*722_800" \
# --tests "com.caliyeti.PokemonComTest.*801_806" \
# --tests "com.caliyeti.PokemonComTest.*Us*" \
# --tests "com.caliyeti.PokemonComTest.*Uk*" \
# --tests "com.caliyeti.PokemonComTest.*PokedexI_*" \
# --tests "com.caliyeti.PokemonComTest.*PokedexII_*" \
# --tests "com.caliyeti.PokemonComTest.*PokedexIII_*" \
# --tests "com.caliyeti.PokemonComTest.*PokedexIV_*" \
# --tests "com.caliyeti.PokemonComTest.*PokedexV_*" \
# --tests "com.caliyeti.PokemonComTest.*PokedexVI_*" \
# --tests "com.caliyeti.PokemonComTest.*PokedexVII_*"

for f in src/main/resources/*.properties; do
    src/main/sh/sortUniqueProperties.sh "${f}"
done
open build/reports/tests/test/index.html
