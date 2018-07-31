#!/usr/bin/env bash

./gradlew clean

./gradlew module_feature1:jacocoTestReport -PjacocoBuildType=debug -PjacocoEnv=dev
if [[ "$OSTYPE" == "darwin"* ]]; then   # Open report in chrome on Mac OSX
/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --kiosk ./legalzoom-base/build/reports/jacocoTestReport/html/index.html
fi

./gradlew module_feature2:jacocoTestReport -PjacocoBuildType=release -PjacocoEnv=dev
if [[ "$OSTYPE" == "darwin"* ]]; then   # Open report in chrome on Mac OSX
/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --kiosk ./legalzoom-consultation/build/reports/jacocoTestReport/html/index.html
fi

./gradlew app:jacocoTestReport -PjacocoBuildType=release -PjacocoEnv=dev
if [[ "$OSTYPE" == "darwin"* ]]; then   # Open report in chrome on Mac OSX
/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --kiosk ./mobile/build/reports/jacocoTestReport/html/index.html
fi