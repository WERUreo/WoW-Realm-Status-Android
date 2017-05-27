package com.werureo.realmstatusforwow.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

////////////////////////////////////////////////////////////

enum class RealmType(val type: String)
{
    PVP("pvp")      { override fun toString() = "PvP" },
    PVE("pve")      { override fun toString() = "PvE" },
    RP("rp")        { override fun toString() = "RP" },
    RPPVP("rppvp")  { override fun toString() = "RPPvP" }
}

////////////////////////////////////////////////////////////

enum class Faction(val type: Int)
{
    ALLIANCE(0)     { override fun toString() = "Alliance" },
    HORDE(1)        { override fun toString() = "Horde" },
    NEUTRAL(2)      { override fun toString() = "Neutral" }
}

////////////////////////////////////////////////////////////

enum class ZoneStatus(val type: Int)
{
    UNKNOWN(-1)     { override fun toString() = "Unknown" },
    IDLE(0)         { override fun toString() = "Idle" },
    POPULATING(1)   { override fun toString() = "Populating" },
    ACTIVE(2)       { override fun toString() = "Active" },
    CONCLUDED(3)    { override fun toString() = "Concluded" }
}

////////////////////////////////////////////////////////////

data class PvPZone(val area: Int, var controllingFaction: Faction, var status: ZoneStatus, var next: Date)

////////////////////////////////////////////////////////////

data class Realm(@SerializedName("name")                @Expose val name: String = "",
                 @SerializedName("slug")                @Expose val slug: String = "",
                 @SerializedName("type")                @Expose val type: RealmType = RealmType.PVP,
                 @SerializedName("status")              @Expose var status: Boolean = true,
                 @SerializedName("queue")               @Expose var queue: Boolean = false,
                 @SerializedName("population")          @Expose var population: String = "",
                 @SerializedName("battlegroup")         @Expose val battlegroup: String = "",
                 @SerializedName("locale")              @Expose val locale: String = "",
                 @SerializedName("timezone")            @Expose val timezone: String = "",
                 @SerializedName("connected_realms")    @Expose var connectedRealms: List<String>? = null
)
