package com.teamcreeper.wordlemod.screen;

import com.teamcreeper.wordlemod.block.ModBlocks;
import com.teamcreeper.wordlemod.block.entity.WordleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WordleMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    public final static HashMap<String, Object> guistate = new HashMap<>();
    private final WordleBlockEntity blockEntity;
    public final Level world;
    public final Player entity;
    public int x,y,z;
    private IItemHandler internal;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    private boolean bound = false;

    public WordleMenu(int windowId, Inventory inv, FriendlyByteBuf extraData) {
        this(windowId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()));
    }

    public WordleMenu(int windowId, Inventory inv, BlockEntity entity){
        super(ModMenuTypes.WORDLE_MENU.get(), windowId);
        blockEntity = ((WordleBlockEntity) entity);
        this.entity = inv.player;
        this.world = inv.player.level;
        this.internal = new ItemStackHandler(0);
        BlockPos pos = null;
    }

    @Override
    public boolean stillValid(Player player){
        return stillValid(ContainerLevelAccess.create(world, blockEntity.getBlockPos()),
                player, ModBlocks.WORDLE_BLOCK.get());
    }

    public Map<Integer, Slot> get(){
        return customSlots;
    }
}
