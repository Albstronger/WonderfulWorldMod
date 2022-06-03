package org.albstronger.wonderfulworldmod.init;

import org.albstronger.wonderfulworldmod.WonderfulWorld;
import org.albstronger.wonderfulworldmod.world.structures.IceTower;

import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StructureInit {
    public static final DeferredRegister<StructureFeature<?>> STRUCTURES = DeferredRegister
            .create(ForgeRegistries.STRUCTURE_FEATURES, WonderfulWorld.MOD_ID);

    public static final RegistryObject<StructureFeature<?>> ICE_TOWER = STRUCTURES.register("ice_tower",
            IceTower::new);
}
