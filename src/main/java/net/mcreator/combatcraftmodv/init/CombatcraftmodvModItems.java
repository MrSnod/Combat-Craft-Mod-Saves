
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.combatcraftmodv.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.combatcraftmodv.item.XraySpellItem;
import net.mcreator.combatcraftmodv.item.TeleportSpellItem;
import net.mcreator.combatcraftmodv.item.StrengthSpellItem;
import net.mcreator.combatcraftmodv.item.PandorasKnifeItem;
import net.mcreator.combatcraftmodv.item.NecronSwordItem;
import net.mcreator.combatcraftmodv.item.FlightSpellItem;
import net.mcreator.combatcraftmodv.item.FireSpellItem;
import net.mcreator.combatcraftmodv.CombatcraftmodvMod;

public class CombatcraftmodvModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CombatcraftmodvMod.MODID);
	public static final RegistryObject<Item> FIRE_SPELL = REGISTRY.register("fire_spell", () -> new FireSpellItem());
	public static final RegistryObject<Item> THE_SILENT_BANE = block(CombatcraftmodvModBlocks.THE_SILENT_BANE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ALTERNATE_STONE = block(CombatcraftmodvModBlocks.ALTERNATE_STONE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SOLDIER = REGISTRY.register("soldier_spawn_egg",
			() -> new ForgeSpawnEggItem(CombatcraftmodvModEntities.SOLDIER, -3381760, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> PANDORAS_KNIFE = REGISTRY.register("pandoras_knife", () -> new PandorasKnifeItem());
	public static final RegistryObject<Item> HEALER = REGISTRY.register("healer_spawn_egg",
			() -> new ForgeSpawnEggItem(CombatcraftmodvModEntities.HEALER, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> STRENGTH_SPELL = REGISTRY.register("strength_spell", () -> new StrengthSpellItem());
	public static final RegistryObject<Item> FLIGHT_SPELL = REGISTRY.register("flight_spell", () -> new FlightSpellItem());
	public static final RegistryObject<Item> TELEPORT_SPELL = REGISTRY.register("teleport_spell", () -> new TeleportSpellItem());
	public static final RegistryObject<Item> XRAY_SPELL = REGISTRY.register("xray_spell", () -> new XraySpellItem());
	public static final RegistryObject<Item> NECRON_SWORD = REGISTRY.register("necron_sword", () -> new NecronSwordItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
