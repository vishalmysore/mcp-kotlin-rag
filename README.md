# Agentic RAG Demo Service

This project demonstrates various RAG (Retrieval-Augmented Generation) patterns using an agent-based architecture in Kotlin .


[A2AJava](https://github.com/vishalmysore/a2ajava) is a pure Java implementation designed to support both the Google A2A (Agent-to-Agent) protocol and the MCP (Model Context Protocol), making it a versatile framework for building agentic applications. The A2A protocol standardizes how AI agents communicate and collaborate across different systems, while the MCP protocol focuses on enabling agents to access and trigger a wide range of tools and resources.

Key Features and Benefits of A2AJava (A2A & MCP Support):

Cross-Protocol Support: A2AJava natively supports both A2A and MCP in the same codebase, allowing developers to build applications where agents can communicate with each other (A2A) and also access external tools or services (MCP).

Cross-Platform and Cross-Language: Runs on any operating system with JVM support and is compatible with clients built in JavaScript, Python, and other languages, as well as LLM agents like Claude and Google A2A clients.

Flexible Integration: Can be used with Spring Boot, Quarkus, or pure Java/Kotlin, making it easy to integrate into a variety of enterprise and AI applications.

Automatic Tool and Resource Registration: Uses Java annotations (such as @Agent and @Action) to automatically expose methods as A2A tasks or MCP tools, simplifying agent and tool development.

Lightweight and Extensible: Designed for minimal overhead and maximum flexibility, supporting both local and remote tool execution, JSON-RPC, schema validation, and callback mapping


## 1. Single-Agent RAG (Router Pattern) Implementation

The project implements the Single-Agent RAG Router Pattern in the `helpWithAppliances` method, which demonstrates the following features:

### Current Implementation ✓

1. **Basic Router Pattern Structure**
   - Takes query and model number as input
   - Uses NLP to analyze the intent
   - Routes to specialized handlers based on the intent

2. **NLP-based Routing**
   - Implements Apache OpenNLP for intent classification
   - Uses ML model trained on appliance data
   - Well-defined categories for different appliance types

3. **Specialized Handlers**
   - Separate RAG implementations for each appliance type:
     - WashingMachineRag
     - ToasterRag
     - DishwasherRag

## 2. Multi-Agent RAG Implementation ✅

The project implements a Multi-Agent RAG pattern in the `MultiAgentRagService`, demonstrating parallel processing and synthesis of information from multiple specialized agents.

### Architecture

The implementation features multiple specialized agents working in parallel:

1. **Semantic Search Agent**
   - Performs vector-based semantic search
   - Processes unstructured text and research documents
   - Returns relevant passages and citations

2. **Structured DB Agent**
   - Queries structured databases
   - Retrieves economic and environmental metrics
   - Provides quantitative data analysis

3. **Web API Agent**
   - Fetches real-time data from external APIs
   - Monitors current market trends
   - Tracks regulatory updates and alerts

4. **Recommendation Agent**
   - Generates contextual recommendations
   - Suggests actionable insights
   - Provides strategic guidance

### Workflow

```
Query → Parallel Agent Processing → Data Aggregation → LLM Synthesis → Comprehensive Response
```

### Example Use Case

Perfect for multi-domain research tasks like analyzing both economic and environmental impacts:
- Economic data from structured databases
- Environmental research from semantic search
- Real-time market data from APIs
- Strategic recommendations based on all sources

## Future Enhancement: Hierarchical Agentic RAG ✅

### Proposed Architecture

The system can be enhanced to implement a hierarchical RAG pattern using Apache NLP for intelligent routing between agent tiers:

#### 1. Top-Level Planner Agent
- Strategic task decomposition
- Source prioritization logic
- Task complexity assessment using trained NLP models
- Orchestrates communication between tiers

#### 2. Mid-Level Executor Agents
- Financial domain specialists
- Market analysis experts
- Risk assessment coordinators
- Uses custom-trained Apache OpenNLP models for:
  - Intent classification
  - Entity extraction
  - Sentiment analysis
  - Domain-specific terminology processing

#### 3. Low-Level Retriever Agents
- Real-time market data collectors
- Historical data analyzers
- Report aggregators
- News sentiment analyzers

### NLP Filter Chain Implementation
The hierarchical system will utilize a chain of specialized NLP models:

1. **Initial Query Processing**
   - Intent classification model
   - Entity recognition model
   - Priority assessment model

2. **Domain Routing**
   - Financial term classifier
   - Market sector analyzer
   - Risk level assessor

3. **Data Source Selection**
   - Source relevance model
   - Data freshness analyzer
   - Reliability scorer

### Example Workflow
```
Query → Top-Level NLP Analysis → Strategic Planning → Mid-Level Domain Processing → 
Specialized NLP Filtering → Low-Level Data Retrieval → Hierarchical Synthesis → Response
```

### Use Case: Financial Analysis
1. Top-Level Planner:
   - Analyzes query complexity
   - Identifies required market sectors
   - Plans data retrieval strategy

2. Mid-Level Executors:
   - Process domain-specific aspects
   - Apply financial models
   - Coordinate between data sources

3. Low-Level Retrievers:
   - Fetch real-time market data
   - Access historical records
   - Collect analyst reports

Each level uses specialized NLP models trained on financial domain data to ensure accurate and contextual information flow between tiers.

## Planned Enhancements 🚀

The following enhancements are planned to make this a more complete RAG implementation:

1. **Enhanced RAG Integration**
   - Replace static mappings with dynamic knowledge base
   - Implement vector database integration for document storage
   - Add LLM integration for dynamic response generation

2. **Improved Error Handling**
   - Implement robust error handling strategies
   - Add fallback mechanisms for unknown queries
   - Enhance model number validation

3. **Full RAG Feature Set**
   - Implement document embedding capabilities
   - Add vector search functionality
   - Enable dynamic context augmentation
   - Integrate real-time document retrieval

4. **Context Enrichment**
   - Add integration with appliance manuals
   - Include troubleshooting guides
   - Incorporate user feedback and common issues

## Proposed RAG Workflow

```
Query → NLP Router → Specialized RAG Agent → Document Retrieval → Context Enrichment → LLM Generation → Response
```

