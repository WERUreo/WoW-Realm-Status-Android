package com.werureo.realmstatusforwow.model;

public enum RealmType
{
    PVP ("pvp"),
    PVE ("pve"),
    RP ("rp"),
    RPPVP ("rppvp");

    private final String realmString;

    RealmType(String realmString)
    {
        this.realmSring = realmString;
    }
}

public class Realm
{
    private String realmName;
    private String realmSlug;

}
