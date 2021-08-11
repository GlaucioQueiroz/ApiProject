FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/api

COPY /target/APIProject*.jar apiproject.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar apiproject.jar --spring.profiles.active=${PROFILE} --spring.jpa.hibernate.ddl-auto=update --spring.datasource.url=jdbc:mysql://db:3306/${MYSQL_DATABASE}  --spring.datasource.username=root --spring.datasource.password=${MYSQL_ROOT_PASSWORD}
