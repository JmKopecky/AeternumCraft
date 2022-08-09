package com.kingbacon007.aeternumcraft.client;

public class ClientCurrentMaxManaData {

    private static float playerMaxMana;

    public static void setPlayerMaxMana(float maxMana) {
        ClientCurrentMaxManaData.playerMaxMana = maxMana;
    }
    public static float getPlayerMaxMana() {
        return playerMaxMana;
    }
}
