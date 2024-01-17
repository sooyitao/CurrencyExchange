package com.example.currencyexchange;

public class Convert {
    double value;
    Double[] converted = new Double[8];
    double[] exchangeRate; //0:USD,1:Euro,2:JPY,3:GBP,4:AUD,5:CAD,6:CHF,7:CNY

    public Convert(double value) {
        this.value = value;
    }

    public Double[] convertor() {
        for (int i = 0; i < this.exchangeRate.length; i++) {
            converted[i] = this.value * this.exchangeRate[i];
        }
        return converted;
    }

    public void setExchangeRate(double[] exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
