package caixa;

/**
 *
 * @author cta
 */
public class CaixaForm extends javax.swing.JDialog {
    private Caixa caixa;
    
    /**
     * Creates new form CaixaTab
     * @param parent
     * @param caixa
     */
    public CaixaForm(java.awt.Window parent, Caixa caixa) {
        super(parent);
        this.caixa = caixa;
        initComponents();
        obj2form();
        this.setVisible(true);
    }
    
    /**
     * @param parent
     * @param caixa
     * @return 
     */
    public static Caixa showDialog(java.awt.Window parent, Caixa caixa) {
        CaixaForm form = new CaixaForm(parent, caixa);
        return form.caixa;
    }

    /**
     * 
     */
    private void obj2form() {
        tId.setText(""+caixa.getId());
        cTipo.setSelectedIndex(caixa.getTipo());
        tDescricao.setText(""+caixa.getDescricao());        
        tDataPagamento.setText(caixa.getDataPagamento("dd/MM/yyyy"));
        tDataVencimento.setText(caixa.getDataVencimento("dd/MM/yyyy"));
        tDataCadastro.setText(caixa.getDataCadastro("dd/MM/yyyy"));
        tValorPago.setText(caixa.getValorPago("#,##0.00"));
        tValor.setText(caixa.getValor("#,##0.00"));
        tObservacao.setText(""+caixa.getObservacao());        
    }
    
    /**
     * 
     */
    private void form2obj() {
        caixa.setId(tId.getText());
        caixa.setTipo(cTipo.getSelectedIndex());
        caixa.setDescricao(tDescricao.getText());
        caixa.setValorPago("#,##0.00",tValorPago.getText());
        caixa.setValor("#,##0.00",tValor.getText());
        caixa.setDataPagamento("dd/MM/yyyy",tDataPagamento.getText());
        caixa.setDataVencimento("dd/MM/yyyy",tDataVencimento.getText());
        caixa.setDataCadastro("dd/MM/yyyy",tDataCadastro.getText());
        caixa.setObservacao(tObservacao.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tId = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cTipo = new javax.swing.JComboBox (Caixa.TIPO);
        ;
        tDescricao = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        tDataPagamento = new javax.swing.JFormattedTextField();
        tDataVencimento = new javax.swing.JFormattedTextField();
        tDataCadastro = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        tValor = new javax.swing.JFormattedTextField();
        tValorPago = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        sObservacao = new javax.swing.JScrollPane();
        tObservacao = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        bOk = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        tId.setBorder(javax.swing.BorderFactory.createTitledBorder("Id"));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulário do Caixa");
        setModal(true);

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        cTipo.setToolTipText("");
        cTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        jPanel4.add(cTipo);

        tDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
        jPanel4.add(tDescricao);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        tDataPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Pagamento"));
        jPanel5.add(tDataPagamento);

        tDataVencimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Vencimento"));
        jPanel5.add(tDataVencimento);

        tDataCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Cadastro"));
        jPanel5.add(tDataCadastro);

        jPanel1.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        tValor.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor"));
        jPanel6.add(tValor);

        tValorPago.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Pago"));
        jPanel6.add(tValorPago);

        jPanel1.add(jPanel6);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        tObservacao.setColumns(20);
        tObservacao.setRows(5);
        sObservacao.setViewportView(tObservacao);

        jPanel3.add(sObservacao, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        bOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock_calc-accept-16.png"))); // NOI18N
        bOk.setMnemonic('O');
        bOk.setText("OK");
        bOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });
        jPanel2.add(bOk);

        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock_calc-cancel-16.png"))); // NOI18N
        bCancelar.setMnemonic('C');
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(bCancelar);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(652, 487));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        caixa = null;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
      form2obj();
        setVisible(false);
    }//GEN-LAST:event_bOkActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bOk;
    private javax.swing.JComboBox cTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane sObservacao;
    private javax.swing.JFormattedTextField tDataCadastro;
    private javax.swing.JFormattedTextField tDataPagamento;
    private javax.swing.JFormattedTextField tDataVencimento;
    private javax.swing.JFormattedTextField tDescricao;
    private javax.swing.JFormattedTextField tId;
    private javax.swing.JTextArea tObservacao;
    private javax.swing.JFormattedTextField tValor;
    private javax.swing.JFormattedTextField tValorPago;
    // End of variables declaration//GEN-END:variables
}
