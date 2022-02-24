mkdir /home/213/Documents/artemis-ra/

cd /home/213/Documents/artemis-ra/
git clone https://github.com/apache/activemq-artemis.git

cd activemq-artemis
mvn clean install -Pdev -DskipTests

cd ../artemis-ra #javax ra implementierung
mvn clean install

cd ../artemis-jakarta-ra #jakarta trafo
mvn clean install

cd ../artemis-jakarta-ra-rar/ #rar
mvn clean install

cd ../async-app/
sh build.sh
sh run.sh

wget http://localhost:9080/async-app/rest
