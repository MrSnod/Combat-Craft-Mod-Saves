package net.mcreator.combatcraftmodv.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.combatcraftmodv.init.CombatcraftmodvModMobEffects;

public class FlightSpellFoodEatenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(CombatcraftmodvModMobEffects.FLIGHT_EFFECT.get(), 1800, 1, (false), (true)));
	}
}
