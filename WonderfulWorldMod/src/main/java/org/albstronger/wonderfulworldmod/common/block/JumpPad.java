package org.albstronger.wonderfulworldmod.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class JumpPad extends Block {
	
	public static final VoxelShape SHAPE = makeShape();
	
	public JumpPad() {
		super(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(0.0f)
				.sound(SoundType.SLIME_BLOCK).jumpFactor(5.0f).dynamicShape().isRedstoneConductor((state, getter, pos) -> {
					return false;
				}));
	}
	
	private static VoxelShape makeShape(){
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0, 0, 0.875, 0.125, 0.875, 1), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0, 0.875, 0, 1, 1, 1), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0, 1, 0.875, 0.125), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0, 0, 0, 0.125, 0.875, 0.125), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0.875, 1, 0.875, 1), BooleanOp.OR);

		return shape;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos,
			CollisionContext context) {
		return SHAPE;
	}

	@Override
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float distance) {
		super.fallOn(level, state, pos, entity, 0);
	}
}
