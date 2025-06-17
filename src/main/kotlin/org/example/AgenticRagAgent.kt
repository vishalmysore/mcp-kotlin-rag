package org.example

import io.github.vishalmysore.tools4ai.EnableAgent
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAgent
open class AgenticRagAgent

fun main(args: Array<String>) {
    runApplication<AgenticRagAgent>(*args)
}