package com.nust.form;

import com.nust.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import javax.swing.*;

public class LicensesForm extends JPanel {

    public LicensesForm() {
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
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();

        setPreferredSize(new java.awt.Dimension(1024, 680));

        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBar(new ScrollBarCustom(new Color(130, 130, 130, 100)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("About");
        jLabel5.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel5.setRequestFocusEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Purpose:");
        jLabel2.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel2.setMinimumSize(new java.awt.Dimension(32, 32));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 64));
        jLabel2.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("<html>This app end semester project of Object-Oriented Programming for 2nd Semester using all the basic to advanced concepts of OOP with some embedded Neural Networks like Markov Chain Neural Netrwork.It also calls some APIs for weather and google translate whose details are given below: </a>.</html>");
        jLabel3.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jLabel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel3.setPreferredSize(new java.awt.Dimension(3303, 150));
        jLabel3.setRequestFocusEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("Tools:");
        jLabel4.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel4.setMinimumSize(new java.awt.Dimension(32, 32));
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 64));
        jLabel4.setRequestFocusEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // Reduced font size
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("<html>1) CMU SPHINX4 for speech recgonition<br>2) Markov Chain Neural Network for creation of jokes<br>3) Google Translate API for translation<br>4) Google for searching for user queries and playing music<br>5) Mary TTS for Text to Speech<br>6) Open Weather API for weather forecast of current location</html>");
        jLabel6.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jLabel6.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel6.setPreferredSize(new java.awt.Dimension(3303, 150));
        jLabel6.setRequestFocusEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setText("Sphinx4:");
        jLabel7.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel7.setMinimumSize(new java.awt.Dimension(32, 32));
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 64));
        jLabel7.setRequestFocusEnabled(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel8.setText("<html>\n" + //
                        "This project involves developing a speech recognition application using CMU Sphinx, a powerful open-source speech recognition toolkit. The application aims to convert spoken language into text accurately and efficiently. It includes features such as real-time speech-to-text conversion, customizable vocabulary and language models, and support for multiple languages. <a href=\"https://github.com/cmusphinx/sphinx4/blob/master/license.terms\">license.terms</a>.</html>");
        jLabel8.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jLabel8.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel8.setPreferredSize(new java.awt.Dimension(3303, 150));
        jLabel8.setRequestFocusEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel9.setText("OpenWeather");
        jLabel9.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel9.setMinimumSize(new java.awt.Dimension(32, 32));
        jLabel9.setPreferredSize(new java.awt.Dimension(120, 64));
        jLabel9.setRequestFocusEnabled(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 153));
        jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel10.setText("<html>This privacy notice outlines how OpenWeather Ltd handles your personal data, emphasizing its commitment to privacy protection. It details the types of data collected during API usage and website visits, highlighting a focus on essential information only. The notice covers the purposes for data usage, including contract performance and legitimate interests, while respecting users' rights.   For a comprehensive understanding, refer to the <a href=\"https://openweather.co.uk/privacy-policy\">full privacy policy</a>. Last updated on 18 July 2022.</html>");
        jLabel10.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jLabel10.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel10.setPreferredSize(new java.awt.Dimension(3303, 150));
        jLabel10.setRequestFocusEnabled(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 153));
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setText("IPinfo");
        jLabel11.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel11.setMinimumSize(new java.awt.Dimension(32, 32));
        jLabel11.setPreferredSize(new java.awt.Dimension(120, 64));
        jLabel11.setRequestFocusEnabled(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 153));
        jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel12.setText("<html>This Privacy Policy outlines the types of information collected by IDB LLC, effective from May 30, 2023. It covers user data such as Personal Contact, Billing, Diagnostic & Login, and Usage Information. Users in the EEA and UK have rights to access, modify, or delete their data. Contact IDB LLC for inquiries regarding data privacy at support@ipinfo.io. See the full privacy policy for detailed information on data handling practices. <a href=\"https://ipinfo.io/privacy-policy\">privacy policy</a>. </html>");
        jLabel12.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jLabel12.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel12.setPreferredSize(new java.awt.Dimension(3303, 150));
        jLabel12.setRequestFocusEnabled(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel13.setText("Google");
        jLabel13.setMaximumSize(new java.awt.Dimension(32767, 64));
        jLabel13.setMinimumSize(new java.awt.Dimension(32, 32));
        jLabel13.setPreferredSize(new java.awt.Dimension(120, 64));
        jLabel13.setRequestFocusEnabled(false);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 153));
        jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel14.setText("<html>This Privacy Policy describes how Google LLC and its affiliates collect, use, and share user data. Emphasizing transparency and user control, Google collects information to provide, maintain, and improve services. Users can manage their privacy settings through their Google Account, with options for data access, deletion, and portability. For detailed information on data practices and privacy controls, refer to the full privacy policy <a href=\"https://policies.google.com/privacy\">privacy policy</a>. </html>");
        jLabel14.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jLabel14.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel14.setPreferredSize(new java.awt.Dimension(3303, 150));
        jLabel14.setRequestFocusEnabled(false);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel7, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel8, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel9, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel10, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel11, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel12, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel13, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addComponent(jLabel14, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jScrollPane.setViewportView(jPanel1);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane)
        );
    }
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JScrollPane jScrollPane;

}
