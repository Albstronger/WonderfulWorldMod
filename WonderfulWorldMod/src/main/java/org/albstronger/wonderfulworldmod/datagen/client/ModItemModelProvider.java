package org.albstronger.wonderfulworldmod.datagen.client;

import org.albstronger.wonderfulworldmod.WonderfulWorld;
import org.albstronger.wonderfulworldmod.client.ClientEventBusSubscriber;
import org.albstronger.wonderfulworldmod.init.BlockInit;
import org.albstronger.wonderfulworldmod.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, WonderfulWorld.MOD_ID, helper);
	}

	protected void simpleBlockItem(Item item) {
		getBuilder(item.getRegistryName().toString()).parent(getExistingFile(modLoc("block/" + item.getRegistryName().getPath())));
	}
	
	protected void oneLayerItem(Item item, String parent, ResourceLocation texture) {
		ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
		
		if(existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
			getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc(parent))).texture("layer0", itemTexture);
		} else {
			System.err.println("Texture for " + item.getRegistryName().toString() + " not present at " + itemTexture.toString());
		}
	}
	
	protected void oneLayerItem(Item item, String parent) {
		oneLayerItem(item, parent, item.getRegistryName());
	}
	
	protected void oneLayerItem(Item item) {
		oneLayerItem(item, "item/generated");
	}
	
	protected void handheldItem(Item item) {
		oneLayerItem(item, "item/handheld");
	}
	@Override
	protected void registerModels() {
		simpleBlockItem(BlockInit.JUMP_PAD.get().asItem());
		simpleBlockItem(BlockInit.QUARRY_STOPPER.get().asItem());
		
		getBuilder(ItemInit.LAUNCH_STAFF.get().getRegistryName().getPath())
			.parent(getExistingFile(mcLoc("item/handheld")))
			.texture("layer0", "item/launch_staff")
			.override().predicate(ClientEventBusSubscriber.BROKEN_PROPERTY, 1).model(
				getBuilder("broken_launch_staff")
				.parent(getExistingFile(mcLoc("item/handheld")))
				.texture("layer0", "item/broken_launch_staff")
			);
	}

}
