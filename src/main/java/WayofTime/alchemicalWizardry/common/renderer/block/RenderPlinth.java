package WayofTime.alchemicalWizardry.common.renderer.block;

import WayofTime.alchemicalWizardry.common.renderer.model.ModelPlinth;
import WayofTime.alchemicalWizardry.common.tileEntity.TEPlinth;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class RenderPlinth extends TileEntitySpecialRenderer {
    private ModelPlinth modelPlinth = new ModelPlinth();
    private final RenderItem customRenderItem;

    public RenderPlinth() {
        customRenderItem = new RenderItem() {
            @Override
            public boolean shouldBob() {
                return false;
            }
        };
        customRenderItem.setRenderManager(RenderManager.instance);
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1, double d2, float f) {
        if (tileEntity instanceof TEPlinth) {
            TEPlinth tilePlinth = (TEPlinth) tileEntity;
            GL11.glPushMatrix();
            GL11.glTranslatef((float) d0 + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
            ResourceLocation test = new ResourceLocation("alchemicalwizardry:textures/models/Plinth.png");
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            this.modelPlinth.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glPushMatrix();

            if (tilePlinth.getStackInSlot(0) != null) {

                boolean fancySaved = Minecraft.isFancyGraphicsEnabled();
                Minecraft.getMinecraft().gameSettings.fancyGraphics = true;

                float scaleFactor = getGhostItemScaleFactor(tilePlinth.getStackInSlot(0));
                EntityItem ghostEntityItem = new EntityItem(tilePlinth.getWorldObj());
                ghostEntityItem.hoverStart = 0.0F;
                ghostEntityItem.setEntityItemStack(tilePlinth.getStackInSlot(0));
                float displacement = 0.2F;

                if (ghostEntityItem.getEntityItem().getItem() instanceof ItemBlock) {
                    GL11.glTranslatef((float) d0 + 0.5F, (float) d1 + displacement + 0.7F, (float) d2 + 0.5F);
                } else {
                    GL11.glTranslatef(
                            (float) d0 + 0.5F, (float) d1 + displacement + 10.4f / 16.0f, (float) d2 + 0.5F - 0.1875f);
                }
                GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);

                if (!(ghostEntityItem.getEntityItem().getItem() instanceof ItemBlock)) {
                    GL11.glRotatef(90f, 1.0f, 0.0f, 0.0F);
                }

                customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);

                Minecraft.getMinecraft().gameSettings.fancyGraphics = fancySaved;
            }

            GL11.glPopMatrix();
        }
    }

    private float getGhostItemScaleFactor(ItemStack itemStack) {
        float scaleFactor = 2.0F / 0.9F;

        if (itemStack != null) {
            if (itemStack.getItem() instanceof ItemBlock) {
                switch (customRenderItem.getMiniBlockCount(itemStack, (byte) 1)) {
                    case 1:
                        return 0.90F * scaleFactor / 2;

                    case 2:
                        return 0.90F * scaleFactor / 2;

                    case 3:
                        return 0.90F * scaleFactor / 2;

                    case 4:
                        return 0.90F * scaleFactor / 2;

                    case 5:
                        return 0.80F * scaleFactor / 2;

                    default:
                        return 0.90F * scaleFactor / 2;
                }
            } else {
                switch (customRenderItem.getMiniItemCount(itemStack, (byte) 1)) {
                    case 1:
                        return 0.65F * scaleFactor;

                    case 2:
                        return 0.65F * scaleFactor;

                    case 3:
                        return 0.65F * scaleFactor;

                    case 4:
                        return 0.65F * scaleFactor;

                    default:
                        return 0.65F * scaleFactor;
                }
            }
        }

        return scaleFactor;
    }

    private void translateGhostItemByOrientation(
            ItemStack ghostItemStack, double x, double y, double z, ForgeDirection forgeDirection) {
        if (ghostItemStack != null) {
            if (ghostItemStack.getItem() instanceof ItemBlock) {
                switch (forgeDirection) {
                    case DOWN: {
                        GL11.glTranslatef((float) x + 0.5F, (float) y + 2.7F, (float) z + 0.5F);
                        return;
                    }

                    case UP: {
                        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.25F, (float) z + 0.5F);
                        return;
                    }

                    case NORTH: {
                        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.7F);
                        return;
                    }

                    case SOUTH: {
                        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.3F);
                        return;
                    }

                    case EAST: {
                        GL11.glTranslatef((float) x + 0.3F, (float) y + 0.5F, (float) z + 0.5F);
                        return;
                    }

                    case WEST: {
                        GL11.glTranslatef((float) x + 0.70F, (float) y + 0.5F, (float) z + 0.5F);
                        return;
                    }

                    case UNKNOWN: {
                        return;
                    }

                    default: {
                    }
                }
            } else {
                switch (forgeDirection) {
                    case DOWN: {
                        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.6F, (float) z + 0.5F);
                        return;
                    }

                    case UP: {
                        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.20F, (float) z + 0.5F);
                        return;
                    }

                    case NORTH: {
                        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.4F, (float) z + 0.7F);
                        return;
                    }

                    case SOUTH: {
                        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.4F, (float) z + 0.3F);
                        return;
                    }

                    case EAST: {
                        GL11.glTranslatef((float) x + 0.3F, (float) y + 0.4F, (float) z + 0.5F);
                        return;
                    }

                    case WEST: {
                        GL11.glTranslatef((float) x + 0.70F, (float) y + 0.4F, (float) z + 0.5F);
                        return;
                    }

                    case UNKNOWN: {
                        return;
                    }

                    default: {
                    }
                }
            }
        }
    }
}
