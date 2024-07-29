package br.com.shark.rest_service.services

import br.com.shark.rest_service.models.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(var cursos: List<Curso>) {
    init {
        val curso = Curso(
            id = 1,
            nome = "Curso",
            categoria = "Programacao"
        )
        cursos = listOf(curso)
    }

    fun searchId(id: Long): Curso {
        return cursos.stream().filter { obj: Curso -> obj.id == id }.findFirst().get()
    }
}
