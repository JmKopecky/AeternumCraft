package com.kingbacon007.aeternumcraft.abilities.spellComponents;

import com.kingbacon007.aeternumcraft.abilities.DefaultSpellComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.phys.EntityHitResult;


public class DemoSpellComponent extends DefaultSpellComponent {


    String componentName = "democomponent";

    public DemoSpellComponent() {

    }

    @Override
    public void triggerAbilityComponentProjectile(EntityHitResult HitResult, LivingEntity shooter) {
        //overide the code for the event. implement things to happen on hit here. Test with an explosion.
        Explosion explosion = new Explosion(shooter.level, shooter, HitResult.getEntity().getX(), HitResult.getEntity().getY(), HitResult.getEntity().getZ(), 4.0F, true, Explosion.BlockInteraction.BREAK);
        explosion.explode();
    }
}
