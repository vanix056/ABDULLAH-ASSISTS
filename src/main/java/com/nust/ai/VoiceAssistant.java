package com.nust.ai;

import com.nust.ai.sphinxextextension.LiveSpeechRecognizerExtension;
import edu.cmu.sphinx.api.Configuration;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;

public final class VoiceAssistant {

    private final LiveSpeechRecognizerExtension lsr;
    private boolean isRecognizing = false;

    public VoiceAssistant(String dictFilename, String LMFilename) {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath(
                String.format("resource:%s", "/edu/cmu/sphinx/models/en-us/en-us"));
        configuration.setDictionaryPath(
                String.format("file:%s/src/main/java/com/nust/resources/%s", System.getProperty("user.dir"), dictFilename));
        configuration.setLanguageModelPath(
                String.format("file:%s/src/main/java/com/nust/resources/%s", System.getProperty("user.dir"), LMFilename));
        try {
            lsr = new LiveSpeechRecognizerExtension(configuration);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public @NotNull String getCommand() {
        return lsr.getResult().getHypothesis().toLowerCase();
    }

    public int getCode(@NotNull String voiceCommand) {
        voiceCommand = voiceCommand.toLowerCase();
        
        // Play music cases
        if (voiceCommand.startsWith("play music") ||
            voiceCommand.startsWith("start music") ||
            voiceCommand.startsWith("begin music") ||
            voiceCommand.startsWith("play some music") ||
            voiceCommand.startsWith("start some music") ||
            voiceCommand.startsWith("begin some music") ||
            voiceCommand.startsWith("play a song") ||
            voiceCommand.startsWith("start a song") ||
            voiceCommand.startsWith("begin a song") ||
            voiceCommand.startsWith("play songs") ||
            voiceCommand.startsWith("start songs") ||
            voiceCommand.startsWith("begin songs") ||
            voiceCommand.startsWith("play my music") ||
            voiceCommand.startsWith("start my music") ||
            voiceCommand.startsWith("begin my music") ||
            voiceCommand.startsWith("play playlist") ||
            voiceCommand.startsWith("start playlist") ||
            voiceCommand.startsWith("begin playlist") ||
            voiceCommand.startsWith("play some tunes") ||
            voiceCommand.startsWith("start some tunes") ||
            voiceCommand.startsWith("begin some tunes") ||
            voiceCommand.startsWith("play a tune") ||
            voiceCommand.startsWith("start a tune") ||
            voiceCommand.startsWith("begin a tune") ||
            voiceCommand.startsWith("play track") ||
            voiceCommand.startsWith("start track") ||
            voiceCommand.startsWith("begin track") ||
            voiceCommand.startsWith("play audio") ||
            voiceCommand.startsWith("start audio") ||
            voiceCommand.startsWith("begin audio")||
            voiceCommand.startsWith("play")) {
            return 0;
        }
        
        // Tell a joke cases
        else if (voiceCommand.startsWith("tell me a joke") ||
                 voiceCommand.startsWith("say a joke") ||
                 voiceCommand.startsWith("give me a joke") ||
                 voiceCommand.startsWith("tell a joke") ||
                 voiceCommand.startsWith("make me laugh") ||
                 voiceCommand.startsWith("do you know a joke") ||
                 voiceCommand.startsWith("do you have a joke") ||
                 voiceCommand.startsWith("say something funny") ||
                 voiceCommand.startsWith("make me chuckle") ||
                 voiceCommand.startsWith("crack a joke") ||
                 voiceCommand.startsWith("say a funny thing") ||
                 voiceCommand.startsWith("can you tell a joke") ||
                 voiceCommand.startsWith("could you tell a joke") ||
                 voiceCommand.startsWith("give me something funny") ||
                 voiceCommand.startsWith("entertain me with a joke") ||
                 voiceCommand.startsWith("amuse me with a joke") ||
                 voiceCommand.startsWith("tell a funny story") ||
                 voiceCommand.startsWith("make a joke") ||
                 voiceCommand.startsWith("do a joke") ||
                 voiceCommand.startsWith("share a joke") ||
                 voiceCommand.startsWith("got any jokes") ||
                 voiceCommand.startsWith("know any jokes") ||
                 voiceCommand.startsWith("tell something funny") ||
                 voiceCommand.startsWith("tell me something funny") ||
                 voiceCommand.startsWith("give me a funny joke") ||
                 voiceCommand.startsWith("tell me a funny joke") ||
                 voiceCommand.startsWith("can you say a joke") ||
                 voiceCommand.startsWith("could you say a joke")||
                 voiceCommand.startsWith("joke")) {
            return 1;
        }
        
        // Weather forecast cases
        else if (voiceCommand.startsWith("weather forecast") ||
                 voiceCommand.startsWith("what's the weather") ||
                 voiceCommand.startsWith("what is the weather") ||
                 voiceCommand.startsWith("how's the weather") ||
                 voiceCommand.startsWith("how is the weather") ||
                 voiceCommand.startsWith("tell me the weather") ||
                 voiceCommand.startsWith("give me the weather") ||
                 voiceCommand.startsWith("forecast for today") ||
                 voiceCommand.startsWith("today's weather") ||
                 voiceCommand.startsWith("weather today") ||
                 voiceCommand.startsWith("current weather") ||
                 voiceCommand.startsWith("weather update") ||
                 voiceCommand.startsWith("weather report") ||
                 voiceCommand.startsWith("what's the forecast") ||
                 voiceCommand.startsWith("what is the forecast") ||
                 voiceCommand.startsWith("how's the forecast") ||
                 voiceCommand.startsWith("how is the forecast") ||
                 voiceCommand.startsWith("tell me the forecast") ||
                 voiceCommand.startsWith("give me the forecast") ||
                 voiceCommand.startsWith("forecast for now") ||
                 voiceCommand.startsWith("weather right now") ||
                 voiceCommand.startsWith("current forecast") ||
                 voiceCommand.startsWith("today's forecast") ||
                 voiceCommand.startsWith("will it rain today") ||
                 voiceCommand.startsWith("is it going to rain") ||
                 voiceCommand.startsWith("will it snow today") ||
                 voiceCommand.startsWith("is it going to snow") ||
                 voiceCommand.startsWith("is it sunny") ||
                 voiceCommand.startsWith("is it cloudy")||
                 voiceCommand.startsWith("weather")||
                 voiceCommand.startsWith("forecast")) {
            return 2;
        }
        
        // Search cases
        else if (voiceCommand.startsWith("search for") ||
                 voiceCommand.startsWith("find") ||
                 voiceCommand.startsWith("look up") ||
                 voiceCommand.startsWith("google") ||
                 voiceCommand.startsWith("search the web for") ||
                 voiceCommand.startsWith("search online for") ||
                 voiceCommand.startsWith("find information on") ||
                 voiceCommand.startsWith("look up information on") ||
                 voiceCommand.startsWith("search about") ||
                 voiceCommand.startsWith("find out about") ||
                 voiceCommand.startsWith("google search for") ||
                 voiceCommand.startsWith("web search for") ||
                 voiceCommand.startsWith("search internet for") ||
                 voiceCommand.startsWith("look online for") ||
                 voiceCommand.startsWith("online search for") ||
                 voiceCommand.startsWith("search this for me") ||
                 voiceCommand.startsWith("look this up for me") ||
                 voiceCommand.startsWith("find this for me") ||
                 voiceCommand.startsWith("google this for me") ||
                 voiceCommand.startsWith("search the internet for") ||
                 voiceCommand.startsWith("do a search for") ||
                 voiceCommand.startsWith("do an online search for") ||
                 voiceCommand.startsWith("find me information on") ||
                 voiceCommand.startsWith("get information on") ||
                 voiceCommand.startsWith("get me information on") ||
                 voiceCommand.startsWith("look for information on") ||
                 voiceCommand.startsWith("get details on") ||
                 voiceCommand.startsWith("look for details on") ||
                 voiceCommand.startsWith("find details on") ||
                 voiceCommand.startsWith("search details on")||
                 voiceCommand.startsWith("search")) {
            return 3;
        }
        
        // Translate cases
        else if (voiceCommand.startsWith("translate") ||
                 voiceCommand.startsWith("translate this") ||
                 voiceCommand.startsWith("can you translate") ||
                 voiceCommand.startsWith("could you translate") ||
                 voiceCommand.startsWith("help me translate") ||
                 voiceCommand.startsWith("translation for") ||
                 voiceCommand.startsWith("what's the translation for") ||
                 voiceCommand.startsWith("what is the translation for") ||
                 voiceCommand.startsWith("translate to") ||
                 voiceCommand.startsWith("translate into") ||
                 voiceCommand.startsWith("how to say") ||
                 voiceCommand.startsWith("how do you say") ||
                 voiceCommand.startsWith("how can I say") ||
                 voiceCommand.startsWith("what's the word for") ||
                 voiceCommand.startsWith("what is the word for") ||
                 voiceCommand.startsWith("give me translation for") ||
                 voiceCommand.startsWith("give me the translation for") ||
                 voiceCommand.startsWith("help me with translation") ||
                 voiceCommand.startsWith("what's the meaning of") ||
                 voiceCommand.startsWith("what is the meaning of") ||
                 voiceCommand.startsWith("meaning of the word") ||
                 voiceCommand.startsWith("translate word") ||
                 voiceCommand.startsWith("translate sentence") ||
                 voiceCommand.startsWith("translate phrase") ||
                 voiceCommand.startsWith("translate paragraph") ||
                 voiceCommand.startsWith("how do you translate") ||
                 voiceCommand.startsWith("how can I translate") ||
                 voiceCommand.startsWith("can you help me translate") ||
                 voiceCommand.startsWith("could you help me translate")) {
            return 4;
        }
        
        // Hey Abdullah cases
        else if (voiceCommand.startsWith("hey abdullah") ||
                 voiceCommand.startsWith("hello abdullah") ||
                 voiceCommand.startsWith("hi abdullah") ||
                 voiceCommand.startsWith("abdullah") ||
                 voiceCommand.startsWith("greetings abdullah") ||
                 voiceCommand.startsWith("what's up abdullah") ||
                 voiceCommand.startsWith("what is up abdullah") ||
                 voiceCommand.startsWith("how are you abdullah") ||
                 voiceCommand.startsWith("good morning abdullah") ||
                 voiceCommand.startsWith("good afternoon abdullah") ||
                 voiceCommand.startsWith("good evening abdullah") ||
                 voiceCommand.startsWith("hey there abdullah") ||
                 voiceCommand.startsWith("hello there abdullah") ||
                 voiceCommand.startsWith("hi there abdullah") ||
                 voiceCommand.startsWith("hey abdullah, how are you") ||
                 voiceCommand.startsWith("hello abdullah, how are you") ||
                 voiceCommand.startsWith("hi abdullah, how are you") ||
                 voiceCommand.startsWith("hey abdullah, what's up") ||
                 voiceCommand.startsWith("hello abdullah, what's up") ||
                 voiceCommand.startsWith("hi abdullah, what's up") ||
                 voiceCommand.startsWith("hey abdullah, how's it going") ||
                 voiceCommand.startsWith("hello abdullah, how's it going") ||
                 voiceCommand.startsWith("hi abdullah, how's it going") ||
                 voiceCommand.startsWith("hey abdullah, how have you been") ||
                 voiceCommand.startsWith("hello abdullah, how have you been") ||
                 voiceCommand.startsWith("hi abdullah, how have you been") ||
                 voiceCommand.startsWith("good day abdullah") ||
                 voiceCommand.startsWith("what's new abdullah") ||
                 voiceCommand.startsWith("what's happening abdullah") ||
                 voiceCommand.startsWith("howdy abdullah") ||
                 voiceCommand.startsWith("yo abdullah")||
                 voiceCommand.startsWith("hi")||
                 voiceCommand.startsWith("hello")||
                 voiceCommand.startsWith("hey")) {
            return 5;
        }
        
        // Bye Abdullah cases
        else if (voiceCommand.startsWith("bye abdullah") ||
                 voiceCommand.startsWith("goodbye abdullah") ||
                 voiceCommand.startsWith("see you abdullah") ||
                 voiceCommand.startsWith("later abdullah") ||
                 voiceCommand.startsWith("talk to you later abdullah") ||
                 voiceCommand.startsWith("see you later abdullah") ||
                 voiceCommand.startsWith("farewell abdullah") ||
                 voiceCommand.startsWith("good night abdullah") ||
                 voiceCommand.startsWith("bye for now abdullah") ||
                 voiceCommand.startsWith("catch you later abdullah") ||
                 voiceCommand.startsWith("see you around abdullah") ||
                 voiceCommand.startsWith("peace out abdullah") ||
                 voiceCommand.startsWith("take care abdullah") ||
                 voiceCommand.startsWith("take it easy abdullah") ||
                 voiceCommand.startsWith("have a good day abdullah") ||
                 voiceCommand.startsWith("have a nice day abdullah") ||
                 voiceCommand.startsWith("have a good one abdullah") ||
                 voiceCommand.startsWith("until next time abdullah") ||
                 voiceCommand.startsWith("bye bye abdullah") ||
                 voiceCommand.startsWith("so long abdullah") ||
                 voiceCommand.startsWith("see ya abdullah") ||
                 voiceCommand.startsWith("later on abdullah") ||
                 voiceCommand.startsWith("i'm out abdullah") ||
                 voiceCommand.startsWith("i gotta go abdullah") ||
                 voiceCommand.startsWith("i have to go abdullah") ||
                 voiceCommand.startsWith("i'm leaving abdullah") ||
                 voiceCommand.startsWith("i'm off abdullah") ||
                 voiceCommand.startsWith("i'm out of here abdullah") ||
                 voiceCommand.startsWith("i'm signing off abdullah") ||
                 voiceCommand.startsWith("i'll talk to you later abdullah") ||
                 voiceCommand.startsWith("i'll see you later abdullah")||
                 voiceCommand.startsWith("goodbye")||
                 voiceCommand.startsWith("bye")) {
            return 6;
        }
        
        // Open app cases
        else if (voiceCommand.startsWith("open app") ||
                 voiceCommand.startsWith("launch app") ||
                 voiceCommand.startsWith("start app") ||
                 voiceCommand.startsWith("open application") ||
                 voiceCommand.startsWith("launch application") ||
                 voiceCommand.startsWith("start application") ||
                 voiceCommand.startsWith("open the app") ||
                 voiceCommand.startsWith("launch the app") ||
                 voiceCommand.startsWith("start the app") ||
                 voiceCommand.startsWith("open the application") ||
                 voiceCommand.startsWith("launch the application") ||
                 voiceCommand.startsWith("start the application") ||
                 voiceCommand.startsWith("open a program") ||
                 voiceCommand.startsWith("launch a program") ||
                 voiceCommand.startsWith("start a program") ||
                 voiceCommand.startsWith("open a software") ||
                 voiceCommand.startsWith("launch a software") ||
                 voiceCommand.startsWith("start a software") ||
                 voiceCommand.startsWith("open my app") ||
                 voiceCommand.startsWith("launch my app") ||
                 voiceCommand.startsWith("start my app") ||
                 voiceCommand.startsWith("open my application") ||
                 voiceCommand.startsWith("launch my application") ||
                 voiceCommand.startsWith("start my application") ||
                 voiceCommand.startsWith("open my program") ||
                 voiceCommand.startsWith("launch my program") ||
                 voiceCommand.startsWith("start my program") ||
                 voiceCommand.startsWith("open this app") ||
                 voiceCommand.startsWith("launch this app") ||
                 voiceCommand.startsWith("start this app") ||
                 voiceCommand.startsWith("open this application") ||
                 voiceCommand.startsWith("launch this application") ||
                 voiceCommand.startsWith("start this application")||
                 voiceCommand.startsWith("open")) {
            return 7;
        }
        
        // Close app cases
        else if (voiceCommand.startsWith("close app") ||
                 voiceCommand.startsWith("shut app") ||
                 voiceCommand.startsWith("exit app") ||
                 voiceCommand.startsWith("terminate app") ||
                 voiceCommand.startsWith("close application") ||
                 voiceCommand.startsWith("shut application") ||
                 voiceCommand.startsWith("exit application") ||
                 voiceCommand.startsWith("terminate application") ||
                 voiceCommand.startsWith("close the app") ||
                 voiceCommand.startsWith("shut the app") ||
                 voiceCommand.startsWith("exit the app") ||
                 voiceCommand.startsWith("terminate the app") ||
                 voiceCommand.startsWith("close the application") ||
                 voiceCommand.startsWith("shut the application") ||
                 voiceCommand.startsWith("exit the application") ||
                 voiceCommand.startsWith("terminate the application") ||
                 voiceCommand.startsWith("close a program") ||
                 voiceCommand.startsWith("shut a program") ||
                 voiceCommand.startsWith("exit a program") ||
                 voiceCommand.startsWith("terminate a program") ||
                 voiceCommand.startsWith("close a software") ||
                 voiceCommand.startsWith("shut a software") ||
                 voiceCommand.startsWith("exit a software") ||
                 voiceCommand.startsWith("terminate a software") ||
                 voiceCommand.startsWith("close my app") ||
                 voiceCommand.startsWith("shut my app") ||
                 voiceCommand.startsWith("exit my app") ||
                 voiceCommand.startsWith("terminate my app") ||
                 voiceCommand.startsWith("close my application") ||
                 voiceCommand.startsWith("shut my application") ||
                 voiceCommand.startsWith("exit my application") ||
                 voiceCommand.startsWith("terminate my application")||
                 voiceCommand.startsWith("close")||
                 voiceCommand.startsWith("terminate")) {
            return 8;
        }// Date cases
       else if (voiceCommand.startsWith("date") ||
voiceCommand.startsWith("what's the date") ||
voiceCommand.startsWith("today's date") ||
voiceCommand.startsWith("current date") ||
voiceCommand.startsWith("give me the date") ||
voiceCommand.startsWith("tell me the date") ||
voiceCommand.startsWith("what is the date today") ||
voiceCommand.startsWith("date today") ||
voiceCommand.startsWith("what day is it") ||
voiceCommand.startsWith("what's today's date") ||
voiceCommand.startsWith("tell me today's date") ||
voiceCommand.startsWith("day's date") ||
voiceCommand.startsWith("current day") ||
voiceCommand.startsWith("date for today") ||
voiceCommand.startsWith("get me the date") ||
voiceCommand.startsWith("tell me the current date") ||
voiceCommand.startsWith("give me today's date") ||
voiceCommand.startsWith("current day's date") ||
voiceCommand.startsWith("what's the date today")) {
return 9;
}

// Time cases
else if (voiceCommand.startsWith("time") ||
voiceCommand.startsWith("what's the time") ||
voiceCommand.startsWith("current time") ||
voiceCommand.startsWith("give me the time") ||
voiceCommand.startsWith("tell me the time") ||
voiceCommand.startsWith("what time is it") ||
voiceCommand.startsWith("time now") ||
voiceCommand.startsWith("what is the time now") ||
voiceCommand.startsWith("current time") ||
voiceCommand.startsWith("time of day") ||
voiceCommand.startsWith("what's the current time") ||
voiceCommand.startsWith("current clock time") ||
voiceCommand.startsWith("give me the current time") ||
voiceCommand.startsWith("tell me the current time") ||
voiceCommand.startsWith("current time please") ||
voiceCommand.startsWith("get me the time now") ||
voiceCommand.startsWith("time of day now") ||
voiceCommand.startsWith("what time is it now") ||
voiceCommand.startsWith("current time for me")) {
return 10;
}

            else if(
                voiceCommand.startsWith("thanks sir jaudat mamoon")||
                voiceCommand.startsWith(" thanks sir")||
                voiceCommand.startsWith("thanks sir jaudat")||
                voiceCommand.startsWith("thanks sir jaudat mamoon")||
                voiceCommand.startsWith("thanks jaudat mamoon")||
                voiceCommand.startsWith(" thanks jaudat")||
                voiceCommand.startsWith(" thanks mamoon")||
                voiceCommand.startsWith("thank you sir")||
                voiceCommand.startsWith("thanks")||
                voiceCommand.startsWith("thank sir")||
                voiceCommand.startsWith("thank")||
                voiceCommand.startsWith("jaudat")||
                voiceCommand.startsWith("mamoon")){
                    return 11;
                }
            
        
    
        return -1;
    }
    
    
    //  Starts the speech recognition process.
    
    public void startRecognizing() {
        lsr.startRecognition();
        isRecognizing = true;
        playMP3("greetings.mp3");
    }

    
     //Stops the speech recognition process.
    
    public void stopRecognizing() {
        if (isRecognizing) {
            lsr.stopRecognition();
            isRecognizing = false;
        }
        playMP3("farewell.mp3");
    }

    public @NotNull String getSubstringAfter(@NotNull String input, @NotNull String searchTerm) {
        if (input.length() <= searchTerm.length()) return input;
        return input
                .substring(input.indexOf(searchTerm) + searchTerm.length())
                .trim()
                .replaceAll("\\s", "%20");
    }

    public void playMP3(String filename) {
        try (FileInputStream in = new FileInputStream(String.format("%s/src/main/java/com/nust/resources/%s", System.getProperty("user.dir"), filename))) {
            new AdvancedPlayer(in).play();
        } catch (IOException | JavaLayerException e) {
            throw new RuntimeException(e);
        }
    }
}
