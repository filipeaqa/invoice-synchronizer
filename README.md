# Invoice-Synchronizer
This application was built with Java, using the OpenJDK 1.8 and MySQL. The purpose of this application is  to consume Arquivei NFe API, decodes content, parse those received NFe XMLs into Java Objects then persist into MySQL database. It works like a Cron-job that from time to time consumes the API to get the newer invoices.

#### How to run (Step by Step)

Depends on JDK 1.8 and Docker


```
git clone https://github.com/filipeaqa/invoice-synchronizer.git
```

```
cd invoice-synchronizer/invoice-synchronizer
```

```
./gradlew build
```

```
docker build -t filipeaqa/invoice-synchronizer .
```

```
cd ..
```

```
docker-compose up
```
After that you should see moving logs, be patience... when you see:

```
[           main] c.a.c.invoicesynchronizer.Application    : Started Application in 8.177 seconds (JVM running for 8.756)
[   scheduling-1] c.a.c.invoicesynchronizer.Synchronizer   : M=synchronize, I=Starting invoice Synchronization
[   scheduling-1] o.h.h.i.QueryTranslatorFactoryInitiator  : HHH000397: Using ASTQueryTranslatorFactory
[   scheduling-1] c.a.c.invoicesynchronizer.Synchronizer   : M=synchronize, I=Current cursor pointer: 0
[   scheduling-1] c.a.c.invoicesynchronizer.Synchronizer   : M=synchronize, I=Synchronized 5 invoices
```
Now it's time to navigate to `http://localhost:8080/swagger-ui.html` in your favorite browser
Enjoy

