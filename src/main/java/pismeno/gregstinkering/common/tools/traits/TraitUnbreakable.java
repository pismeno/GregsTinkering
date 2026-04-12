package pismeno.gregstinkering.common.tools.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitUnbreakable extends AbstractTrait {

    public TraitUnbreakable() {
        super("gtcunbreakable", TextFormatting.WHITE);
    }

    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        newDamage = 0;

        return super.onToolDamage(tool, damage, newDamage, entity);
    }
}
