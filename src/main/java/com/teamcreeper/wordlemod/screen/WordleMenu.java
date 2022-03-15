package com.teamcreeper.wordlemod.screen;

import com.teamcreeper.wordlemod.block.ModBlocks;
import com.teamcreeper.wordlemod.block.entity.WordleBlockEntity;
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
import net.minecraftforge.items.SlotItemHandler;

public class WordleMenu extends AbstractContainerMenu {
    private final WordleBlockEntity blockEntity;
    private final Level level;

    public WordleMenu(int windowId, Inventory inv, FriendlyByteBuf extraData) {
        this(windowId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()));
    }

    public WordleMenu(int windowId, Inventory inv, BlockEntity entity) {
        super(ModMenuTypes.WORDLE_MENU.get(), windowId);
        //checkContainerSize(inv, 4);
        blockEntity = ((WordleBlockEntity) entity);
        this.level = inv.player.level;

        addPlayerInventory(inv);
        //addPlayerHotbar(inv);

        /*this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 1, 66, 16));
            this.addSlot(new SlotItemHandler(handler, 2, 66, 50));
        });*/
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.WORDLE_BLOCK.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 6; ++i) {
            for (int l = 0; l < 5; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 42 + l * 19, 38 + i * 19));
            }
        }
    }

    /*private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }*/

}
