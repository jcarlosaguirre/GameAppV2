package com.example.gameappv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gameappv2.classes.Character
import com.example.gameappv2.classes.SpriteViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var character = Character(SpriteViewModel.characterSprites[0])
        character.setStats(Character.Stat.HEALTH, 3)
        character.updateStats()

        for ( stat in character.getStats() ){
            println( stat )
        }
    }
}