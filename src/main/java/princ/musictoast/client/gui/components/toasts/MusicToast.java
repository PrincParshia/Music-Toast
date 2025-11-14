package princ.musictoast.client.gui.components.toasts;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastManager;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static princ.musictoast.MusicToastConstants.*;

@Environment(EnvType.CLIENT)
public class MusicToast implements Toast {
    public static final ResourceLocation BACKGROUND_SPRITE = ResourceLocation.fromNamespaceAndPath(NAMESPACE, "toast/music");
    public Component title;
    public Component message;
    private long lastChanged;
    private boolean changed;
    private Visibility wantedVisibility;

    public MusicToast(Component component, Component component2) {
        this.title = component;
        this.message = component2;
    }

    @Override
    public Visibility getWantedVisibility() {
        return this.wantedVisibility;
    }

    @Override
    public void update(ToastManager toastManager, long l) {
        if (this.changed) {
            this.lastChanged = l;
            this.changed = false;
        }

        this.wantedVisibility = (l - this.lastChanged) < (double) 5000.0F * toastManager.getNotificationDisplayTimeMultiplier() ? Visibility.SHOW : Visibility.HIDE;
    }

    @Override
    public void render(GuiGraphics guiGraphics, Font font, long l) {
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, BACKGROUND_SPRITE, 0, 0, this.width(), this.height());
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, ResourceLocation.fromNamespaceAndPath(NAMESPACE, "toast/note_block"), 6, 6, 20, 20);
        guiGraphics.drawString(font, this.title, 30, 7, -256, false);
        guiGraphics.drawString(font, this.message, 30, 18, -1, false);
    }

    public void reset(Component component, Component component2) {
        this.title = component;
        this.message = component2;
        this.changed = true;
    }

    public static void addOrUpdate(ToastManager toastManager, Component component, Component component2) {
        MusicToast musicToast = toastManager.getToast(MusicToast.class, NO_TOKEN);
        if (musicToast == null) {
            toastManager.addToast(new MusicToast(component, component2));
        } else {
            musicToast.reset(component, component2);
        }
    }
}
