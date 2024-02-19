package de.vepexlegit.astolfohatdebug.utils;

import java.awt.*;

public class ColorUtils {
    public static Color astolfoColors(float speed, int yOffset) {
        float hue;
        for (hue = (float)(System.currentTimeMillis() % (long)((int)speed) + (long)yOffset); hue > speed; hue -= speed) {}
        if ((double)(hue /= speed) > 0.5F) {
            hue = 0.5F - (hue - 0.5F);
        }
        return Color.getHSBColor(hue += 0.5F, 0.4F, 1.0F);
    }

    public static Color astolfo(float yDist, float yTotal, float saturation, float speedt) {
        float speed = 1800F;
        float hue = (System.currentTimeMillis() % (int)speed) + (yTotal - yDist) * speedt;
        while (hue > speed) {
            hue -= speed;
        }
        hue /= speed;
        if (hue > 0.5F) {
            hue = 0.5F - (hue - 0.5F);
        }
        hue += 0.5F;
        return Color.getHSBColor(hue, saturation, 1F);
    }
}
