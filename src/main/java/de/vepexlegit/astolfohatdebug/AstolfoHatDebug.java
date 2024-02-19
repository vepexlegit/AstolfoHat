package de.vepexlegit.astolfohatdebug;

import de.vepexlegit.astolfohatdebug.commands.*;
import de.vepexlegit.astolfohatdebug.utils.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraftforge.client.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import org.lwjgl.opengl.*;
import java.awt.*;

@Mod(modid = "astolfohatdebug", version = "1.0")
public class AstolfoHatDebug {
    private static final Minecraft mc = Minecraft.getMinecraft();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new AstolfoHatCommand());
    }

    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent event) {
        if (AstolfoHat.INSTANCE.isEnabled()) {
            double height = mc.thePlayer.isSneaking() ? -0.1D : 0.0D;
            GlStateManager.pushMatrix();
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glShadeModel(GL11.GL_SMOOTH);
            GL11.glTranslatef(0F, (float) (mc.thePlayer.height + height), 0F);
            GL11.glRotatef(-mc.thePlayer.rotationYaw, 0F, 1F, 0F);
            Color color2 = Color.WHITE;
            color2 = ColorUtils.astolfoColors(5000.0F, 1);
            GL11.glBegin(GL11.GL_TRIANGLE_FAN);
            RenderUtils.glColor(color2, 255);
            GL11.glVertex3d(0.0, 0.3, 0.0);
            for (float i = 0; i < 360.5; i += 1) {
                Color color = Color.WHITE;
                color = ColorUtils.astolfo(i - i + 1, i, 1.0F, 10);
                RenderUtils.glColor(color, 80);
                GL11.glVertex3d(Math.cos(i * Math.PI / 180.0) * 0.66, 0, Math.sin(i * Math.PI / 180.0) * 0.66);
            }
            GL11.glEnd();
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glShadeModel(GL11.GL_FLAT);
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GlStateManager.resetColor();
            GlStateManager.popMatrix();
        }
    }
}
