package com.example.eventmanagement19.Model

import com.google.gson.annotations.SerializedName

public class AttendeeSummary(val enrolledNumber : Long, val capacity : Long, val shirtSize : ShirtSize, val foodType : FoodType)

class ShirtSize(@SerializedName("S") val s : Long,
                @SerializedName("M") val m : Long,
                @SerializedName("L") val l : Long,
                @SerializedName("XL") val xl:Long,
                @SerializedName("XXL") val xxl : Long,
                @SerializedName("3XL") val xxxl : Long)

public class FoodType(
    @SerializedName("Normal") val normal : Long,
    @SerializedName("Vegetarian") val vegetarian : Long,
    @SerializedName("Islam") val islam : Long,
    @SerializedName("NoSpicy") val noSpicy : Long,
    @SerializedName("NoEggs") val noEggs : Long,
    @SerializedName("NoPeanuts") val noPeanuts : Long,
    @SerializedName("NoMilk") val noMilk : Long,
    @SerializedName("NoShellfish") val nOShellfish : Long,
    @SerializedName("NoWheat") val noWheat : Long,
    @SerializedName("Other") val other : Long
)
