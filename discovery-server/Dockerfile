FROM openjdk:17-slim

ARG USERNAME=USER
ARG UID=1000
ARG GUID=$UID

RUN groupadd --gid $GUID $USERNAME \
    && useradd --uid $UID --gid $GUID -m $USERNAME \
    && chown -R $UID:$GUID /home/$USERNAME

USER $USERNAME
COPY target/discovery-server.jar /home/$USERNAME
WORKDIR /home/$USERNAME
CMD java -jar \
    -Dserver.port=$PORT \
    -Dspring.profiles.active=$PROFILE \
    -Dspring.config.import=$CONFIGURATION_SERVER \
    discovery-server.jar
