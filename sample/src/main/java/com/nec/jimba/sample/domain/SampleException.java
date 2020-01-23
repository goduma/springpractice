package com.nec.jimba.sample.domain;

public class SampleException extends Exception {
    private static final long serialVersionUID = 1L;
    private int code;
    public SampleException(int i, String message) {
        super(message);
        this.code = i;
    }
    public int getCode() {
        return code;
    }
}