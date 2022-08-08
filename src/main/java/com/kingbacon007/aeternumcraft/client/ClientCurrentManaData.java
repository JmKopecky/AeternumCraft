package com.kingbacon007.aeternumcraft.client;

public class ClientCurrentManaData {

    private static float playerMana;

    public static void setMana(float mana) {
        ClientCurrentManaData.playerMana = mana;
    }



    public static float getPlayerMana() {
        return playerMana;
    }
}
