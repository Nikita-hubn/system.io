FROM ubuntu:latest
LABEL authors="pinta"

ENTRYPOINT ["top", "-b"]