#! /bin/bash
cd ../ale-arsenal-backend
./gradlew :openApiGenerate
rm ../ale-arsenal-frontend/src/generated -rf
mv ./build/generated ../ale-arsenal-frontend/src/ -f