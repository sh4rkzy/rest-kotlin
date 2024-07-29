package br.com.shark.rest_service.dto

import br.com.shark.rest_service.models.StatusTopic
import java.time.LocalDateTime


data class TopicsResponse (
    val id: Long? = null,
    val titulo: String,
    val message: String,
    val status: StatusTopic,
    val dataCriacao: LocalDateTime

)