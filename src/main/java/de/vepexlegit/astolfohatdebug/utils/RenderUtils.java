package de.vepexlegit.astolfohatdebug.utils;

import net.minecraft.client.renderer.*;
import java.awt.*;

public class RenderUtils {
    public static void glColor(final Color color, final int alpha) {
        glColor(color, alpha / 255F);
    }

    public static void glColor(final Color color, final float alpha) {
        final float red = color.getRed() / 255F;
        final float green = color.getGreen() / 255F;
        final float blue = color.getBlue() / 255F;
        GlStateManager.color(red, green, blue, alpha);
    }
}
