package com.nust.ai.sphinxextextension;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.Microphone;
import edu.cmu.sphinx.frontend.util.StreamDataSource;

import java.io.IOException;

public class LiveSpeechRecognizerExtension extends AbstractSpeechRecognizerExtension {

    private final Microphone microphone;

    public LiveSpeechRecognizerExtension(Configuration configuration) throws IOException {
        super(configuration);
        microphone = speechSourceProviderExtension.getMicrophone();
        context.getInstance(StreamDataSource.class).setInputStream(microphone.getStream());
    }

    public void startRecognition() {
        recognizer.allocate();
        microphone.startRecording();
    }

    public void stopRecognition() {
        microphone.stopRecording();
        recognizer.deallocate();
    }
}
