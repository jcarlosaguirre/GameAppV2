package com.example.gameappv2.classes

import com.example.gameappv2.models.CharacterType

/**
 * Sprites available in game.
 * Each sprite type gives different stats to a character.
 *
 * @property name
 * @property type
 * @property description
 * @property img_src
 * @property anim_src
 * @property available
 */

data class Character(
    val name: String,
    val description: String,
    val type: CharacterType,
    val img_src: Int,
    val anim_src: Int,
    var available: Int
)
