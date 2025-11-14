package princ.musictoast;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.ToastManager;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.core.Holder;
import net.minecraft.world.item.JukeboxSong;
import princ.musictoast.client.mixin.MusicManagerAccessor;

public class MusicToastConstants {
    public static final String NAMESPACE = "music-toast";

    public static Minecraft minecraft() {
        return Minecraft.getInstance();
    }

    public static MusicManager musicManager() {
        return minecraft().getMusicManager();
    }

    public static ToastManager toastManager() {
        return minecraft().getToastManager();
    }

    public static SoundInstance currentMusic() {
        return ((MusicManagerAccessor) musicManager()).currentMusic();
    }

    public static String getMusicName() {
        String string = currentMusic().getSound().getLocation().getPath();
        return "music." + string.substring(string.lastIndexOf("/") + 1);
    }

    public static String getJukeboxSongName(Holder<JukeboxSong> holder, boolean bl) {
        if (bl) {
            return holder.value().soundEvent().value().location().getPath();
        } else {
            return "music_disc_" + holder.value().soundEvent().value().location().getPath().substring("music_disc.".length());
        }
    }

    public static String getMusicArtist() {
        String c418 = "C418", lenaRaine = "Lena Raine", kumiTanioka = "Kumi Tanioka", aaronCherof = "Aaron Cherof", amosRoddy = "Amos Roddy";

        if (getMusicName().contains("aerie")) return lenaRaine;
        else if (getMusicName().contains("aria_math")) return c418;
        else if (getMusicName().contains("ancestry")) return lenaRaine;
        else if (getMusicName().contains("a_familiar_room")) return aaronCherof;
        else if (getMusicName().contains("an_ordinary_day")) return kumiTanioka;
        else if (getMusicName().contains("below_and_above")) return amosRoddy;
        else if (getMusicName().contains("biome_fest")) return c418;
        else if (getMusicName().contains("blind_spots")) return c418;
        else if (getMusicName().contains("broken_clocks")) return amosRoddy;
        else if (getMusicName().contains("bromeliad")) return aaronCherof;
        else if (getMusicName().contains("clark")) return c418;
        else if (getMusicName().contains("comforting_memories")) return kumiTanioka;
        else if (getMusicName().contains("crescent_dunes")) return aaronCherof;
        else if (getMusicName().contains("danny")) return c418;
        else if (getMusicName().contains("deeper")) return lenaRaine;
        else if (getMusicName().contains("dreiton")) return c418;
        else if (getMusicName().contains("dry_hands")) return c418;
        else if (getMusicName().contains("echo_in_the_wind")) return aaronCherof;
        else if (getMusicName().contains("eld_unknown")) return lenaRaine;
        else if (getMusicName().contains("endless")) return lenaRaine;
        else if (getMusicName().contains("featherfall")) return aaronCherof;
        else if (getMusicName().contains("firebugs")) return lenaRaine;
        else if (getMusicName().contains("fireflies")) return amosRoddy;
        else if (getMusicName().contains("floating_dream")) return kumiTanioka;
        else if (getMusicName().contains("haggstrom")) return c418;
        else if (getMusicName().contains("haunt_muskie")) return c418;
        else if (getMusicName().contains("infinite_amethyst")) return lenaRaine;
        else if (getMusicName().contains("key")) return c418;
        else if (getMusicName().contains("komorebi")) return kumiTanioka;
        else if (getMusicName().contains("labyrinthine")) return lenaRaine;
        else if (getMusicName().contains("left_to_bloom")) return lenaRaine;
        else if (getMusicName().contains("lilypad")) return amosRoddy;
        else if (getMusicName().contains("living_mice")) return c418;
        else if (getMusicName().contains("mice_on_venus")) return c418;
        else if (getMusicName().contains("minecraft")) return c418;
        else if (getMusicName().contains("one_more_day")) return lenaRaine;
        else if (getMusicName().contains("os_piano")) return amosRoddy;
        else if (getMusicName().contains("oxygene")) return c418;
        else if (getMusicName().contains("pokopoko")) return kumiTanioka;
        else if (getMusicName().contains("puzzlebox")) return aaronCherof;
        else if (getMusicName().contains("stand_tall")) return lenaRaine;
        else if (getMusicName().contains("subwoofer_lullaby")) return c418;
        else if (getMusicName().contains("sweden")) return c418;
        else if (getMusicName().contains("taswell")) return c418;
        else if (getMusicName().contains("watcher")) return aaronCherof;
        else if (getMusicName().contains("wending")) return lenaRaine;
        else if (getMusicName().contains("wet_hands")) return c418;
        else if (getMusicName().contains("yakusoku")) return kumiTanioka;
        else if (getMusicName().contains("axolotl")) return c418;
        else if (getMusicName().contains("dragon_fish")) return c418;
        else if (getMusicName().contains("shuniji")) return c418;
        else if (getMusicName().contains("ballad_of_the_cats")) return c418;
        else if (getMusicName().contains("chrysopoeia")) return lenaRaine;
        else if (getMusicName().contains("concrete_halls")) return c418;
        else if (getMusicName().contains("dead_voxel")) return c418;
        else if (getMusicName().contains("rubedo")) return lenaRaine;
        else if (getMusicName().contains("so_below")) return lenaRaine;
        else if (getMusicName().contains("warmth")) return c418;
        else if (getMusicName().contains("boss")) return c418;
        else if (getMusicName().contains("the_end")) return c418;
        else if (getMusicName().contains("alpha")) return c418;
        else if (getMusicName().contains("beginning_2")) return c418;
        else if (getMusicName().contains("floating_trees")) return c418;
        else if (getMusicName().contains("moog_city_2")) return c418;
        else if (getMusicName().contains("mutation")) return c418;
        return null;
    }

