package org.albstronger.wonderfulworldmod.client;

import org.albstronger.wonderfulworldmod.WonderfulWorld;
import org.albstronger.wonderfulworldmod.common.item.LaunchStaff;
import org.albstronger.wonderfulworldmod.init.BlockInit;
import org.albstronger.wonderfulworldmod.init.ItemInit;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = WonderfulWorld.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	public static final ResourceLocation BROKEN_PROPERTY = new ResourceLocation(WonderfulWorld.MOD_ID, "broken");
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(BlockInit.JUMP_PAD.get(), RenderType.translucent());
		
		event.enqueueWork(() -> {
			launchStaffOverrides();
		});
	}
	
	private static void launchStaffOverrides() {
		LaunchStaff staff = ItemInit.LAUNCH_STAFF.get();
		ItemProperties.register(staff, BROKEN_PROPERTY,
				(stack, level, entity, damage) -> !LaunchStaff.isUsable(stack) ? 1.0f : 0.0f);
	}
}
