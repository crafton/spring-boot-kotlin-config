package com.example.springbootkotlinconfig

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinConfigApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinConfigApplication>(*args)
}