    public static String getJukeboxSongArtist(Holder<JukeboxSong> holder) {
        String c418 = "C418", lenaRaine = "Lena Raine", samuelAberg = "Samuel Åberg", aaronCherof = "Aaron Cherof", amosRoddy = "Amos Roddy", hyperPotions = "Hyper Potions";

        if (getJukeboxSongName(holder, true).contains("13")) return c418;
        else if (getJukeboxSongName(holder, true).contains("cat")) return c418;
        else if (getJukeboxSongName(holder, true).contains("blocks")) return c418;
        else if (getJukeboxSongName(holder, true).contains("chirp")) return c418;
        else if (getJukeboxSongName(holder, true).contains("far")) return c418;
        else if (getJukeboxSongName(holder, true).contains("mall")) return c418;
        else if (getJukeboxSongName(holder, true).contains("mellohi")) return c418;
        else if (getJukeboxSongName(holder, true).contains("stal")) return c418;
        else if (getJukeboxSongName(holder, true).contains("strad")) return c418;
        else if (getJukeboxSongName(holder, true).contains("ward")) return c418;
        else if (getJukeboxSongName(holder, true).contains("11")) return c418;
        else if (getJukeboxSongName(holder, true).contains("wait")) return c418;
        else if (getJukeboxSongName(holder, true).contains("pigstep")) return lenaRaine;
        else if (getJukeboxSongName(holder, true).contains("otherside")) return lenaRaine;
        else if (getJukeboxSongName(holder, true).contains("creator")) return lenaRaine;
        else if (getJukeboxSongName(holder, true).contains("creator_music_box")) return lenaRaine;
        else if (getJukeboxSongName(holder, true).contains("5")) return samuelAberg;
        else if (getJukeboxSongName(holder, true).contains("relic")) return aaronCherof;
        else if (getJukeboxSongName(holder, true).contains("precipice")) return aaronCherof;
        else if (getJukeboxSongName(holder, true).contains("tears")) return amosRoddy;
        else if (getJukeboxSongName(holder, true).contains("lava_chicken")) return hyperPotions;
        return null;
    }
}
