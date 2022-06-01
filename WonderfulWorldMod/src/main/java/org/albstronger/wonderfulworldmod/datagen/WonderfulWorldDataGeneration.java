package org.albstronger.wonderfulworldmod.datagen;

import org.albstronger.wonderfulworldmod.WonderfulWorld;
import org.albstronger.wonderfulworldmod.datagen.client.ModBlockStateProvider;
import org.albstronger.wonderfulworldmod.datagen.client.ModItemModelProvider;
import org.albstronger.wonderfulworldmod.datagen.client.lang.ModEnUsProvider;
import org.albstronger.wonderfulworldmod.datagen.server.ModBlockTagsProvider;
import org.albstronger.wonderfulworldmod.datagen.server.ModItemTagsProvider;
import org.albstronger.wonderfulworldmod.datagen.server.ModLootTableProvider;
import org.albstronger.wonderfulworldmod.datagen.server.ModRecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;;

@Mod.EventBusSubscriber(modid = WonderfulWorld.MOD_ID, bus = Bus.MOD)
public class WonderfulWorldDataGeneration {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		
		if(event.includeClient()) {
			generator.addProvider(new ModBlockStateProvider(generator, helper));
			generator.addProvider(new ModItemModelProvider(generator, helper));
			generator.addProvider(new ModEnUsProvider(generator));
		}
		
		if(event.includeServer()) {
			
			ModBlockTagsProvider blockTags = new ModBlockTagsProvider(generator, helper);
			
			generator.addProvider(new ModRecipeProvider(generator));
			generator.addProvider(blockTags);
			generator.addProvider(new ModItemTagsProvider(generator, blockTags, helper));
			generator.addProvider(new ModLootTableProvider(generator));
		}
	}
}
