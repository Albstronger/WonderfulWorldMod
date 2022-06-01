package org.albstronger.wonderfulworldmod.init;

import java.util.function.Function;

import org.albstronger.wonderfulworldmod.WonderfulWorld;
import org.albstronger.wonderfulworldmod.common.block.JumpPad;

import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WonderfulWorld.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
	
	public static final RegistryObject<Block> JUMP_PAD = register("jump_pad",
			() -> new JumpPad(), object -> () -> new BlockItem(object.get(), new Item.Properties().tab(WonderfulWorld.WONDERFUL_WORLD_TAB)));
	
	public static final RegistryObject<Block> QUARRY_STOPPER = register("quarry_stopper",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(5)),
			object -> () -> new BlockItem(object.get(), new Item.Properties().tab(WonderfulWorld.WONDERFUL_WORLD_TAB)));
	
	private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
			Function<RegistryObject<T>, Supplier<? extends Item>> item) {
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}
}
