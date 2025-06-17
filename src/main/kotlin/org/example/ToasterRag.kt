package org.example.rag
/**
 * ToasterRag provides instructions for operating and maintaining toasters.
 * Currently the values are hand-coded, but they can be replaced with a database or external service in the future.
 * Instead of going to the RAG directly now you can target the toaster RAG
 */
class ToasterRag {
    val instructions: Map<String, String> = mapOf(
        "T1234" to "Adjust the browning control for desired toast level.",
        "T5678" to "Unplug the toaster before cleaning.",
        "T9101" to "Do not insert metal objects into the toaster."
    )
}