package org.albstronger.wonderfulworldmod.common.block;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;

public class BrittleIce extends IceBlock {

	public static final IntegerProperty CRACK = IntegerProperty.create("crack", 0, 2);

	public BrittleIce() {
		super(BlockBehaviour.Properties.copy(Blocks.ICE));
		this.registerDefaultState(this.stateDefinition.any().setValue(CRACK, 0));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(CRACK);
	}

	@Override
	public void tick(BlockState state, ServerLevel serverLevel, BlockPos position, Random random) {
		int crack = state.getValue(CRACK);
		if (crack < 2) {
			serverLevel.setBlock(position, state.setValue(CRACK, crack + 1), 3);
			serverLevel.playSound((Player) null, position, SoundEvents.GLASS_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
		} else {
			serverLevel.destroyBlock(position, false);
		}
	}

	@Override
	public void stepOn(Level level, BlockPos position, BlockState state, Entity entity) {
		if (!(entity instanceof ItemEntity)) {
			level.scheduleTick(position, this, 10);
		}
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}
}