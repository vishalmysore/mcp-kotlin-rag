package org.example

import com.t4a.annotations.Action
import com.t4a.annotations.Agent
import lombok.extern.java.Log
import org.example.rag.DishwasherRag
import org.example.rag.ToasterRag
import org.example.rag.WashingMachineRag
import org.example.utils.ApacheNLPAnalyzer

import org.springframework.stereotype.Service
import java.util.logging.Logger
import org.springframework.beans.factory.annotation.Autowired

/**
 * AgenticRagDemoService demonstrates various RAG patterns using different agents
 */
@Service
@Log
@Agent(groupName = "ragPatterns", groupDescription = "Demonstrates various RAG patterns using agent-based architecture")
class AgenticRagDemoService @Autowired constructor(
    private val apacheNLPAnalyzer: ApacheNLPAnalyzer
) {
    private val log: Logger = Logger.getLogger(AgenticRagDemoService::class.java.name)

    init {
        log.info("AgenticRagDemoService initialized")
    }

    @Action(description = "Help with household appliances")
    fun helpWithAppliances(query: String, modelNum: String): String {
        // Use NLP to analyze the query intent
        val intent = apacheNLPAnalyzer.analyzeApplianceCategory(query)
        log.info("Analyzed intent: $intent for query: $query with model number: $modelNum")
        // Route to the appropriate appliance class based on intent
        return when (intent) {
            "washing_machine" -> {
                val washingMachineRag = WashingMachineRag()
                washingMachineRag.instructions[modelNum] ?: "Model number not found for Washing Machine."
            }
            "toaster" -> {
                val toasterRag = ToasterRag()
                toasterRag.instructions[modelNum] ?: "Model number not found for Toaster."
            }
            "dishwasher" -> {
                val dishwasherRag = DishwasherRag()
                dishwasherRag.instructions[modelNum] ?: "Model number not found for Dishwasher."
            }
            else -> "Unable to determine the appliance type. Please refine your query."
        }
    }


}