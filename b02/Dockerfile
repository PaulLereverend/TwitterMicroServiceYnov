FROM golang:latest
LABEL maintainer="hugo.huet@ynov.com"
WORKDIR /app
COPY . .
RUN go build
EXPOSE 8080:8082
CMD ["./b02"]