package com.testweb.Optimization_class;

public class OneSearch implements CommomInteger<Product>{

    private static String COLOR = "RED";

    @Override
    public boolean MyFlag(Product product) {
        return COLOR.equals(product.getColor());
    }
}
