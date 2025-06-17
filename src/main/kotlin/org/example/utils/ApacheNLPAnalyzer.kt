package org.example.utils

import jakarta.annotation.PostConstruct
import opennlp.tools.doccat.*
import opennlp.tools.tokenize.WhitespaceTokenizer
import opennlp.tools.util.*
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader

@Component
class ApacheNLPAnalyzer {

    private lateinit var categorizer: DocumentCategorizerME

    private val csvFileName = "appliance_training_data.csv" // under src/main/resources/

    @PostConstruct
    fun init() {
        initializeCategorizer()
    }

    private fun initializeCategorizer() {
        val samples = mutableListOf<DocumentSample>()

        try {
            val resource = ClassPathResource(csvFileName)
            resource.inputStream.use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).useLines { lines ->
                    lines.forEach { line ->
                        val parts = line.split(",", limit = 2)
                        if (parts.size == 2) {
                            val category = parts[0].trim().lowercase()
                            val text = parts[1].trim()
                            val tokens = WhitespaceTokenizer.INSTANCE.tokenize(text)
                            samples.add(DocumentSample(category, tokens))
                        }
                    }
                }
            }
        } catch (ex: Exception) {
            throw RuntimeException("Failed to load training data from CSV: ${ex.message}", ex)
        }

        if (samples.isEmpty()) {
            throw RuntimeException("No training data found in the CSV file: $csvFileName")
        }

        val sampleStream: ObjectStream<DocumentSample> = CollectionObjectStream(samples)
        val model = DocumentCategorizerME.train("en", sampleStream, TrainingParameters.defaultParams(), DoccatFactory())
        categorizer = DocumentCategorizerME(model)
    }

    fun analyzeApplianceCategory(query: String): String {
        val tokens = WhitespaceTokenizer.INSTANCE.tokenize(query)
        val probabilities = categorizer.categorize(tokens)
        return categorizer.getBestCategory(probabilities)
    }

    fun extractEntities(text: String): Map<String, String> {
        val tokens = WhitespaceTokenizer.INSTANCE.tokenize(text)
        return mapOf("tokens" to tokens.joinToString(" "))
    }
}
