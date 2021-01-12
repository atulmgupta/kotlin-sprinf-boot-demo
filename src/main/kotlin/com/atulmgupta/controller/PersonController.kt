package com.atulmgupta.controller

import com.atulmgupta.model.Greeting
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RequestMapping(value = ["/person"])
@RestController
class PersonController {

    val counter = AtomicLong()

    @GetMapping(value = ["/test"])
    fun test(): String {
        return "Service is running @ " + System.currentTimeMillis()
    }


    @GetMapping(value = ["/greeting"])
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
        Greeting(counter.incrementAndGet(), "Hello, $name")
}