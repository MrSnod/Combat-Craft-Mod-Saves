package net.mcreator.combatcraftmodv.procedures;

import net.minecraft.world.entity.Entity;

public class SpellBookFoodEatenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
						"give @p written_book{pages:['[\"\",{\"text\":\"Book Of Spells\",\"obfuscated\":true},{\"text\":\"\\\\n\\\\n\",\"color\":\"reset\"},{\"text\":\"Summon Fire\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/give @s FireSpell\"}},{\"text\":\"\\\\n\\\\n\"},{\"text\":\"Teleport Spell\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/give @s TeleportSpell\"}},{\"text\":\"\\\\n\\\\n\"},{\"text\":\"Give Strength\",\"color\":\"red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/give @s StrengthSpell\"}},{\"text\":\"\\\\n\\\\n\",\"color\":\"reset\"},{\"text\":\"Xray Vision\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/give @s XraySpell\"}},{\"text\":\"\\\\n\\\\n\"},{\"text\":\"The Gift Of Flight\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"/give @s FlightSpell\"}}]'],title:\"Book Of Power\",author:\"???\",display:{Lore:[\"Uses Undetermined\"]}}");
		}
	}
}
