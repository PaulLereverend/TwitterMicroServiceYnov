FROM golang:latest
LABEL maintainer="hugo.huet@ynov.com"
WORKDIR /app
COPY . .
RUN go get -u github.com/jinzhu/gorm
RUN go get -u github.com/mattn/go-sqlite3
RUN go build
EXPOSE 8080:8082
CMD ["./b02"]