
docker build -t system-io-tests .

docker build -t system-io-tests:jdk17 .

docker build --no-cache -t system-io-tests .

docker run --rm system-io-tests