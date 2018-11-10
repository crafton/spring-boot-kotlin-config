package com.example.springbootkotlinconfig

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@ConfigurationProperties("myconf")
@Validated
@Component
class SomeConfig {
    @NotEmpty
    lateinit var name: String
    @NotNull
    lateinit var age: Number
    @NotEmpty
    lateinit var surname: String
    @NotEmpty
    lateinit var gender: String
    @NotNull
    lateinit var height: Number
}