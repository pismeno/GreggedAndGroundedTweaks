package pismeno.gagtweaks.client;

import com.pg85.otg.forge.gui.mainmenu.OTGGuiWorldSelection;
import com.pg85.otg.forge.gui.presets.OTGGuiPresetList;
import net.minecraft.client.gui.*;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

@SideOnly(Side.CLIENT)
public class GAGGuiWorldSelection extends GuiWorldSelection {
    public GAGGuiWorldSelection(GuiScreen parentScreen) {
        super(parentScreen);
    }

    @Override
    public void initGui() {
        super.initGui();

        this.buttonList.removeIf(button -> button.id == 5);
        for (GuiButton button : this.buttonList) {
            int buttonWidth = 98;
            int buttonSpacing = 8;
            int totalWidth = buttonWidth * 3 + buttonSpacing * 2;
            int startX = this.width / 2 - totalWidth / 2;

            if (button.id == 4) {
                button.setWidth(buttonWidth);
                button.x = startX + 1;
            }

            if (button.id == 2) {
                button.setWidth(buttonWidth);
                button.x = startX + buttonWidth + buttonSpacing;
            }

            if (button.id == 0) {
                button.setWidth(buttonWidth);
                button.x = startX + 2 * (buttonWidth + buttonSpacing) - 1;
            }
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 3) {
            this.mc.displayGuiScreen(new OTGGuiPresetList(this));
            return;
        }

        super.actionPerformed(button);
    }

    public static void init(GuiOpenEvent event) {
        GuiScreen gui = event.getGui();
        if (gui instanceof OTGGuiWorldSelection) {
            event.setGui(new GAGGuiWorldSelection(new GuiMainMenu()));
        }
    }
}
