package org.albstronger.wonderfulworldmod.datagen.server;

import org.albstronger.wonderfulworldmod.WonderfulWorld;
import org.albstronger.wonderfulworldmod.init.BlockInit;
import org.albstronger.wonderfulworldmod.init.TagInit;
import org.jetbrains.annotations.Nullable;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
	public ModBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper helper) {
		super(generator, WonderfulWorld.MOD_ID, helper);
	}

	@Override
	protected void addTags() {
		tag(TagInit.Blocks.LOW_LEVEL_QUARRY_STOPPER).add(Blocks.CRYING_OBSIDIAN).add(Blocks.OBSIDIAN).add(Blocks.ENCHANTING_TABLE)
		.add(Blocks.ENDER_CHEST).add(Blocks.BEACON);
		
		tag(TagInit.Blocks.QUARRY_STOPPER).add(BlockInit.QUARRY_STOPPER.get()).add(Blocks.BEDROCK).add(Blocks.END_PORTAL_FRAME)
		.add(Blocks.END_PORTAL).add(Blocks.END_GATEWAY).add(Blocks.BARRIER).add(Blocks.COMMAND_BLOCK).add(Blocks.CHAIN_COMMAND_BLOCK)
		.add(Blocks.REPEATING_COMMAND_BLOCK).add(Blocks.STRUCTURE_BLOCK).add(Blocks.STRUCTURE_VOID).add(Blocks.JIGSAW).add(Blocks.LIGHT);
	}
}
