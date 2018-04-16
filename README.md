## currency-converter

A spring-boot dubbo integration demo project to get exchange rate, the underlying api is from https://free.currencyconverterapi.com/.

:one: currency-converter-api is for the public api sharing between currency-converter-provider & currency-converter-web

:two: currency-converter-provider is for the implementation of public api, same as the traditional impl service layer

:three: currency-converter-web is the consumer of the public api

## build and run

:one: git clone https://github.com/jacoffee/currency-converter.git

:two: cd ${PROJECT_HOME} & mvn clean install

:three: start Zookeeper

:four: cd ${PROJECT_HOME}/currency-converter-provider & mvn spring-boot:run(or intellij idea run)

after this, you shoud be able to see ConverterService interface is registered under Znode /dubbo

```bash
[zk: /(CONNECTED) 1] ls /dubbo/com.jacoffee.currencyconverter.api.ConverterService
[consumers, configurators, routers, providers]
```

:five: cd ${PROJECT_HOME}/currency-converter-web & mvn spring-boot:run(or intellij idea run)

go to http://localhost:8082/ and you will see the following page (Just forget about the simple UI!!)

![](https://github.com/jacoffee/currency-converter/blob/master/currency-rate.png)

Then select currency and click the convert button and you will see the result
