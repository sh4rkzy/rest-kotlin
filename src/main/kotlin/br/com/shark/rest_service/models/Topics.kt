package br.com.shark.rest_service.models

import java.time.LocalDateTime

data class Topics(
    val id: Long? = null,
    val title: String,
    val message: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val status: StatusTopic = StatusTopic.EM_ABERTO,
    val respostas: List<Resposta> = ArrayList()
)