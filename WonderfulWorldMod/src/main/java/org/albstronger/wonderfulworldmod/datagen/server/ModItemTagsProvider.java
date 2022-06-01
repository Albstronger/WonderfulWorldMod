package org.albstronger.wonderfulworldmod.datagen.server;

import org.albstronger.wonderfulworldmod.WonderfulWorld;
import org.albstronger.wonderfulworldmod.init.TagInit;
import org.jetbrains.annotations.Nullable;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, @Nullable ExistingFileHelper helper) {
		super(generator, blocks, WonderfulWorld.MOD_ID, helper);
	}

	@Override
	protected void addTags() {
		tag(TagInit.Items.MACHINE_FUEL).add(Items.SLIME_BALL).add(Items.SLIME_BLOCK).add(Items.MAGMA_CREAM).add(Items.BLAZE_ROD)
		.add(Items.BLAZE_POWDER);
	}
}