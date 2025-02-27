package WayofTime.alchemicalWizardry.common.items.potion;

import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;

public class EnhancedFillingAgent extends WeakFillingAgent {
    public EnhancedFillingAgent() {
        super();
        setCreativeTab(AlchemicalWizardry.tabBloodMagic);
    }

    @Override
    public int getFilledAmountForPotionNumber(int potionEffects) {
        if (potionEffects == 0) {
            return 8;
        }
        {
            switch (potionEffects) {
                case 1:
                    return 6;

                case 2:
                    return 4;

                case 3:
                    return 3;

                case 4:
                    return 2;

                case 5:
                    return 2;
            }
        }
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("AlchemicalWizardry:EnhancedFillingAgent");
    }
}
