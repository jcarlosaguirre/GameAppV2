package com.example.gameappv2.classes

import androidx.lifecycle.ViewModel
import com.example.gameappv2.R


/**
 * Prepare different Sprites for character selection.
 * Create an accesible Sprites array to show them in necessary views.
 */
class SpriteViewModel : ViewModel() {

    companion object {
        private val character1 = SpriteObject("Male 1", "character", 0, R.drawable.sprite_male_1_2, R.drawable.anim_male_1, 1 )
        private val character2 = SpriteObject("Male 2", "Assassin", 1, R.drawable.sprite_male_2_2, R.drawable.anim_male_2, 1 )
        private val character3 = SpriteObject("Male 3", "Dark character", 2, R.drawable.sprite_male_3_2, R.drawable.anim_male_3, 0 )
        private val character4 = SpriteObject("Male 4", "character", 3, R.drawable.sprite_male_1_2, R.drawable.anim_male_1, 1 )
        private val character5 = SpriteObject("Male 5", "Assassin", 4, R.drawable.sprite_male_2_2, R.drawable.anim_male_2, 0 )
        private val character6 = SpriteObject("Male 6", "Dark character", 5, R.drawable.sprite_male_3_2, R.drawable.anim_male_3, 1 )
        private val character7 = SpriteObject("Female 1", "Mage", 6, R.drawable.sprite_female_1_2, R.drawable.anim_female_1, 0 )
        private val character8 = SpriteObject("Female 2", "Mage", 7, R.drawable.sprite_female_1_2, R.drawable.anim_female_1, 0 )

        private val _characterSprites: ArrayList<SpriteObject> =
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

        val characterSprites get() = _characterSprites;
    }
}