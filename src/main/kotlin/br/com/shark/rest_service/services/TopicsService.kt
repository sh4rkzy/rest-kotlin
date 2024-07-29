package br.com.shark.rest_service.services

import br.com.shark.rest_service.dto.CreateDto
import br.com.shark.rest_service.models.Topics
import org.springframework.stereotype.Service

import kotlin.collections.ArrayList

@Service
class TopicsService(
    private var topics: List<Topics> = ArrayList(),
    private var courses: CursoService
) {

    fun list(): List<Topics> {
        return topics;
    }

    fun get_filter(id: Long): Topics {
        return topics.stream().filter { t -> t.id == id }.findFirst().get()
    }

    fun new_func(topic: CreateDto) {
        topics = topics.plus(
            Topics(
                id = topics.size.toLong() + 1,
                title = topic.titulo,
                message = topic.message,
                curso = courses.searchId(topic.idCurso)
            )
        )
    }
}