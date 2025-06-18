package org.example.rag.agents

import com.t4a.annotations.Action
import com.t4a.annotations.Agent
import org.springframework.stereotype.Service
import kotlinx.coroutines.*
import org.springframework.beans.factory.annotation.Autowired
import java.util.logging.Logger
import com.fasterxml.jackson.databind.ObjectMapper
import lombok.extern.java.Log
import org.springframework.web.client.RestTemplate

@Service
@Log
@Agent(groupName = "multiAgentRag", groupDescription = "Demonstrates Multi-Agent RAG pattern with specialized agents")
class MultiAgentRagService @Autowired constructor(
    private val restTemplate: RestTemplate,
    private val objectMapper: ObjectMapper
) {
    private val log: Logger = Logger.getLogger(MultiAgentRagService::class.java.name)
    
    // Specialized agents for different data sources
    private val semanticSearchAgent = SemanticSearchAgent()
    private val dbQueryAgent = StructuredDBAgent()
    private val webApiAgent = WebAPIAgent()
    private val recommendationAgent = RecommendationAgent()

    @Action(description = "Research assistant for economic and environmental impacts")
    fun researchImpacts(query: String): String {
        return runBlocking {
            performResearchImpacts(query)
        }
    }

    private suspend fun performResearchImpacts(query: String): String = coroutineScope {
        log.info("Starting research for query: $query")

        val semanticResults = async { semanticSearchAgent.search(query) }
        val dbResults = async { dbQueryAgent.query(query) }
        val apiResults = async { webApiAgent.fetch(query) }
        val recommendations = async { recommendationAgent.suggest(query) }

        val allResults = awaitAll(semanticResults, dbResults, apiResults, recommendations)

        synthesizeResults(query, allResults)
    }

    private fun synthesizeResults(query: String, results: List<Any>): String {
        // Here we would use an LLM to combine and synthesize the results
        // For now, return a formatted combination
        return buildString {
            appendLine("Research findings for: $query")
            appendLine("\nSemantic Search Results:")
            appendLine(results[0].toString())
            appendLine("\nStructured Data Findings:")
            appendLine(results[1].toString())
            appendLine("\nWeb API Data:")
            appendLine(results[2].toString())
            appendLine("\nRecommendations:")
            appendLine(results[3].toString())
        }
    }
}
