package io.classwarfare;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by brianabbott on 5/14/16.
 */
public class Sounds {

    /**
     * PLAY SOUND OF GUN FIRING
     */
    public static void playGunshot() {
        URL gunFireSoundFile = null;
        try {
            gunFireSoundFile = new File("src/main/resources/gunshot.wav").toURI().toURL();
            AudioClip clip = Applet.newAudioClip(gunFireSoundFile);
            clip.play();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * PLAY DRY FIRE SOUND
     */
    public static void playDryFireshot() {
        URL dryGunSoundFile = null;
        try {
            dryGunSoundFile = new File("src/main/resources/drygun.wav").toURI().toURL();
            AudioClip clip = Applet.newAudioClip(dryGunSoundFile);
            clip.play();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     *  PLAY CHA-CHING SOUNDS
     */
    public static void playGetMoneySound() {
        URL moneyFile = null;
        try {
            moneyFile = new File("src/main/resources/cash_register.wav").toURI().toURL();
            AudioClip clip = Applet.newAudioClip(moneyFile);
            clip.play();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
