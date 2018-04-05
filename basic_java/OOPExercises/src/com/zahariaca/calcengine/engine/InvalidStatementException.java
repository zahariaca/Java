package com.zahariaca.calcengine.engine;

/**
 * Created by azaharia on 30.05.2016.
 */
public class InvalidStatementException extends Exception {
    public InvalidStatementException(String reason, String statement){
       super(reason + " " + statement);
    }
    public InvalidStatementException(String reason, String statement, Throwable cause){
        super(reason + " " + statement, cause);
    }
}
