
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.combatcraftmodv.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.combatcraftmodv.client.renderer.SoldierRenderer;
import net.mcreator.combatcraftmodv.client.renderer.HealerRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CombatcraftmodvModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CombatcraftmodvModEntities.FIRE_SPELL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CombatcraftmodvModEntities.SOLDIER.get(), SoldierRenderer::new);
		event.registerEntityRenderer(CombatcraftmodvModEntities.HEALER.get(), HealerRenderer::new);
	}
}
