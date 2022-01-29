package com.example.gameappv2.classes

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
data class SpriteObject( var name: String,
                         var description: String,
                         var type: Int,
                         var img_src: Int,
                         var anim_src: Int,
                         var available: Int )
