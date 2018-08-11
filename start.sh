#!/usr/bin/env bash
./gradlew clean build
for f in src/main/resources/*.properties; do
	src/main/sh/sortUniqueProperties.sh$f
done
open build/reports/tests/test/index.html
