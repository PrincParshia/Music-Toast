package princ.musictoast.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.JukeboxSongPlayer;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import princ.musictoast.client.gui.components.toasts.JukeboxSongToast;

import static princ.musictoast.MusicToastConstants.*;

@Mixin(JukeboxSongPlayer.class)
@Environment(EnvType.CLIENT)
public class JukeboxSongPlayerMixin {
    @Inject( method = "play", at = @At("RETURN") )
    public void play(LevelAccessor levelAccessor, Holder<JukeboxSong> holder, CallbackInfo callbackInfo) {
        JukeboxSongToast.addOrUpdate(toastManager(), Component.translatable(getJukeboxSongName(holder, true)), Component.literal("by " + getJukeboxSongArtist(holder)), getJukeboxSongName(holder, false));
    }
}
