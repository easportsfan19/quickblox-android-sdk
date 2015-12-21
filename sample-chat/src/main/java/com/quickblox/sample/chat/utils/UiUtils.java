package com.quickblox.sample.chat.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;

import com.quickblox.sample.chat.App;
import com.quickblox.sample.chat.R;
import com.quickblox.sample.core.utils.ResourceUtils;

import java.util.Random;

public class UiUtils {

    private static final Random random = new Random();
    private static int previousColor;

    private UiUtils() {}

    public static Drawable getGreyCircleDrawable() {
        return getColoredCircleDrawable(ResourceUtils.getColor(R.color.color_grey));
    }

    public static Drawable getRandomColorCircleDrawable() {
        return getColoredCircleDrawable(getRandomColor());
    }

    private static Drawable getColoredCircleDrawable(@ColorInt int color) {
        GradientDrawable drawable = (GradientDrawable) ResourceUtils.getDrawable(R.drawable.shape_circle);
        drawable.setColor(color);
        return drawable;
    }

    public static int getRandomColor() {
        int randomNumber = random.nextInt(10) + 1;
        String colorIdName = String.format("random_color_%d", randomNumber);

        int colorId = App.getInstance().getResources().getIdentifier(colorIdName, "color", App.getInstance().getPackageName());

        int generatedColor = ResourceUtils.getColor(colorId);
        if (generatedColor != previousColor) {
            previousColor = generatedColor;
            return generatedColor;
        } else {
            do {
                generatedColor = getRandomColor();
            } while (generatedColor != previousColor);
        }
        return previousColor;
    }
}