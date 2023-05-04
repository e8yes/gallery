package org.e8.healthchecker.controller;

import java.util.Date;
import lombok.Data;

@Data
public class HealthCheckerResponse {

    private String healthCheckerId;
    private Date checkedAt;

    public HealthCheckerResponse(String healthCheckerId, Date checkedAt) {
        this.healthCheckerId = healthCheckerId;
        this.checkedAt = checkedAt;
    }
}
