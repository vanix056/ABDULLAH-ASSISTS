package com.nust.form;

import com.nust.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class CreatorsForm extends JPanel {

    public CreatorsForm() {
        initComponents();
        setOpaque(false);
    }

    
    private void initComponents() {

        jScrollPane = new JScrollPane();
        jPanel1 = new JPanel();
        jLabel5 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jEditorPane = new JEditorPane();

        setPreferredSize(new java.awt.Dimension(1024, 680));

        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane.setPreferredSize(new java.awt.Dimension(1027, 680));
        jScrollPane.setVerticalScrollBar(new ScrollBarCustom(new Color(130, 130, 130, 100)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); 
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Creator");
        jLabel5.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel5.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel5.setRequestFocusEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 33));
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("<html>Content creation, Engineering, Programming, Design</html>");
        jLabel2.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 64));
        jLabel2.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("<html>Muhammad Abdullah Waqar</html>");
        jLabel3.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jLabel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel3.setPreferredSize(new java.awt.Dimension(3303, 150));
        jLabel3.setRequestFocusEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); 
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("You can find my work on:");
        jLabel4.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel4.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 64));
        jLabel4.setRequestFocusEnabled(false);

        jEditorPane.setContentType("text/html");
        jEditorPane.setText("<html>LinkedIn: <a href=\"https://www.linkedin.com/in/abdullah-waqar-25353b2a5\">www.linkedin.com/in/abdullah-waqar-25353b2a5</a><br>GitHub: <a href=\"https://github.com/vanix056\">https://github.com/vanix056</a></html>");
        jEditorPane.setEditable(false);
        jEditorPane.setOpaque(true);
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

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1.setBackground(Color.WHITE);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jEditorPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jEditorPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap(348, Short.MAX_VALUE))
        );

        jScrollPane.setViewportView(jPanel1);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
    private JEditorPane jEditorPane;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JScrollPane jScrollPane;
    
}
