package com.nust.ai;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 * The Synthesizer class represents a text-to-speech synthesizer that can convert text into speech.
 * It uses the FreeTTS library for speech synthesis. <a href="https://cmusphinx.github.io/wiki/tutorial/">Tutorial</a>.
 *
 */
public class Synthesizer implements AutoCloseable {

    private final Voice voice;

    private Synthesizer(String voiceName, float pitch) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voice = VoiceManager.getInstance().getVoice(voiceName);
        voice.setPitch(pitch);
        voice.allocate();
    }

    private static final class SynthesizerHolder {
        private static final Synthesizer instance = new Synthesizer("kevin16", 120);
    }

    public static Synthesizer getInstance() {
        return SynthesizerHolder.instance;
    }

    public void speak(String message) {
        voice.speak(message);
    }

    @Override
    public void close() {
        voice.deallocate();
    }
}
