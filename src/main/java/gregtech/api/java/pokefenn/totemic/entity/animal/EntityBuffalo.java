package gregtech.api.java.pokefenn.totemic.entity.animal;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

/**
 * Stub version of EntityBuffalo for use when Totemic is not loaded.
 * Provides just enough structure to allow dependent mods to compile.
 */
public class EntityBuffalo extends EntityAnimal {

    public EntityBuffalo(World worldIn) {
        super(worldIn);
    }

    // Dummy implementation of required abstract method
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null; // or return this if needed, but null is safest for a stub
    }

    // Optional stubs for common methods that may be accessed
    @Override
    public int getGrowingAge() {
        return 0;
    }

    @Override
    public void setGrowingAge(int age) {
        // no-op
    }

    @Override
    public boolean isChild() {
        return false;
    }
}