package WayofTime.alchemicalWizardry.api.alchemy;

import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.ItemStack;

public class AlchemyRecipeRegistry {
    public static List<AlchemyRecipe> recipes = new ArrayList();

    public static void registerRecipe(ItemStack output, int amountNeeded, ItemStack[] recipe, int bloodOrbLevel) {
        recipes.add(new AlchemyRecipe(output, amountNeeded, recipe, bloodOrbLevel));
    }

    public static ItemStack getResult(ItemStack[] recipe, ItemStack bloodOrb) {
        if (bloodOrb == null) {
            return null;
        }

        if (!(bloodOrb.getItem() instanceof IBloodOrb)) {
            return null;
        }

        int bloodOrbLevel = ((IBloodOrb) bloodOrb.getItem()).getOrbLevel();

        for (AlchemyRecipe ar : recipes) {
            if (ar.doesRecipeMatch(recipe, bloodOrbLevel)) {
                return (ar.getResult());
            }
        }

        return null;
    }

    public static int getAmountNeeded(ItemStack[] recipe, ItemStack bloodOrb) {
        if (bloodOrb == null) {
            return 0;
        }

        if (!(bloodOrb.getItem() instanceof IBloodOrb)) {
            return 0;
        }

        int bloodOrbLevel = ((IBloodOrb) bloodOrb.getItem()).getOrbLevel();

        for (AlchemyRecipe ar : recipes) {
            if (ar.doesRecipeMatch(recipe, bloodOrbLevel)) {
                return (ar.getAmountNeeded());
            }
        }

        return 0;
    }

    public static ItemStack[] getRecipeForItemStack(ItemStack itemStack) {
        for (AlchemyRecipe ar : recipes) {
            ItemStack result = ar.getResult();

            if (result != null) {
                if (result.isItemEqual(itemStack)) {
                    return ar.getRecipe();
                }
            }
        }

        return null;
    }
}
