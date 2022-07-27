package com.michaelbruno.tech.pokedex.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toLowerCase
import com.michaelbruno.tech.pokedex.data.remote.responses.Stat
import com.michaelbruno.tech.pokedex.data.remote.responses.Type
import com.michaelbruno.tech.pokedex.ui.theme.*
import java.util.*

fun parseTypeToColor(type: Type): Color {
    return when (type.type.name.toLowerCase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeBug
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when (stat.stat.name.toLowerCase(Locale.ROOT)) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defence" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.Black
    }
}


fun parseStatToAbbr(stat:Stat):String{
    return when(stat.stat.name.toLowerCase(Locale.ROOT)){
        "hp" -> "HP"
        "attack" -> "Atk"
        "defence" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else->""
    }
}