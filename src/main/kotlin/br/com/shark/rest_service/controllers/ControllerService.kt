package br.com.shark.rest_service.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class ControllerService {
    @GetMapping
    fun Hello(): String {
        return "UP";
    }
}