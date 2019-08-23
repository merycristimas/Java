package area;

public class AreaForm extends javax.swing.JDialog {

    private Area area;

    public AreaForm(java.awt.Window parent, Area area) {
        super(parent);
        this.area = area;
        this.setVisible(true);
    }

    public static Area showDialog(java.awt.Window parent, Area area) {
        AreaForm form = new AreaForm(parent, area);
        return form.area;
    }

    private void obj2form() {
        tId.setText("" + area.getId());
        tNome.setText(area.getNome());
        tArea.setText(area.getArea("#,##0.###"));
        cUnidade.setSelectedIndex(area.getUnidade());
        cTipo.setSelectedIndex(area.getTipo());

    }

    private void form2obj() {
        area.setId(tId.getText());
        area.setNome(tNome.getText());
        area.setArea("#,##0.###",tArea.getText());
        area.setUnidade(cUnidade.getSelectedIndex());
        area.setTipo(cTipo.getSelectedIndex());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tId = new javax.swing.JTextField();
        tNome = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        tArea = new javax.swing.JTextField();
        cUnidade = new javax.swing.JComboBox();
        cTipo = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        bOk = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Area");
        setModal(true);

        jPanel1.setLayout(new java.awt.GridLayout(3, 0, 10, 10));

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        tId.setEditable(false);
        tId.setBorder(javax.swing.BorderFactory.createTitledBorder("Id"));
        tId.setFocusable(false);
        jPanel2.add(tId);

        jPanel1.add(jPanel2);

        tNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));
        jPanel1.add(tNome);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        tArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Area"));
        jPanel3.add(tArea);

        cUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " - ", "Hectare", "m²", "Alqueire", "Are" }));
        cUnidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidade"));
        jPanel3.add(cUnidade);

        cTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " - ", "A.P.P", "Talhões", "Benfeitorias", "Pasto" }));
        cTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        jPanel3.add(cTipo);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        bOk.setText("Ok");
        bOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });
        jPanel4.add(bOk);

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(bCancelar);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(410, 251));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
        form2obj();
        this.setVisible(false);
    }//GEN-LAST:event_bOkActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.area = null;
        this.setVisible(false);
    }//GEN-LAST:event_bCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bOk;
    private javax.swing.JComboBox cTipo;
    private javax.swing.JComboBox cUnidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tArea;
    private javax.swing.JTextField tId;
    private javax.swing.JTextField tNome;
    // End of variables declaration//GEN-END:variables
}
