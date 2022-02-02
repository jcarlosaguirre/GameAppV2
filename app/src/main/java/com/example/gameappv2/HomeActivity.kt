package com.example.gameappv2

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.gameappv2.ui.main.SectionsPagerAdapter
import com.example.gameappv2.databinding.ActivityHomeBinding
import com.example.gameappv2.models.SQLiteHelper

class HomeActivity : AppCompatActivity() {

    private lateinit var DBHelper: SQLiteHelper
    private lateinit var binding: ActivityHomeBinding
    private lateinit var fabButton: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DBHelper = SQLiteHelper( applicationContext )
        DBHelper.setDatabase()

        DBHelper.fillCharactersTable()

        // Get floating action button
        fabButton = binding.fab

        // Set sections adapter for tabs
        setTabsAndSections()

    }

    // Initialize tabs
    private fun setTabsAndSections(){
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager

        // Set pager on page 1
        viewPager.adapter = sectionsPagerAdapter
        viewPager.currentItem = 1

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
                fabButton.setOnClickListener { view ->
                    Toast.makeText( this@HomeActivity, "section 0", Toast.LENGTH_SHORT ).show()
                }
            }
            1 -> {
                fabButton.setOnClickListener { view ->
                    Toast.makeText( this@HomeActivity, "section 1", Toast.LENGTH_SHORT ).show()
                }
            }
        }
    }

    // Change fab icon and actions
    private fun changesOnTabSelected( tabPosition: Int ){
        when ( tabPosition ){
            0 -> {
                fabButton.setImageDrawable( resources.getDrawable( R.drawable.icon_customize_team, this@HomeActivity.theme ) )
            }
            1 -> {
                fabButton.setImageDrawable( resources.getDrawable( R.drawable.icon_mission, this@HomeActivity.theme ) )
            }
            2 -> {
                fabButton.setImageDrawable( resources.getDrawable( R.drawable.icon_mission, this@HomeActivity.theme ) )
            }
            3 -> {
                fabButton.setImageDrawable( resources.getDrawable( R.drawable.icon_mission, this@HomeActivity.theme ) )

            }
        }

        // Change fab click behaviour
        setFabActions( tabPosition )
    }
}

