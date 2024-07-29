package br.com.shark.rest_service.services

import br.com.shark.rest_service.dto.CreateDto
import br.com.shark.rest_service.dto.TopicsResponse
import br.com.shark.rest_service.models.Topics
import org.springframework.stereotype.Service
import java.util.stream.Collectors

import kotlin.collections.ArrayList

@Service
class TopicsService(
    private var topics: List<Topics> = ArrayList(),
    private var courses: CursoService
) {

    fun list(): List<TopicsResponse> {
        return topics.stream().map {
            t -> TopicsResponse(
                id = t.id,
                titulo = t.title,
                message = t.message,
                dataCriacao = t.dataCriacao,
                status = t.status
            )
        }.collect(Collectors.toList());
    }

    fun get_filter(id: Long): TopicsResponse {
        val t =  topics.stream().filter {
            t -> t.id == id }.findFirst().get()

        return TopicsResponse(
            id = t.id,
            titulo = t.title,
            message = t.message,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
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