FROM golang:latest
LABEL maintainer="hugo.huet@ynov.com"
WORKDIR /app/b02
COPY . .
RUN go get -d -v ./...
RUN go build
EXPOSE 8080:8082
CMD ["./b02"]