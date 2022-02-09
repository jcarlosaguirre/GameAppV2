package com.example.gameappv2.classes


/**
 *
 *
 * @property level
 * @property health
 * @property defense
 * @property strength
 * @property attack
 * @property magic
 */
data class CharacterStats(
    private var level: Int = 1,
    private var health: Int = 3,
    private var defense: Int = 3,
    private var strength: Int = 3,
    private var attack: Int = 3,
    private var magic: Int = 3
){
    fun getLevel() : Int { return this.level }
    fun getHealth() : Int { return this.health }
    fun getDefense() : Int { return this.defense }
    fun getStrength() : Int { return this.strength }
    fun getAttack() : Int { return this.attack }
    fun getMagic() : Int { return this.magic }

    fun setLevel( value: Int ) { this.level = value }
    fun setHealth( value: Int ) { this.health = value }
    fun setDefense( value: Int ) { this.defense = value }
    fun setStrength( value: Int ) { this.strength = value }
    fun setAttack( value: Int ) { this.attack = value }
    fun getMagic( value: Int ) { this.magic = value }
}