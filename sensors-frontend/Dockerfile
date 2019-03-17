FROM node:11.11.0

RUN npm install -g nodemon

RUN mkdir ./app
COPY . ./app
WORKDIR ./app

RUN npm install

EXPOSE 3000

CMD ["nodemon"]