package br.com.shark.rest_service.dto

data class CreateDto (
    val titulo: String,
    val message: String,
    val idCurso: Long,
    val idAutor: Long
)