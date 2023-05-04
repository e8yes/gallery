package org.e8.healthchecker.controller;

import java.util.Date;
import org.e8.healthchecker.component.EmptyHealthCheckerException;
import org.e8.healthchecker.component.HealthCheckerComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(
        value = "/health",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class HealthCheckerController {

    @Autowired
    private HealthCheckerComponent comp;

    @RequestMapping(
            value = "/check",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET)
    @ResponseBody
    public HealthCheckerResponse checkHealth() throws EmptyHealthCheckerException {
        String latestId = comp.queryLatestId();
        return new HealthCheckerResponse(latestId, new Date());
    }
}
