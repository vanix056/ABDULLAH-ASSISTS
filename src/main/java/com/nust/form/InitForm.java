package com.nust.form;

import com.nust.ai.*;
import static com.nust.apputils.AppUtils.*;
import com.nust.swing.scrollbar.ScrollBarCustom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException; 
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InitForm extends javax.swing.JPanel {

    private VoiceAssistant va;
    private MCNPLNN MCModel;
    private GoogleTranslator googleTranslator;
    private OWMForecaster owmForecaster;
    private final Object lockVoiceCommand = new Object();
    private final Object lockSynthesizer = new Object();
    private final Object lockConnection = new Object();
    private final Thread voiceCommandThread;
    private final Thread synthesizerThread;
    private final Supplier<Boolean> isNetUnavailable = () -> {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("google.com", 80), INTERNET_TIMEOUT);
            return false;
        } catch (IOException e) {
            return true;
        }
    };
    private final Thread retryConnectionThread = new Thread(() -> {
        try {
            synchronized (lockConnection) {
                while (true) {
                    lockConnection.wait();
                    while (isNetUnavailable.get()) {
                        signalSearch(NO_INTERNET_CONNECTION_SEARCH, false);
                        lockConnection.wait(INTERNET_TIMEOUT);
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });
    private boolean synthesizerIsSpeaking = false;

    public InitForm() {
        initComponents();
        setOpaque(false);
        search.setText(SEND);
        retryConnectionThread.start();
        voiceCommandThread = new Thread(() -> {
            synchronized (lockConnection) {
                lockConnection.notifyAll();
            }
            try {
                synchronized (lockConnection) {
                    while (isNetUnavailable.get()) {
                        lockConnection.wait(INTERNET_TIMEOUT);
                    }
                }
                owmForecaster = new OWMForecaster("bcebc1ab15b0bf", "5a38a0988a6a37301a3b4963d6106fa2");
                googleTranslator = new GoogleTranslator("AKfycbxiVh8Fxy0opG1ygpNdNBaD9t_HC0nqk5IElpLLpgPMdpks_7E8hcH4N74065VJFohn");
                va = new VoiceAssistant("dict.dic", "language-model.lm");
                va.startRecognizing();
                jLabel3.setEnabled(true);
                MCModel = new MCNPLNN("mctext.txt", 4);
                synchronized (lockVoiceCommand) {
                    while (true) {
                        lockVoiceCommand.wait();
                        jLabel3.setEnabled(false);
                        handleCommand(va.getCommand());
                        jLabel3.setEnabled(true);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        voiceCommandThread.start();
        synthesizerThread = new Thread(() -> {
            synchronized (lockSynthesizer) {
                try (Synthesizer synthesizer = Synthesizer.getInstance()) {
                    while (true) {
                        lockSynthesizer.wait();
                        synthesizerIsSpeaking = true;
                        synthesizer.speak(abdullahAnswer.getText());
                        synthesizerIsSpeaking = false;
                        if (search.getText().equals(SYNTHESIZER_IS_SPEAKING)) {
                            signalSearch(SEND, true);
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        synthesizerThread.start();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        abdullahAnswer = new javax.swing.JTextArea();

        setForeground(new java.awt.Color(0, 102, 102));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1024, 680));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Abdullah's answers will appear here:");
        jLabel2.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel2.setRequestFocusEnabled(false);

        search.setBackground(new java.awt.Color(0, 102, 102));
        search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Send...");
        search.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        search.setCaretColor(new java.awt.Color(255, 102, 0));
        search.setDisabledTextColor(new java.awt.Color(0, 102, 102));
        search.setEnabled(false);
        search.setMargin(getInsets());
        search.setMaximumSize(new java.awt.Dimension(2147483647, 45));
        search.setMinimumSize(new java.awt.Dimension(73, 45));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("To ask a question insert text into \"Search\" field or ask it by voice button =)");
        jLabel1.setMaximumSize(new java.awt.Dimension(32767, 16));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/main/java/com/nust/resources/microphone.png"));
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setDisabledIcon(new ImageIcon(System.getProperty("user.dir") + "/src/main/java/com/nust/resources/microphone_active.png"));
        jLabel3.setEnabled(false);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/main/java/com/nust/resources/search.png"));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Welcome to Abdullah Assists!");
        jLabel5.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel5.setRequestFocusEnabled(false);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(44, 7));
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom(new Color(130, 130, 130, 100)));

        abdullahAnswer.setEditable(false);
        abdullahAnswer.setBackground(new java.awt.Color(25, 25, 25));
        abdullahAnswer.setColumns(20);
        abdullahAnswer.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        abdullahAnswer.setForeground(new java.awt.Color(255, 255, 255));
        abdullahAnswer.setLineWrap(true);
        abdullahAnswer.setRows(50);
        abdullahAnswer.setText("A very witty, self-sufficient and self-explanatory response from Abdullah Assists...");
        abdullahAnswer.setWrapStyleWord(true);
        abdullahAnswer.setMaximumSize(new java.awt.Dimension(32767, 32767));
        abdullahAnswer.setMinimumSize(new java.awt.Dimension(1, 1));
        jScrollPane2.setViewportView(abdullahAnswer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        System.out.println(evt);
        synchronized (lockConnection) {
            lockConnection.notifyAll();
        }
        if (synthesizerIsSpeaking) {
            signalSearch(SYNTHESIZER_IS_SPEAKING, false);
        } else {
            signalSearch(SEARCH_WHEN_CLICKED, true);
        }
    }//GEN-LAST:event_searchMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        System.out.println(evt);
        search.setEnabled(false);
    }//GEN-LAST:event_formMouseClicked

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        System.out.println(evt);
        // Optimised key pressing method - check for network only when <ENTER> is pressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            synchronized (lockConnection) {
                lockConnection.notifyAll();
            }
            if (synthesizerIsSpeaking) {
                signalSearch(SYNTHESIZER_IS_SPEAKING, false);
            } else {
                handleCommand(search.getText());
            }
        }
    }//GEN-LAST:event_searchKeyPressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.out.println(evt);
        synchronized (lockConnection) {
            lockConnection.notifyAll();
        }
        if (synthesizerIsSpeaking) {
            signalSearch(SYNTHESIZER_IS_SPEAKING, false);
        } else {
            handleCommand(search.getText());
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.out.println(evt);
        synchronized (lockConnection) {
            lockConnection.notifyAll();
        }
        if (synthesizerIsSpeaking) {
            signalSearch(SYNTHESIZER_IS_SPEAKING, false);
        } else {
            synchronized (lockVoiceCommand) {
                lockVoiceCommand.notifyAll();
            }
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void signalSearch(String text, boolean isEnabled) {
        search.setEnabled(isEnabled);
        search.setText(text);
        search.setDisabledTextColor(isEnabled ? SEARCH_ENABLED_COLOR : SEARCH_DISABLED_COLOR);
    }

    private void handleCommand(String searchQuery) {
        search.setText(searchQuery);
        switch (va.getCode(searchQuery)) {
            case 0 -> handlePlayMusicCommand(searchQuery);
            case 1 -> handleTellJokeCommand();
            case 2 -> handleWeatherForecastCommand();
            case 3 -> handleSearchCommand(searchQuery);
            case 4 -> handleTranslationCommand(searchQuery);
            case 5 -> handleGreetingsCommand();
            case 6 -> handleExitCommand();
            case 7 -> handleOpenAppCommand(searchQuery);
            case 8 -> handleCloseAPPCommand(searchQuery);
            case 9 -> handleDateCommand();
            case 10 -> handleTimeCommand();
            case 11 -> thankYouSir();
            
            default -> handleUnknownCommand(searchQuery);
        }
        synchronized (lockSynthesizer) {
            lockSynthesizer.notifyAll();
        }
    }
    public void thankYouSir(){
        abdullahAnswer.setText("Dear Sir Jaudat ,\n" + //
                        "\n" + //
                        "I would like to extend my heartfelt gratitude for your exceptional guidance and support throughout the last two semesters of our FOCP and OOP course. Your insightful teaching and dedication have not only made learning programming enjoyable but also equipped me with the skills to apply my knowledge in real-world scenarios. I truly appreciate the effort you put into making complex concepts accessible and engaging. I sincerely hope to have the opportunity to work under your supervision for my final year project, as I am confident that your mentorship will continue to inspire and drive my academic and professional growth.\n" + //
                        "\n" + //
                        "Sincerely,\n" + //
                        "Muhammad Abdullah Waqar");
    }
    public void handleDateCommand() {
    LocalDateTime currentDate = LocalDateTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = currentDate.format(dateFormatter);
    abdullahAnswer.setText("Today's date is: " + formattedDate);
}

public void handleTimeCommand() {
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedTime = currentTime.format(timeFormatter);
    abdullahAnswer.setText("Current time is: " + formattedTime);
}

    public void handlePlayMusicCommand(String command) {
        String songName = va.getSubstringAfter(command, "play music");
        if (songName == null || songName.trim().isEmpty()) {
            abdullahAnswer.setText("Please specify a song name to play.");
            return;
        }
    
        // Decode URL-encoded characters
        songName = URLDecoder.decode(songName, StandardCharsets.UTF_8);
    
        // Display the song name as it is for the synthesizer to speak
        abdullahAnswer.setText("Playing " + songName + " on YouTube Music, enjoy it ;)");
    
        // URL encode the song name for the search query
        String encodedSongName = URLEncoder.encode(songName.trim(), StandardCharsets.UTF_8);
   
        // Construct the search URL
        String searchUrl = "https://music.youtube.com/search?q=" + encodedSongName;
   
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            // Open the search URL in Safari
            cmdExec("open -a Safari " + searchUrl);
        } else if (os.contains("win")) {
            // Open the search URL in Chrome
            cmdExec("start chrome " + searchUrl);
        } else {
            abdullahAnswer.setText("Unsupported operating system for opening YouTube Music.");
        }
    }
    
    
    
    
    

    public void handleTellJokeCommand() {
        abdullahAnswer.setText(MCModel.getSentence(5, "okay heres the joke"));
    }

    public void handleWeatherForecastCommand() {
        abdullahAnswer.setText(owmForecaster.forecast());
    }
    public void handleSearchCommand(String searchQuery) {
        abdullahAnswer.setText("Running the browser to search for this information...");
        String searchUrl = "https://www.google.com/search?q=" + va.getSubstringAfter(searchQuery, "search for");
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            cmdExec("open -a Safari " + searchUrl);
        } else if (os.contains("win")) {
            cmdExec("start chrome " + searchUrl);
        } else {
            abdullahAnswer.setText("Unsupported operating system for browser redirection.");
        }
    }
    
public void handleOpenAppCommand(String searchQuery) {
        // Extract the app name from the command
        String appName = va.getSubstringAfter(searchQuery, "open app");

        // Open the specified app
        openApp(appName.trim());
    }

    @SuppressWarnings("deprecation")
    
    public void openApp(String appName) {
        try {
            String command;
            if (appName.contains("%20")) {
                // Application name has multiple words
                // Escape spaces with backslashes
                appName = appName.replace("%20", "\\ ");
                command = "open -a " + appName;
                appName = appName.replace("\\", " ");
                abdullahAnswer.setText("Opening App " + appName);
            } else {
                // Application name has only one word
                command = "open -a \"" + appName + "\"";
                abdullahAnswer.setText("Opening App " + appName);
            }
    
            // Print the command for debugging
            //System.out.println("Executing command: " + command);
    
            // Execute the command
            Process process = Runtime.getRuntime().exec(new String[] { "bash", "-c", command });
            process.waitFor();
    
            // Check the exit value or error stream to determine if the app was opened successfully
            if (process.exitValue() != 0) {
                // Read error stream
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                StringBuilder errorMessage = new StringBuilder();
                String line;
                while ((line = errorReader.readLine()) != null) {
                    errorMessage.append(line).append("\n");
                }
    
                // Display error message if the app is not found
                if (errorMessage.toString().contains("Unable to find application")) {
                    abdullahAnswer.setText("App "+appName+ " not found in your macbook");
                } else {
                    abdullahAnswer.setText("Failed to open " + appName);
                }
            }
    
        } catch (IOException | InterruptedException e) {
            abdullahAnswer.setText("Failed to open " + appName);
            e.printStackTrace();
        }
    }
     

    public void handleCloseAPPCommand(String searchQuery){
        String appName1 = va.getSubstringAfter(searchQuery,"close app");
        closeApp(appName1.trim());
    }
    @SuppressWarnings("deprecation")
    
public void closeApp(String appName) {
    try {
        if (appName.contains("%20")) {
            // Application name has multiple words
            // Decode URL encoded spaces
            appName = appName.replace("%20", " ");
        }
        
        // Capitalize the first letter of each word in the application name
        appName = capitalizeEachWord(appName);

        // Check if the application is running using AppleScript
        String checkCommand = "osascript -e 'tell application \"System Events\" to (name of processes) contains \"" + appName + "\"'";
        
        // Execute the check command
        Process checkProcess = Runtime.getRuntime().exec(new String[] { "bash", "-c", checkCommand });
        BufferedReader checkReader = new BufferedReader(new InputStreamReader(checkProcess.getInputStream()));
        String checkResult = checkReader.readLine();

        if ("false".equalsIgnoreCase(checkResult)) {
            abdullahAnswer.setText("App " +appName +" is not running " );
            return;
        }

        // Construct the AppleScript command to quit the application
        String closeCommand = "osascript -e 'quit app \"" + appName + "\"'";
        
        // Display the action in the text area
        abdullahAnswer.setText("Closing App " + appName);
        
        // Execute the close command
        Process closeProcess = Runtime.getRuntime().exec(new String[] { "bash", "-c", closeCommand });
        closeProcess.waitFor();

        // Check if the application closed successfully
        if (closeProcess.exitValue() == 0) {
            abdullahAnswer.setText("Successfully closed " + appName);
        } else {
            abdullahAnswer.setText("Failed to close " + appName);
        }

    } catch (IOException | InterruptedException e) {
        abdullahAnswer.setText("Failed to close app: " + appName);
        e.printStackTrace();
    }
}

    private String capitalizeEachWord(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(word.substring(0, 1).toUpperCase())
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }
        return result.toString().trim();
    }
    
    public void handleTranslationCommand(String searchQuery) {
        try {
            // Extract the text to translate
            String textToTranslate = va.getSubstringAfter(searchQuery, "translate").trim();
            
            // Debug: Print the text to translate
            System.out.println("Text to translate: " + textToTranslate);
            
            // Check if the text to translate is empty
            if (textToTranslate.isEmpty()) {
                abdullahAnswer.setText("No text provided for translation.");
                return;
            }
            
            // Perform the translation
            String translatedText = googleTranslator.translate("en", "ur", textToTranslate);
            
            // Debug: Print the translated text
            System.out.println("Translated text: " + translatedText);
            
            // Set the translated text
            abdullahAnswer.setText(translatedText);
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
            abdullahAnswer.setText("An error occurred during translation.");
        }
    }
     

    public void handleGreetingsCommand() {
        abdullahAnswer.setText("Hello there,Welcome to Abdullah Assists if you are not sure what to do click manual button on the left ;)");
    }
    public void handleExitCommand() {
        abdullahAnswer.setText("Thank you for using Abdullah Assists!");
        SwingUtilities.invokeLater(() -> {
            try {
                // Wait for a short period before exiting
                Thread.sleep(2000); // 2000 milliseconds = 2 seconds
                retryConnectionThread.interrupt();
                voiceCommandThread.interrupt();
                synthesizerThread.interrupt();
                va.stopRecognizing();
                System.exit(0);
            } catch (InterruptedException e) {
                // Handle interruption exception
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });
    }
    

    public void handleUnknownCommand(String searchQuery) {
        abdullahAnswer.setText(String.format("I don't understand you: \"%s\" ;(", searchQuery)+"Can you rephrase again or you can also type with keyboard.");
        System.err.printf("Command not found: %s...%n", searchQuery);
        search.setEnabled(false);
        va.playMP3("farewell.mp3");
    }

    
     public void cmdExec(String command) {
    try {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            Runtime.getRuntime().exec(new String[]{"cmd", "/c", command});
        } else if (os.contains("mac")) {
            Runtime.getRuntime().exec(new String[]{"sh", "-c", command});
        } else {
            throw new UnsupportedOperationException("Unsupported operating system.");
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField search;
    private javax.swing.JTextArea abdullahAnswer;
    // End of variables declaration//GEN-END:variables
}
