package com.jmkopecky.aeternumcraft.blocks.custom;


import com.jmkopecky.aeternumcraft.gui.screens.SpellUnlockScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SpellUnlockTableBlock extends Block {

    public SpellUnlockTableBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            Minecraft.getInstance().setScreen(new SpellUnlockScreen(new TextComponent("Spell Unlock Screen")));
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }
}
