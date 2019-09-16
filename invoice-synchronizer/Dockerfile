FROM openjdk:8

ADD build/libs/invoice-synchronizer-*.jar /invoice-synchronizer.jar

ENTRYPOINT sleep 40 ; java -jar invoice-synchronizer.jar
