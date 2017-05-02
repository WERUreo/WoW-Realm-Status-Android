package com.werureo.realmstatusforwow.models

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

class PvPZone(val area: Int, var controllingFaction: Faction, var status: ZoneStatus, var next: Date)

////////////////////////////////////////////////////////////

class Realm
{
    val name: String = ""
    val slug: String = ""
    val type: RealmType = RealmType.PVP
    var status: Boolean = true
    var queue: Boolean = false
    var population: String = ""
    val battlegroup: String = ""
    val locale: Locale = Locale.ENGLISH
    val timezone: TimeZone = TimeZone.getDefault()
    var wintergrasp: PvPZone = PvPZone(0, Faction.NEUTRAL, ZoneStatus.UNKNOWN, Date())
    var tolBarad: PvPZone = PvPZone(0, Faction.NEUTRAL, ZoneStatus.UNKNOWN, Date())
    var connectedRealms: Array<String>? = null
}