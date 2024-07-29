package br.com.shark.rest_service.models

import java.time.LocalDateTime

data class Resposta(
    val id: Long?,
    val message: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val author: Usuario,
    val topic: Topics,
    val solucao: Boolean
)