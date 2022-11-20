package com.br.rodrigo.libraryapp.util;

public enum Region {
    US_EAST_1("us-east-1");

    private String name;

    Region(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
