package br.com.shark.rest_service.controllers

import br.com.shark.rest_service.models.Curso
import br.com.shark.rest_service.models.Topics
import br.com.shark.rest_service.models.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topics")
class TopicController {

    @GetMapping
    fun getTopics(): List<Topics> {

        val topicos = Topics(
            title = "Hello World",
            message = "Curso ai231312",
            curso = Curso(
                nome = "Koltin",
                categoria = "Programação",
            ),
        )
        return Arrays.asList(topicos)
    }
}