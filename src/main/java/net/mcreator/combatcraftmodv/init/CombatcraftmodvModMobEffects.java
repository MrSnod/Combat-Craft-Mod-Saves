
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.combatcraftmodv.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.combatcraftmodv.potion.FlightEffectMobEffect;
import net.mcreator.combatcraftmodv.CombatcraftmodvMod;

public class CombatcraftmodvModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CombatcraftmodvMod.MODID);
	public static final RegistryObject<MobEffect> FLIGHT_EFFECT = REGISTRY.register("flight_effect", () -> new FlightEffectMobEffect());
}
