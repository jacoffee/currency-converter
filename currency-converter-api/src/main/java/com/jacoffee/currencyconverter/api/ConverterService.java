package com.jacoffee.currencyconverter.api;

public interface ConverterService {

    // currency one to other, i.e EUR - CNY(欧元对于人民币的汇率)
    public double convert(String one, String other) throws Exception;

}
