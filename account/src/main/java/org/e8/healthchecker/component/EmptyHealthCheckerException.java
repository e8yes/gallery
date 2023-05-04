package org.e8.healthchecker.component;

public class EmptyHealthCheckerException extends Exception {

    public EmptyHealthCheckerException() {
        super(/*message=*/"The HealthChecker table is empty. We expect it to "
                + "have contained at least 1 row.");
    }
}
