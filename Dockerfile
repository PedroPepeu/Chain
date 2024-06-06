FROM ubuntu:latest

WORKDIR /testChain

RUN npm install cypress --save-dev

RUN npx cypress run