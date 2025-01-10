// package com.nickmegistone.swing;

// import java.awt.AlphaComposite;
// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.event.MouseAdapter;

// public class PanelLoading extends javax.swing.JPanel {

//     public PanelLoading() {
//         initComponents();
//         setOpaque(false);
//         setFocusCycleRoot(true);
//         setVisible(false);
//         setFocusable(true);
//         addMouseListener(new MouseAdapter() {
//         });
//     }

//     private void initComponents() {

//         jLabel1 = new javax.swing.JLabel();

//         jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("icon/loading.gif"))); // NOI18N

//         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//         this.setLayout(layout);
//         layout.setHorizontalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
//         );
//         layout.setVerticalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
//         );
//     }
//     @Override
//     protected void paintComponent(Graphics grphcs) {
//         Graphics2D g2 = (Graphics2D) grphcs;
//         g2.setColor(new Color(255, 255, 255));
//         g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
//         g2.fillRect(0, 0, getWidth(), getHeight());
//         g2.setComposite(AlphaComposite.SrcOver);
//         super.paintComponent(grphcs);
//     }

//     private javax.swing.JLabel jLabel1;
// }