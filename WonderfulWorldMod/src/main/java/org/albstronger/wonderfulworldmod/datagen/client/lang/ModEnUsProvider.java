package org.albstronger.wonderfulworldmod.datagen.client.lang;

import org.albstronger.wonderfulworldmod.WonderfulWorld;
import org.albstronger.wonderfulworldmod.init.BlockInit;
import org.albstronger.wonderfulworldmod.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider {
	public ModEnUsProvider(DataGenerator generator) {
		super(generator, WonderfulWorld.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add("itemGroup.wonderfulworldmod", "It's a Wonderful World Mod");
		
		add(BlockInit.JUMP_PAD.get(), "Jump Pad");
		add(BlockInit.QUARRY_STOPPER.get(), "Quarry Stopper");
		
		add(ItemInit.LAUNCH_STAFF.get(), "Launch Staff");
	}
}
