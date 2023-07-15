FROM ubuntu:20.04  

RUN apt update && apt install -y curl nginx

RUN curl -L https://corretto.aws/downloads/latest/amazon-corretto-8-x64-linux-jdk.tar.gz | tar zx && \
    mv amazon-corretto-* /amazon-corretto-8
ADD default /etc/nginx/sites-available/default 
ADD demo.example-* demo.example.jar
ADD entrypoint.sh /
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
