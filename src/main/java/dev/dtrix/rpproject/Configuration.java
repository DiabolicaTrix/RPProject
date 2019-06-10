package dev.dtrix.rpproject;

import net.minecraftforge.common.config.Config;

@Config(modid = RPProject.MODID, category = "General")
public class Configuration {
    public static Experience experience = new Experience();

    private static class Experience {
        public static String[] blockBreaking = new String[]{"coal_ore"};
    }

}
