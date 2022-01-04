package com.example.alphadecoder

class AssistantAction(
    val type: Int,
    val message: String = "",
    val features: List<String> = ArrayList(),
    val appDetails : AppDetails? = null,
    val collection : Collection? = null
)