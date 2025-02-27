package WayofTime.alchemicalWizardry.common.spell.complex.effect.impactEffects.fire;

import WayofTime.alchemicalWizardry.api.spell.ProjectileImpactEffect;
import WayofTime.alchemicalWizardry.common.spell.complex.effect.SpellHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ProjectileDefensiveFire extends ProjectileImpactEffect {
    public ProjectileDefensiveFire(int power, int potency, int cost) {
        super(power, potency, cost);
    }

    @Override
    public void onEntityImpact(Entity mop, Entity proj) {
        mop.setFire(3 * (this.potencyUpgrades + 1));
    }

    @Override
    public void onTileImpact(World world, MovingObjectPosition mop) {
        int horizRange = this.powerUpgrades;
        int vertRange = this.powerUpgrades;

        int posX = mop.blockX;
        int posY = mop.blockY;
        int posZ = mop.blockZ;

        for (int i = -horizRange; i <= horizRange; i++) {
            for (int j = -vertRange; j <= vertRange; j++) {
                for (int k = -horizRange; k <= horizRange; k++) {
                    if (!world.isAirBlock(posX + i, posY + j, posZ + k)) {
                        SpellHelper.smeltBlockInWorld(world, posX + i, posY + j, posZ + k);
                    }
                }
            }
        }
    }
}
