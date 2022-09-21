
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.combatcraftmodv.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.combatcraftmodv.entity.SoldierEntity;
import net.mcreator.combatcraftmodv.entity.HealerEntity;
import net.mcreator.combatcraftmodv.entity.GhostEntity;
import net.mcreator.combatcraftmodv.entity.FireSpellEntity;
import net.mcreator.combatcraftmodv.CombatcraftmodvMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CombatcraftmodvModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, CombatcraftmodvMod.MODID);
	public static final RegistryObject<EntityType<FireSpellEntity>> FIRE_SPELL = register("projectile_fire_spell",
			EntityType.Builder.<FireSpellEntity>of(FireSpellEntity::new, MobCategory.MISC).setCustomClientFactory(FireSpellEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SoldierEntity>> SOLDIER = register("soldier",
			EntityType.Builder.<SoldierEntity>of(SoldierEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(SoldierEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HealerEntity>> HEALER = register("healer",
			EntityType.Builder.<HealerEntity>of(HealerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(HealerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GhostEntity>> GHOST = register("ghost",
			EntityType.Builder.<GhostEntity>of(GhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(GhostEntity::new).fireImmune().sized(0.9f, 1.4f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SoldierEntity.init();
			HealerEntity.init();
			GhostEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SOLDIER.get(), SoldierEntity.createAttributes().build());
		event.put(HEALER.get(), HealerEntity.createAttributes().build());
		event.put(GHOST.get(), GhostEntity.createAttributes().build());
	}
}
