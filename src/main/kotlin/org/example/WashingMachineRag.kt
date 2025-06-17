package org.example.rag

/**
 * WashingMachineRag provides instructions for operating and maintaining washing machines.
 * Currently the values are hand-coded, but they can be replaced with a database or external service in the future.
 * instead of going to the RAG directly now you can target the washing machine RAG
 */
class WashingMachineRag {
    val instructions: Map<String, String> = mapOf(
        "WM1234" to "To start the washing machine, press the power button and select a cycle.",
        "WM5678" to "Clean the filter regularly to avoid clogging.",
        "WM9101" to "Use only HE detergent for optimal performance."
    )
}