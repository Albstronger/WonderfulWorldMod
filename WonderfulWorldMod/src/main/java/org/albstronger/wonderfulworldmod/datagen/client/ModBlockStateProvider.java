package org.albstronger.wonderfulworldmod.datagen.client;

import org.albstronger.wonderfulworldmod.WonderfulWorld;
import org.albstronger.wonderfulworldmod.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
	public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, WonderfulWorld.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(BlockInit.QUARRY_STOPPER.get());
	}
}
