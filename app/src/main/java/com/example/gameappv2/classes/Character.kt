package com.example.gameappv2.classes


/**
 *
 *
 */
class Character(private val base: SpriteObject,
                private var level: Int = 1,
                private var health: Int = 0,
                private var defense: Int = 0,
                private var strength: Int = 0,
                private var attack: Int = 0,
                private var  magic: Int = 0 ){

    /**
     * Array joining all properties of character
     */
    private lateinit var _stats: Array<Int>

    init {
        initCharacter()
    }


    /**
     * Initialize character based in if it's new or it has data already
     */
    private fun initCharacter(){

        when( level ){
            1 -> {
                setStats( Stat.HEALTH, 3 )
                setStats( Stat.DEFENSE, 3 )
                setStats( Stat.STRENGTH, 3 )
                setStats( Stat.ATTACK, 3 )
                setStats( Stat.MAGIC, 3 )
            }
            else -> {
                setStats( Stat.HEALTH, health )
                setStats( Stat.DEFENSE, defense )
                setStats( Stat.STRENGTH, strength )
                setStats( Stat.ATTACK, attack )
                setStats( Stat.MAGIC, magic )
            }
        }

        updateStats()
    }


    /**
     * @param x
     * x is the quantity of points for upgrading a stat
     */
    private fun setLevelPoints( x: Int = 1 ){ level += x }
    private fun setHealthPoints( x: Int = 1 ){ health += x }
    private fun setDefensePoints( x: Int = 1 ){ defense += x }
    private fun setStrengthPoints( x: Int = 1 ){ strength += x }
    private fun setAttackPoints( x: Int = 1 ){ attack += x }
    private fun setMagicPoints( x: Int = 1 ){ magic += x }


    enum class Stat{
        LEVEL,
        HEALTH,
        DEFENSE,
        STRENGTH,
        ATTACK,
        MAGIC;
    }

    fun setStats( stat: Stat, value: Int ) {
        when( stat.ordinal ){
            0 -> setLevelPoints( value )
            1 -> setHealthPoints( value )
            2 -> setDefensePoints( value )
            3 -> setStrengthPoints( value )
            4 -> setAttackPoints( value )
            5 -> setMagicPoints( value )
        }

    }

    fun updateStats(){
        _stats = arrayOf( level, health, defense, strength, attack, magic )
    }

    fun getStats(): Array<Int> { return _stats }

}