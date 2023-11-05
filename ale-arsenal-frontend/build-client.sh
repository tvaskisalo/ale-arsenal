#! /bin/bash
cd ../ale-arsenal-backend
./gradlew :openApiGenerate
mv -f ./build/generated ../ale-arsenal-frontend/src/