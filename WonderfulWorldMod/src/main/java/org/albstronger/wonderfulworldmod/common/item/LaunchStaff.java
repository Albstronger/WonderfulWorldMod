package org.albstronger.wonderfulworldmod.common.item;

import org.albstronger.wonderfulworldmod.WonderfulWorld;
import org.albstronger.wonderfulworldmod.init.BlockInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class LaunchStaff extends Item {
	public LaunchStaff() {
		super(new Item.Properties().tab(WonderfulWorld.WONDERFUL_WORLD_TAB).durability(175).rarity(Rarity.UNCOMMON));
	}

	public static boolean isUsable(ItemStack item) {
		if (item.getItem() instanceof LaunchStaff) {
			return item.getDamageValue() < item.getMaxDamage() - 1;
		}

		return false;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemStack = player.getItemInHand(hand);

		if (isUsable(itemStack) && player.isOnGround()) {
			Vec3 playerPos = player.position();

			if (level.getBlockState(new BlockPos(playerPos.x, playerPos.y - 1, playerPos.z)) != BlockInit.JUMP_PAD.get()
					.defaultBlockState()) {
				player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1, 10, false, false, false));
			}
			player.jumpFromGround();
			player.getCooldowns().addCooldown(this, 20);

			itemStack.hurtAndBreak(1, player, (event) -> {
				event.broadcastBreakEvent(hand);
			});

			return InteractionResultHolder.pass(itemStack);
		}

		return InteractionResultHolder.pass(itemStack);
	}

	@Override
	public boolean isValidRepairItem(ItemStack thisItem, ItemStack otherItem) {
		return otherItem.is(Items.SLIME_BALL);
	}
}
