package WayofTime.alchemicalWizardry.common.spell.complex.effect.impactEffects.ice;

import WayofTime.alchemicalWizardry.api.spell.ExtrapolatedMeleeEntityEffect;
import WayofTime.alchemicalWizardry.common.spell.complex.effect.SpellHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class MeleeOffensiveIce extends ExtrapolatedMeleeEntityEffect {
    public MeleeOffensiveIce(int power, int potency, int cost) {
        super(power, potency, cost);
        this.setMaxNumberHit(1 + potency);
        this.setRadius(2);
        this.setRange(3);
    }

    @Override
    protected boolean entityEffect(World world, Entity entity, EntityPlayer entityPlayer) {
        Vec3 blockVector = SpellHelper.getEntityBlockVector(entity);

        int posX = (int) (blockVector.xCoord);
        int posY = (int) (blockVector.yCoord);
        int posZ = (int) (blockVector.zCoord);

        entity.motionY = 1 * (0.3 * this.powerUpgrades + 0.90);

        for (int i = 0; i < 2; i++) {
            if (world.isAirBlock(posX, posY + i, posZ)) {
                world.setBlock(posX, posY + i, posZ, Blocks.ice);
            }
        }

        entity.fallDistance = 0.0f;
        return true;
    }
}
