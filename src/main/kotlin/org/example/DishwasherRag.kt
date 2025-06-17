package org.example.rag

/**
 * DishwasherRag provides instructions for operating and maintaining dishwashers.
 * Currently the values are hand-coded, but they can be replaced with a database or external service in the future.
 * Instead of going to the RAG directly now you can target the dishwasher RAG
 */
class DishwasherRag {
    val instructions: Map<String, String> = mapOf(
        "DW1234" to "Load dishes properly to ensure effective cleaning.",
        "DW5678" to "Use rinse aid to prevent water spots.",
        "DW9101" to "Clean the spray arms monthly for better performance."
    )
}