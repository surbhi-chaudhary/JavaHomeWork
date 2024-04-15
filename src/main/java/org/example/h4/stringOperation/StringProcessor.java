package org.example.h4.stringOperation;

public class StringProcessor {

    public String processString(String inp, StringOperation stringOperation){
        return stringOperation.operate(inp);
    }
}
