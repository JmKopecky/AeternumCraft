package com.kingbacon007.aeternumcraft.client;

public class ClientManaData {

    private static float playerMana;


    public static void setMana(float mana) {
        ClientManaData.playerMana = mana;
    }

    public static float getPlayerMana() {
        return playerMana;
    }
}
