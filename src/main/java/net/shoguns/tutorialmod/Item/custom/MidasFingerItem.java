package net.shoguns.tutorialmod.Item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.shoguns.tutorialmod.block.ModBlocks;

import java.util.*;

public class MidasFingerItem extends Item {

    private static final Map<Block, Block> MIDAS_MAP = new HashMap<Block, Block>()
    {{
        // Does not work with redstone ore variants due to redstone ore's useItemOn override. Doesn't even reach this useOn method.
        put(Blocks.COAL_ORE, Blocks.GOLD_ORE);
        put(Blocks.IRON_ORE, Blocks.GOLD_ORE);
        put(Blocks.REDSTONE_ORE, Blocks.GOLD_ORE); // FIXME
        put(Blocks.COPPER_ORE, Blocks.GOLD_ORE);
        put(Blocks.LAPIS_ORE, Blocks.GOLD_ORE);
        put(Blocks.EMERALD_ORE, Blocks.GOLD_ORE);
        put(Blocks.DIAMOND_ORE, Blocks.GOLD_ORE);
        put(ModBlocks.MITHRIL_ORE.get(), Blocks.GOLD_ORE);
        put(Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        put(Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        put(Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.DEEPSLATE_GOLD_ORE); // FIXME
        put(Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        put(Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        put(Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        put(Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        put(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(), Blocks.DEEPSLATE_GOLD_ORE);
    }};

    public MidasFingerItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(MIDAS_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), MIDAS_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

}
