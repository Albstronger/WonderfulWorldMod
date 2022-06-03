package org.albstronger.wonderfulworldmod.init;

import org.albstronger.wonderfulworldmod.WonderfulWorld;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class TagInit {
	public static final class Blocks {

		public static final TagKey<Block> QUARRY = mod("quarry");
		public static final TagKey<Block> QUARRY_STOPPER = mod("quarry_stopper");
		public static final TagKey<Block> LOW_LEVEL_QUARRY_STOPPER = mod("low_level_quarry_stopper");

		private static TagKey<Block> mod(String path) {
			return BlockTags.create(new ResourceLocation(WonderfulWorld.MOD_ID, path));
		}
	}

	public static final class Items {

		public static final TagKey<Item> MACHINE_FUEL = mod("machine_fuel");

		private static TagKey<Item> mod(String path) {
			return ItemTags.create(new ResourceLocation(WonderfulWorld.MOD_ID, path));
		}
	}
}
