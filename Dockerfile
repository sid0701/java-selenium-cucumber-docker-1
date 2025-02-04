FROM bellsoft/liberica-openjdk-alpine:21

#Install utilities like curl and jq
RUN apk add curl jq

#Work Directory
WORKDIR /home/

#Add Files
ADD target/ship-to-production     ./
ADD run.sh                    run.sh

#Fix for windows
RUN dos2unix run.sh

#EntryPoint
ENTRYPOINT sh run.sh
