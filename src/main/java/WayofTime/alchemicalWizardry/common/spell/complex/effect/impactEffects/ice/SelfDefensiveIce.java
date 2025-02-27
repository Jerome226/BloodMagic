package WayofTime.alchemicalWizardry.common.spell.complex.effect.impactEffects.ice;

import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import WayofTime.alchemicalWizardry.api.spell.SelfSpellEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class SelfDefensiveIce extends SelfSpellEffect {
    public SelfDefensiveIce(int power, int potency, int cost) {
        super(power, potency, cost);
    }

    @Override
    public void onSelfUse(World world, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(
                AlchemicalWizardry.customPotionIceCloak.id, 300 * (2 * this.powerUpgrades + 1), this.potencyUpgrades));
    }
}
