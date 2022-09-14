package net.mcreator.combatcraftmodv.procedures;

import net.minecraft.world.entity.Entity;

public class HealerEntityDiesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
						"effect give @e[limit=4,name=Soldier,gamemode=survival,sort=arbitrary] regeneration 20 2");
		}
	}
}
