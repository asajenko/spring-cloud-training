./mvnw clean package -DskipTests
docker build -t training/admin-server admin-server
docker build -t training/configuration-server configuration-server
docker build -t training/discovery-server discovery-server
