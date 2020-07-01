package com.yanch.security.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-07-01 16:10
 **/
@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello spring security"
    }

}