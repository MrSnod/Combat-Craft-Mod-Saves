
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.combatcraftmodv.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.combatcraftmodv.block.TheSilentBaneBlock;
import net.mcreator.combatcraftmodv.block.AlternateStoneBlock;
import net.mcreator.combatcraftmodv.CombatcraftmodvMod;

public class CombatcraftmodvModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CombatcraftmodvMod.MODID);
	public static final RegistryObject<Block> THE_SILENT_BANE = REGISTRY.register("the_silent_bane", () -> new TheSilentBaneBlock());
	public static final RegistryObject<Block> ALTERNATE_STONE = REGISTRY.register("alternate_stone", () -> new AlternateStoneBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
		}

		@SubscribeEvent
		public static void blockColorLoad(ColorHandlerEvent.Block event) {
			AlternateStoneBlock.blockColorLoad(event);
		}
	}
}
