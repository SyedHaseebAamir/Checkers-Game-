public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
     private void openGameRulesFrame() {
        GameRulesFrame gameRulesFrame = new GameRulesFrame();
        gameRulesFrame.setVisible(true);
        this.setVisible(false);
        
    }
     
      private void howtoplay() {
        howtoplay htp = new howtoplay();
        htp.setVisible(true);
        this.setVisible(false);
        
    }
     
    // </editor-fold>

      
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btntwoplayer = new javax.swing.JButton();
        btnPracticeSolo = new javax.swing.JButton();
        btngamerule = new javax.swing.JButton();
        btnhtp = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setIconImages(null);

        jPanel2.setBackground(new java.awt.Color(8, 36, 64));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Parchment", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Checker Game");

        btntwoplayer.setBackground(new java.awt.Color(8, 36, 64));
        btntwoplayer.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        btntwoplayer.setForeground(new java.awt.Color(255, 255, 255));
        btntwoplayer.setText("Play with Two Player");
        btntwoplayer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntwoplayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntwoplayerActionPerformed(evt);
            }
        });

        btnPracticeSolo.setBackground(new java.awt.Color(8, 36, 64));
        btnPracticeSolo.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        btnPracticeSolo.setForeground(new java.awt.Color(255, 255, 255));
        btnPracticeSolo.setText("Practice Solo");
        btnPracticeSolo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPracticeSolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPracticeSoloActionPerformed(evt);
            }
        });

        btngamerule.setBackground(new java.awt.Color(8, 36, 64));
        btngamerule.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        btngamerule.setForeground(new java.awt.Color(255, 255, 255));
        btngamerule.setText("Game Rules");
        btngamerule.setToolTipText("");
        btngamerule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngamerule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngameruleActionPerformed(evt);
            }
        });

        btnhtp.setBackground(new java.awt.Color(8, 36, 64));
        btnhtp.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        btnhtp.setForeground(new java.awt.Color(255, 255, 255));
        btnhtp.setText("How to Play");
        btnhtp.setToolTipText("");
        btnhtp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhtpActionPerformed(evt);
            }
        });

        btnQuit.setBackground(new java.awt.Color(8, 36, 64));
        btnQuit.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        btnQuit.setForeground(new java.awt.Color(255, 255, 255));
        btnQuit.setText("Quit");
        btnQuit.setToolTipText("");
        btnQuit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        Wallpaper.setBackground(new java.awt.Color(51, 51, 51));
        Wallpaper.setFont(new java.awt.Font("SF Pro Display", 0, 24)); // NOI18N
        Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Wallpaper.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btntwoplayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPracticeSolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btngamerule, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnhtp, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Wallpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btntwoplayer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPracticeSolo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btngamerule, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnhtp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addComponent(Wallpaper, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btngameruleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngameruleActionPerformed
        openGameRulesFrame();
    }//GEN-LAST:event_btngameruleActionPerformed

    private void btnhtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhtpActionPerformed
        howtoplay();
    }//GEN-LAST:event_btnhtpActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btntwoplayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntwoplayerActionPerformed
         GameBoard gameBoard = new GameBoard(this, false);
        gameBoard.display();
        this.setVisible(false);
    }//GEN-LAST:event_btntwoplayerActionPerformed

    private void btnPracticeSoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPracticeSoloActionPerformed
     GameBoard gameBoard = new GameBoard(this, true);
        gameBoard.display();
        this.setVisible(false);
    }//GEN-LAST:event_btnPracticeSoloActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JButton btnPracticeSolo;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btngamerule;
    private javax.swing.JButton btnhtp;
    private javax.swing.JButton btntwoplayer;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
