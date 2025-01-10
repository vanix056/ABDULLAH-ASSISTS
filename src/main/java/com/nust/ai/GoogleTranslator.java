package com.nust.ai;

import static com.nust.apputils.AppUtils.getUrlContent;
import org.jetbrains.annotations.NotNull;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GoogleTranslator {

    private final String deployId;

    public GoogleTranslator(String deployId) {
        this.deployId = deployId;
    }

    public @NotNull String translate(String langFrom, String langTo, String text) {
        try {
            // Construct the URL for the translation request
            String url = String.format(
                    "https://script.google.com/macros/s/%s/exec?q=%s&target=%s&source=%s",
                    deployId,
                    URLEncoder.encode(text, StandardCharsets.UTF_8),
                    langTo,
                    langFrom
            );
            
            // Debug: Log the URL
            System.out.println("Translation URL: " + url);
            
            // Fetch the translated text from the URL
            String translatedText = getUrlContent(url);

            // Debug: Log the translated text
            System.out.println("Translated Text: " + translatedText);

            return translatedText;
        } catch (Exception e) {
            e.printStackTrace();
            return "Translation error occurred.";
        }
    }
}
