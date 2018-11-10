package com.example.springbootkotlinconfig

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class SomeController(private val someConfig: SomeConfig) {

    @GetMapping("/get-some")
    fun getSomeKotlin(): Mono<ResponseEntity<SomeModel>> {
        val model = SomeModel(message = "Hello ${someConfig.name}, I can't believe that you're" +
                " already ${someConfig.age}. You must be what? ${someConfig.height} meters tall?. ")
        return Mono.just(model)
                .map { ResponseEntity.ok(it) }
                .defaultIfEmpty(ResponseEntity.notFound().build())
    }
}