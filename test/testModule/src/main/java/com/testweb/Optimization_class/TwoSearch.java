package com.testweb.Optimization_class;

public class TwoSearch implements CommomInteger<Product>{

    private static Long prace = 80000L;

    @Override
    public boolean MyFlag(Product o) {
        return prace > o.getPlace();
    }
}
