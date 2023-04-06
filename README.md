docker build -t app .
docker run -it app:latest
sh run.sh

apt install curl

curl -X GET http://localhost:8080/employees
curl -X POST http://localhost:8080/employees -H 'Content-type:application/json' -d '{"name": "Samwise Gamgee", "role": "gardener"}'
curl -X GET http://localhost:8080/employees
