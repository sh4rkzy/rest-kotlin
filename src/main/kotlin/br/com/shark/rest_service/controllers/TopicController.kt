package br.com.shark.rest_service.controllers
import br.com.shark.rest_service.dto.CreateDto
import br.com.shark.rest_service.models.Topics
import br.com.shark.rest_service.services.TopicsService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicsService) {

    @GetMapping
    fun getTopics(): List<Topics> {
        return service.list()
    }
    @GetMapping("/{id}")
    fun getTopic(@PathVariable id: Long): Topics {
       return service.get_filter(id)
    }

    @PostMapping
    fun postTopic(@RequestBody dto: CreateDto) {
        return service.new_func(dto)
    }
}