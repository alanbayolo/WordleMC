package com.teamcreeper.wordlemod.block.entity;

import com.teamcreeper.wordlemod.WordleMC;
import com.teamcreeper.wordlemod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, WordleMC.MOD_ID);

    public static final RegistryObject<BlockEntityType<WordleBlockEntity>> WORDLE_BLOCK =
            BLOCK_ENTITIES.register("wordle_block", ()->
                    BlockEntityType.Builder.of(WordleBlockEntity::new,
                            ModBlocks.WORDLE_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }

}
