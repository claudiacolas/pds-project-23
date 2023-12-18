FROM node:14

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .

EXPOSE 3000

ENV JAVA_TOOL_OPTIONS "-javaagent:./opentelemetry-javaagent.jar"

CMD ["npm", "start"]