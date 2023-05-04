package org.e8.account.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(
        value = "/account",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {
}
