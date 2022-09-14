
package net.mcreator.combatcraftmodv.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.combatcraftmodv.procedures.FlightEffectEffectStartedappliedProcedure;
import net.mcreator.combatcraftmodv.procedures.FlightEffectEffectExpiresProcedure;

public class FlightEffectMobEffect extends MobEffect {
	public FlightEffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10322967);
	}

	@Override
	public String getDescriptionId() {
		return "effect.combatcraftmodv.flight_effect";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		FlightEffectEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		FlightEffectEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
