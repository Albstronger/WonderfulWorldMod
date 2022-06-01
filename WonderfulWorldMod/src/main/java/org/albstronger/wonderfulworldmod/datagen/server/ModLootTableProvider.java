package org.albstronger.wonderfulworldmod.datagen.server;

import org.albstronger.wonderfulworldmod.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModLootTableProvider extends BaseLootTableProvider {

	public ModLootTableProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void addTables() {
		dropSelf(BlockInit.JUMP_PAD.get());
		dropSelf(BlockInit.QUARRY_STOPPER.get());
	}
	
	protected void silkTouch(Block block, Item silk, int min, int max) {
		add(block, createSilkTouchTable(block.getRegistryName().getPath(), block, silk, min, max));
	}
	
	protected void dropSelf(Block block) {
		add(block, createSimpleTable(block.getRegistryName().getPath(), block));
	}
}
