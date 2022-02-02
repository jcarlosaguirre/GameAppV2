package com.example.gameappv2.models

import androidx.lifecycle.ViewModel
import com.example.gameappv2.R
import com.example.gameappv2.classes.Character


/**
 * Prepare different Sprites for character selection.
 * Create an accesible Sprites array to show them in necessary views.
 */

enum class CharacterType{
    KNIGHT, DARK_KNIGHT, ASSASSIN, SORCERER, MAGE
}

class SpriteViewModel : ViewModel() {

    companion object {
        private val character1 = Character(
            "Male 1",
            "character",
            CharacterType.KNIGHT,
            R.drawable.sprite_male_1_2,
            R.drawable.anim_male_1,
            1
        )
        private val character2 = Character(
            "Male 2",
            "Assassin",
            CharacterType.ASSASSIN,
            R.drawable.sprite_male_2_2,
            R.drawable.anim_male_2,
            1
        )
        private val character3 = Character(
            "Male 3",
            "Dark character",
            CharacterType.DARK_KNIGHT,
            R.drawable.sprite_male_3_2,
            R.drawable.anim_male_3,
            0
        )
        private val character4 = Character(
            "Male 4",
            "character",
            CharacterType.SORCERER,
            R.drawable.sprite_male_1_2,
            R.drawable.anim_male_1,
            1
        )
        private val character5 = Character(
            "Male 5",
            "Assassin",
            CharacterType.MAGE,
            R.drawable.sprite_male_2_2,
            R.drawable.anim_male_2,
            0
        )
        private val character6 = Character(
            "Male 6",
            "Dark character",
            CharacterType.KNIGHT,
            R.drawable.sprite_male_3_2,
            R.drawable.anim_male_3,
            1
        )
        private val character7 = Character(
            "Female 1",
            "Mage",
            CharacterType.ASSASSIN,
            R.drawable.sprite_female_1_2,
            R.drawable.anim_female_1,
            0
        )
        private val character8 = Character(
            "Female 2",
            "Mage",
            CharacterType.MAGE,
            R.drawable.sprite_female_1_2,
            R.drawable.anim_female_1,
            0
        )

        private val __CHARACTER_SPRITES: ArrayList<Character> =
            arrayListOf(
                character1,
                character2,
                character3,
                character4,
                character5,
                character6,
                character7,
                character8,
            )

        val characterSprites get() = __CHARACTER_SPRITES;
    }
}