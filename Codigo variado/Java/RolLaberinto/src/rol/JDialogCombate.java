package rol;

import entidad.Monstruo;
import entidad.Personaje;
import javax.swing.JOptionPane;

public class JDialogCombate extends javax.swing.JDialog {

    //Almacena el monstruo con el que se combate
    Monstruo m;
    Personaje pj;
    int fila;
    int col;

    /**
     * Creates new form JFrameCombate
     */
    public JDialogCombate() {
        initComponents();
    }

    // Constructor en el que se envía un monstruo para el combate
    public JDialogCombate(int fila, int col) {
        initComponents();
        this.setModal(true);
        this.pj = Juego.pj;
        this.m = JFrameMapa.mapaMonstruos[fila][col];
        this.fila = fila;
        this.col = col;

        lblPersonaje.setText(pj.mostrarHTML());
        lblMonstruo.setText(m.mostrarHTML());

        setVisible(true);
    }

    private void MonstruoAtaca() {
        txtCombate.append("\n\n\n" + m.getNombre() + "(" + m.getPuntosVida() + ") ataca a "
                + pj.getNombre() + "(" + pj.getPuntosVida() + "): ");
        int dadosPj = Juego.random100();
        int ataque = m.getAtaque() + dadosPj;
        txtCombate.append("\n* Ataque = ");
        txtCombate.append("(" + m.getAtaque() + " + " + dadosPj + ") = " + ataque);
        int dadosM = Juego.random100();
        int defensa = pj.getAgilidad() + dadosM;
        txtCombate.append("\n* Defensa = ");
        txtCombate.append("(" + pj.getAgilidad() + " + " + dadosM + ") = " + defensa);

        int resultado = ataque - defensa;
        txtCombate.append("\n* Resultado: " + resultado);

        String txtResultado = "";

        if (resultado > 0) {
            pj.perderVida(resultado);
            // El personaje suma experiencia también por las heridas recibidas.
            pj.sumarExperiencia(resultado);
            txtCombate.append("\n" + pj.getNombre() + " suma " + resultado + " puntos de experiencia.");
            lblPersonaje.setText(pj.mostrarHTML());
            lblMonstruo.setText(m.mostrarHTML());

            if (!pj.estaVivo()) {
                txtResultado = "\n" + m.getNombre() + " mata a " + pj.getNombre() + "!!! (-" + resultado + " PV)";
                txtCombate.append(txtResultado);
                JOptionPane.showMessageDialog(this, txtResultado, "Personaje muerto  (Fin del juego)", JOptionPane.ERROR_MESSAGE);
                dispose(); // Cierra la ventana de combate
            } else {
                txtResultado = "\n" + m.getNombre() + " hiere a " + pj.getNombre() + " (-" + resultado + " PV)";
                txtCombate.append(txtResultado);
                JOptionPane.showMessageDialog(this, txtResultado, "Personaje herido", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            txtResultado = "\n" + pj.getNombre() + " esquiva o para el ataque.";
            txtCombate.append(txtResultado);
            JOptionPane.showMessageDialog(this, txtResultado, "Personaje ileso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void PjAtaca() {
        txtCombate.append("\n\n\n" + pj.getNombre() + "(" + pj.getPuntosVida() + ") ataca a "
                + m.getNombre() + "(" + m.getPuntosVida() + "): ");
        int dadosPj = Juego.random100();
        int dadosM = Juego.random100();
        int ataque = pj.getFuerza() + dadosPj;
        int defensa = m.getDefensa() + dadosM;
        txtCombate.append("\n* Ataque = ((" + pj.getFuerza() + " + " + dadosPj + ") = " + ataque);
        txtCombate.append("\n* Defensa = (" + m.getDefensa() + " + " + dadosM + ") = " + defensa);
        int resultado = ataque - defensa;
        txtCombate.append("\n* Resultado: " + resultado);

        String txtResultado = "";

        if (resultado > 0) {
            m.perderVida(resultado);
            // El personaje suma experiencia también por las heridas recibidas.
            pj.sumarExperiencia(resultado);
            txtCombate.append("\n" + pj.getNombre() + " suma " + resultado + " puntos de experiencia.");
            lblPersonaje.setText(pj.mostrarHTML());
            lblMonstruo.setText(m.mostrarHTML());

            if (!m.estaVivo()) {
                txtResultado = "\n" + pj.getNombre() + " mata a " + m.getNombre() + "!!! (-" + resultado + " PV)";
                txtCombate.append(txtResultado);
                JOptionPane.showMessageDialog(this, txtResultado, "Monstruo muerto", JOptionPane.ERROR_MESSAGE);
                dispose(); // Cierra la ventana de combate
            } else {
                txtResultado = "\n" + pj.getNombre() + " hiere a " + m.getNombre() + " (-" + resultado + " PV)";
                txtCombate.append(txtResultado);
                JOptionPane.showMessageDialog(this, txtResultado, "Monstruo herido", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            txtResultado = "\n" + m.getNombre() + " esquiva o para el ataque.";
            txtCombate.append(txtResultado);
            JOptionPane.showMessageDialog(this, txtResultado, "Monstruo ileso", JOptionPane.INFORMATION_MESSAGE);
        }
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
        btnAtacar = new javax.swing.JButton();
        lblMonstruo = new javax.swing.JLabel();
        btnHuir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCombate = new javax.swing.JTextArea();
        btnIniciarCombate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Escapa del laberinto!! - Combate!!");

        lblPersonaje.setBackground(new java.awt.Color(204, 255, 204));
        lblPersonaje.setToolTipText("");
        lblPersonaje.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnAtacar.setText("Atacar");
        btnAtacar.setEnabled(false);
        btnAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtacarActionPerformed(evt);
            }
        });

        lblMonstruo.setBackground(new java.awt.Color(204, 255, 204));
        lblMonstruo.setToolTipText("");
        lblMonstruo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnHuir.setText("Huir");
        btnHuir.setEnabled(false);
        btnHuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuirActionPerformed(evt);
            }
        });

        txtCombate.setColumns(20);
        txtCombate.setRows(5);
        txtCombate.setToolTipText("");
        jScrollPane1.setViewportView(txtCombate);

        btnIniciarCombate.setText("Iniciar Combate");
        btnIniciarCombate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarCombateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMonstruo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIniciarCombate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtacar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtacar)
                    .addComponent(btnHuir)
                    .addComponent(btnIniciarCombate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(lblMonstruo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuirActionPerformed
        dispose(); // Cierra la ventana de combate
    }//GEN-LAST:event_btnHuirActionPerformed

    private void btnAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtacarActionPerformed
        PjAtaca();

        if (m.estaVivo()) {
            MonstruoAtaca();
        } else {

        }
    }//GEN-LAST:event_btnAtacarActionPerformed

    private void btnIniciarCombateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarCombateActionPerformed
        // Reconfigura los botones
        btnIniciarCombate.setEnabled(false);
        btnAtacar.setEnabled(true);
        btnHuir.setEnabled(true);
        // Si el monstruo es más rápido ataca primero
        if (m.getVelocidad() > pj.getAgilidad()) {
            MonstruoAtaca();
        }
    }//GEN-LAST:event_btnIniciarCombateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtacar;
    private javax.swing.JButton btnHuir;
    private javax.swing.JButton btnIniciarCombate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMonstruo;
    private javax.swing.JLabel lblPersonaje;
    private javax.swing.JTextArea txtCombate;
    // End of variables declaration//GEN-END:variables
}
