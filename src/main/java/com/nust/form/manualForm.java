package com.nust.form;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.net.URI;

public class manualForm extends JPanel {

    public manualForm(int index) {
        initComponents();
        setOpaque(false);
    }

    private void initComponents() {
        // Used JEditorPane instead of JLabel to handle HTML content with links
        jEditorPane = new JEditorPane();
        jEditorPane.setContentType("text/html");
        jEditorPane.setText("<html><div style=\"text-align: left;\">" +
                "<h2><u>How to Use</u></h2>" +
                "<p>You can use this by giving input either by <br> using keyboard input in the textfield or by voice by clicking the voice button.</p><br>" +
                "<h2><u> Available Prompts</u></h2>" +
                "<ul style=\"list-style-type: none; padding: 0; margin: 0;\">" +
                "<li><h2><u>• hey abdullah:</u></h2><p>Greets the application</p></li>" +
                "<li><h2><u>• play music:</u></h2><p>Here 'play music' is the keyword, and you have to type the music name next to it.<br> It will redirect you to your requested music on YouTube Music.</p></li>" +
                "<li><h2><u>• search for:</u></h2><p>Here 'search for' is the keyword, and the word you write next to it is where this <br> application will redirect you using the default browser.</p></li>" +
                "<li><h2><u>• weather forecast:</u></h2><p>This uses OWM API and returns the weather of the current location.</p></li>" +
                "<li><h2><u>• translate:</u></h2><p>It translates into the Urdu language only.</p></li>" +
                "<li><h2><u>• joke:</u></h2><p>This uses Markov Chain Neural Network and returns a joke.</p></li>" +
                "<li><h2><u>• time:</u></h2><p>This returns the current time.</p></li>" +
                "<li><h2><u>• date:</u></h2><p>This returns the current date.</p></li>" +
                "<li><h2><u>• open app:</u></h2><p>'open app' is keyword and the name of the application you type next to it will open that<br> app</p></li>" +
                "<li><h2><u>• close app:</u></h2><p>'close app' is keyword and the name of the application you type next to it will close that<br> app</p></li>" +
                "<li><h2><u>• thanks sir jaudat:</u></h2><p> Appreciates Sir Jaudat's efforts in our academic as well as professional growth</p></li>" +
                "<li><h2><u>• bye abdullah:</u></h2><p>This terminates the application.</p></li>" +
                "<li><h2>For More Information about the combination of commands you can use visit <br>the following link: <a href='file:///Users/abdullahsmacbook/Documents/prompts/Prompts.pdf'>Download PDF</a></h2></li>" +
                "</ul></div></html>");
        jEditorPane.setEditable(false);
        jEditorPane.setOpaque(false);
        jEditorPane.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jEditorPane.setForeground(new java.awt.Color(0, 102, 153));
        jEditorPane.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        Desktop.getDesktop().browse(e.getURL().toURI());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JScrollPane jScrollPane = new JScrollPane(jEditorPane);
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );
    }

    private javax.swing.JEditorPane jEditorPane;
}
