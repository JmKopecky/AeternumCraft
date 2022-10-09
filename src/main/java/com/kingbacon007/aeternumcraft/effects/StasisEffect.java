package com.kingbacon007.aeternumcraft.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class StasisEffect extends MobEffect {

    protected StasisEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }


    //boolean hasObtainedInitialData = false;
    //double initialX;
    //double initialY;
    //double initialZ;
    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        //bug where all entities with this effect share the same values/variables, therefore the coordinates are not entity specific.

        if (!livingEntity.level.isClientSide) {
            livingEntity.teleportTo(livingEntity.getX(),livingEntity.getY(),livingEntity.getZ());
            livingEntity.setDeltaMovement(0, 0, 0);

            //if (amplifier >= 2) {
                //if (!hasObtainedInitialData) {
                    //hasObtainedInitialData = true;
                    //initialX = livingEntity.getX();
                    //initialY = livingEntity.getY();
                    //initialZ = livingEntity.getZ();
                //}
                //livingEntity.teleportTo(initialX, initialY, initialZ);
                //livingEntity.setDeltaMovement(0, 0, 0);
            //} else {

            //}
            //if (livingEntity.getEffect(this).getDuration()==1) {
                //hasObtainedInitialData = false;
            //}
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
