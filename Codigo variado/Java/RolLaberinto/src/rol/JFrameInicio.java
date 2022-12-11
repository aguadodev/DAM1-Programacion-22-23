
package rol;

import javax.swing.JOptionPane;
import entidad.Monstruo;
import entidad.Personaje;



public class JFrameInicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipalJFrame
     */
    public JFrameInicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPersonaje = new javax.swing.JLabel();
        btnGenerarPersonaje = new javax.swing.JButton();
        btnGenerarMonstruos = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        lblMonstruos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Escapa del laberinto!!");

        lblPersonaje.setBackground(new java.awt.Color(204, 255, 204));
        lblPersonaje.setToolTipText("");
        lblPersonaje.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnGenerarPersonaje.setText("Generar Personaje");
        btnGenerarPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPersonajeActionPerformed(evt);
            }
        });

        btnGenerarMonstruos.setText("Generar Monstruos");
        btnGenerarMonstruos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarMonstruosActionPerformed(evt);
            }
        });

        btnJugar.setText("Jugar!!!");
        btnJugar.setEnabled(false);
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        lblMonstruos.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGenerarPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGenerarMonstruos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMonstruos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnJugar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarPersonaje)
                    .addComponent(btnGenerarMonstruos)
                    .addComponent(btnJugar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(lblMonstruos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPersonajeActionPerformed
        Juego.pj = new Personaje(Juego.nombreJugador);
        this.lblPersonaje.setText(Juego.pj.mostrarHTML());
        
        // Activa el botón jugar si es necesario
        if(Juego.pj != null && Juego.monstruos != null){
            this.btnJugar.setEnabled(true);
        }        
    }//GEN-LAST:event_btnGenerarPersonajeActionPerformed

    private void btnGenerarMonstruosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarMonstruosActionPerformed
        int num_monstruos = Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cuántos monstruos quieres crear?", 10));
        Juego.monstruos = new Monstruo[num_monstruos];
        String mostrarHTML = "<html>"
                + "MONSTRUOS<br>"
                + "=========<br>";
        for(int i = 0; i < num_monstruos; i++){
            Juego.monstruos[i] = Monstruo.generarAleatorio();                    
            mostrarHTML += Juego.monstruos[i] +  "<br>";
        }
        mostrarHTML += "<html>";
        this.lblMonstruos.setText(mostrarHTML);       

        // Activa el botón jugar si es necesario        
        if(Juego.pj != null && Juego.monstruos != null){
            this.btnJugar.setEnabled(true);
        }        
    }//GEN-LAST:event_btnGenerarMonstruosActionPerformed

    
    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        // Desactiva los botones de generar        
        this.btnGenerarPersonaje.setEnabled(false);
        this.btnGenerarMonstruos.setEnabled(false);
        
        this.btnJugar.setEnabled(false);
        this.dispose();
        Juego.mapa = new JFrameMapa();        
    }//GEN-LAST:event_btnJugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarMonstruos;
    private javax.swing.JButton btnGenerarPersonaje;
    private javax.swing.JButton btnJugar;
    private javax.swing.JLabel lblMonstruos;
    private javax.swing.JLabel lblPersonaje;
    // End of variables declaration//GEN-END:variables
}