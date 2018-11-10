package com.example.springbootkotlinconfig

import io.kotlintest.specs.BehaviorSpec
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest(SomeController::class)
class SomeControllerTest : BehaviorSpec({
    lateinit var webClient: WebTestClient
    val props = SomeConfig()
    props.age = 4
    props.name = "bob"
    props.height = 50
    props.surname = "marley"
    webClient = WebTestClient.bindToController(SomeController(props))
            .build()

    given("The controller has a single method that returns SomeModel.") {
        `when`("The /get-some endpoint is called") {
            then("It should return OK and SomeModel") {
                webClient.get()
                        .uri("/get-some")
                        .exchange()
                        .expectStatus().isOk
                        .expectBody(SomeModel::class.java)
            }
        }
    }
})