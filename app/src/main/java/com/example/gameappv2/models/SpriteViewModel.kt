package com.example.gameappv2.models

import androidx.lifecycle.ViewModel
import com.example.gameappv2.R
import com.example.gameappv2.classes.GameCharacter
import com.example.gameappv2.classes.CharacterStats


/**
 * Prepare different Sprites for character selection.
 * Create an accesible Sprites array to show them in necessary views.
 */

enum class CharacterType {
    KNIGHT, DARK_KNIGHT, ASSASSIN, SORCERER, MAGE
}

class SpriteViewModel : ViewModel() {

    companion object {
        private val character1 = GameCharacter(
            "Male 1",
            "character",
            CharacterType.KNIGHT,
            CharacterStats(),
            R.drawable.sprite_male_1_2,
            R.drawable.anim_male_1,
            1
        )
        private val character2 = GameCharacter(
            "Male 2",
            "Assassin",
            CharacterType.ASSASSIN,
            CharacterStats(),
            R.drawable.sprite_male_2_2,
            R.drawable.anim_male_2,
            1
        )
        private val character3 = GameCharacter(
            "Male 3",
            "Dark character",
            CharacterType.DARK_KNIGHT,
            CharacterStats(),
            R.drawable.sprite_male_3_2,
            R.drawable.anim_male_3,
            0
        )
        private val character4 = GameCharacter(
            "Male 4",
            "character",
            CharacterType.SORCERER,
            CharacterStats(),
            R.drawable.sprite_male_1_2,
            R.drawable.anim_male_1,
            1
        )
        private val character5 = GameCharacter(
            "Male 5",
            "Assassin",
            CharacterType.MAGE,
            CharacterStats(),
            R.drawable.sprite_male_2_2,
            R.drawable.anim_male_2,
            0
        )
        private val character6 = GameCharacter(
            "Male 6",
            "Dark character",
            CharacterType.KNIGHT,
            CharacterStats(),
            R.drawable.sprite_male_3_2,
            R.drawable.anim_male_3,
            1
        )
        private val character7 = GameCharacter(
            "Female 1",
            "Mage",
            CharacterType.ASSASSIN,
            CharacterStats(),
            R.drawable.sprite_female_1_2,
            R.drawable.anim_female_1,
            0
        )
        private val character8 = GameCharacter(
            "Female 2",
            "Mage",
            CharacterType.MAGE,
            CharacterStats(),
            R.drawable.sprite_female_1_2,
            R.drawable.anim_female_1,
            0
        )

        private val __GAME___CHARACTER_SPRITES: ArrayList<GameCharacter> =
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

        val characterSprites get() = __GAME___CHARACTER_SPRITES;
    }
}