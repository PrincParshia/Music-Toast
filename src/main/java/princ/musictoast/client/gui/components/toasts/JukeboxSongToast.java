package princ.musictoast.client.gui.components.toasts;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.toasts.ToastManager;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static princ.musictoast.MusicToastConstants.NAMESPACE;

public class JukeboxSongToast extends MusicToast {
    private String icon;

    public JukeboxSongToast(Component component, Component component2, String string) {
        super(component, component2);
        this.icon = string;
    }

    @Override
    public void render(GuiGraphics guiGraphics, Font font, long l) {
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, BACKGROUND_SPRITE, 0, 0, this.width(), this.height());
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, ResourceLocation.fromNamespaceAndPath(NAMESPACE, "toast/" + this.icon), 6, 6, 20, 20);
        guiGraphics.drawString(font, this.title, 30, 7, -256, false);
        guiGraphics.drawString(font, this.message, 30, 18, -1, false);
    }

    public void reset(Component component, Component component2, String string) {
        super.reset(component, component2);
        this.icon = string;
    }

    public static void addOrUpdate(ToastManager toastManager, Component component, Component component2, String string) {
        JukeboxSongToast jukeboxSongToast = toastManager.getToast(JukeboxSongToast.class, NO_TOKEN);
        if (jukeboxSongToast == null) {
            toastManager.addToast(new JukeboxSongToast(component, component2, string));
        } else {
            jukeboxSongToast.reset(component, component2, string);
        }
    }
}
