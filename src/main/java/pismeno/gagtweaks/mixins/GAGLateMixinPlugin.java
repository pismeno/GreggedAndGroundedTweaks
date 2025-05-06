package pismeno.gagtweaks.mixins;

import java.util.Arrays;
import java.util.List;
import zone.rong.mixinbooter.ILateMixinLoader;

public class GAGLateMixinPlugin implements ILateMixinLoader {
    public GAGLateMixinPlugin() {
    }

    public List<String> getMixinConfigs() {
        String[] configs = new String[]{"mixins.gagtweaks.late.json"};
        return Arrays.asList(configs);
    }
}