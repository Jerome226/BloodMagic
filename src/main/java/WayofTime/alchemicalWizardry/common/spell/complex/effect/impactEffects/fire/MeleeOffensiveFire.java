package WayofTime.alchemicalWizardry.common.spell.complex.effect.impactEffects.fire;

import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import WayofTime.alchemicalWizardry.api.spell.ExtrapolatedMeleeEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MeleeOffensiveFire extends ExtrapolatedMeleeEntityEffect {
    public MeleeOffensiveFire(int power, int potency, int cost) {
        super(power, potency, cost);
        this.setRange(3 + 0.3f * potency);
        this.setRadius(2 + 0.3f * potency);
        this.setMaxNumberHit(1);
    }

    @Override
    protected boolean entityEffect(World world, Entity entity, EntityPlayer entityPlayer) {
        if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase) entity)
                    .addPotionEffect(new PotionEffect(
                            AlchemicalWizardry.customPotionFireFuse.id,
                            20 * (7 - this.powerUpgrades),
                            this.potencyUpgrades));
            return true;
        }

        return false;
    }
}
