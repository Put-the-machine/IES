#!/bin/bash
cd ../frontend

resources='../backend/IES/src/main/resources' 

eval 'npm install'
eval 'npm run build'

eval 'mkdir -p $resources/spa'
eval 'mkdir -p $resources/static'
eval 'cp -r dist/css $resources/static/css'
eval 'cp -r dist/js $resources/static/js'
eval 'cp -r dist/img $resources/static/img'
eval 'cp dist/favicon.ico $resources/static/favicon.ico'
eval 'cp dist/index.html $resources/spa/index.html'

cd ../backend/IES

eval 'mvn install -P prod'

cd ../../

eval 'docker build -t ies-app .'  
