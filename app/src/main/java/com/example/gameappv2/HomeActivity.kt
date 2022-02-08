package com.example.gameappv2

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.core.database.getBlobOrNull
import com.example.gameappv2.classes.CharacterStats
import com.example.gameappv2.classes.GameCharacter
import com.example.gameappv2.ui.main.SectionsPagerAdapter
import com.example.gameappv2.databinding.ActivityHomeBinding
import com.example.gameappv2.models.CharacterType
import com.example.gameappv2.models.SQLiteHelper

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var fabButton: FloatingActionButton


    companion object {
        lateinit var DBHelper: SQLiteHelper
        var characters: ArrayList<GameCharacter> = arrayListOf()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DBHelper = SQLiteHelper( applicationContext )

//        DBHelper.isCharactersTableFilled()

        // Get floating action button
        fabButton = binding.fab

        // Set sections adapter for tabs
        setTabsAndSections()

        val charCursor = DBHelper.mostrarDatos()

        if( charCursor!!.moveToFirst() ){

            do{
                val name = charCursor.getString( 0 )
                val desc = charCursor.getString( 1 )
                val type = charCursor.getInt( 3 )
                val imgsrc = charCursor.getString( 4 )
                val animsrc = charCursor.getString( 5 )
                val available = charCursor.getInt( 6 )

                val character = GameCharacter(name, desc, CharacterType.values()[ type ], CharacterStats(), imgsrc.toInt(), animsrc.toInt(), available)
                characters.add( character )

            } while( charCursor.moveToNext() )
        }

        if( characters.size > 0 ){

        }
    }

    // Initialize tabs
    private fun setTabsAndSections(){
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager

        // Set pager on page 1
        viewPager.adapter = sectionsPagerAdapter
        viewPager.currentItem = 1

        // Set icons on tabs
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt( 0 )?.apply {
            this.setIcon(R.drawable.icon_section_character)
            this.text = null
        }
        tabs.getTabAt( 1 )?.apply {
            this.setIcon(R.drawable.icon_section_lobby)
            this.text = null
        }
        tabs.getTabAt( 2 )?.apply {
            this.setIcon(R.drawable.icon_section_adventures)
            this.text = null
        }
        tabs.getTabAt( 3 )?.apply {
            this.setIcon(R.drawable.icon_section_settings)
            this.text = null
        }

        // Listener on tab changed
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                changesOnTabSelected( tab.position )
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
                Toast.makeText( this@HomeActivity, "aaaa", Toast.LENGTH_SHORT ).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText( this@HomeActivity, "aaaa", Toast.LENGTH_SHORT ).show()
            }
        })
    }

    // Fab action changes between tabs
    private fun setFabActions( tabPosition: Int ){
        when ( tabPosition ){
            0 -> {
                fabButton.setImageDrawable( resources.getDrawable( R.drawable.icon_customize_team, this@HomeActivity.theme ) )
                fabButton.setOnClickListener { view ->
                    Toast.makeText( this@HomeActivity, "section 0", Toast.LENGTH_SHORT ).show()
                }
            }
            1 -> {
                fabButton.setImageDrawable( resources.getDrawable( R.drawable.icon_mission, this@HomeActivity.theme ) )
                fabButton.setOnClickListener { view ->
                    Toast.makeText( this@HomeActivity, "section 1", Toast.LENGTH_SHORT ).show()
                }
            }
            2 -> {
                fabButton.setImageDrawable( resources.getDrawable( R.drawable.icon_mission, this@HomeActivity.theme ) )
            }
            3 -> {
                fabButton.setImageDrawable( resources.getDrawable( R.drawable.icon_delete_data, this@HomeActivity.theme ) )
                fabButton.setOnClickListener { view ->
                    DBHelper.resetDatabase()
                }
            }
        }
    }

    // Change fab icon and actions
    private fun changesOnTabSelected( tabPosition: Int ){
        when ( tabPosition ){
            0 -> {

            }
            1 -> {

            }
            2 -> {

            }
            3 -> {

            }
        }

        // Change fab click behaviour
        setFabActions( tabPosition )
    }
}

