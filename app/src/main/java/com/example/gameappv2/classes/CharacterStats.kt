package com.example.gameappv2.classes


/**
 *
 *
 */
data class CharacterStats(
    private val base: Character,
    private var level: Int = 1,
    private var health: Int = 0,
    private var defense: Int = 0,
    private var strength: Int = 0,
    private var attack: Int = 0,
    private var magic: Int = 0
)