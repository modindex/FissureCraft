package io.github.hypatech.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class TestChestScreen extends AbstractContainerScreen<TestChestContainer> {
    public TestChestScreen(TestChestContainer container_1, PlayerInventory playerInventory_1, Text text_1) {
        super(container_1, playerInventory_1, text_1);
    }

    @Override
    protected void drawBackground(float var1, int var2, int var3) {
        GlStateManager.color3f(255, 0, 0);
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
    }

    @Override
    public boolean keyPressed(int int_1, int int_2, int int_3) {
        if (int_1 == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(int_1, int_2, int_3);
    }

    @Override
    public void render(int int_1, int int_2, float float_1){
        renderBackground();
        super.render(int_1, int_2, float_1);
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
    }
}
