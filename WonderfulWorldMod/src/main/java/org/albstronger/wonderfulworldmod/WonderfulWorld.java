package org.albstronger.wonderfulworldmod;

import org.albstronger.wonderfulworldmod.init.BlockInit;
import org.albstronger.wonderfulworldmod.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WonderfulWorld.MOD_ID)
public class WonderfulWorld {
	public static final String MOD_ID = "wonderfulworldmod";

	public static final CreativeModeTab WONDERFUL_WORLD_TAB = new CreativeModeTab(WonderfulWorld.MOD_ID) {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.LAUNCH_STAFF.get());
		}
	};
	
    public WonderfulWorld() {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	ItemInit.ITEMS.register(bus);
    	BlockInit.BLOCKS.register(bus);
    	
        MinecraftForge.EVENT_BUS.register(this);
    }
}