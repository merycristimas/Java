package pessoa;
/**
 *
 * @author JSQLGen
 */
public class PessoaForm extends javax.swing.JDialog {
    private final java.sql.Connection connection;
    private Pessoa pessoa;

    /** Construtor do form PessoaForm
     * @param parent Janela mãe
     * @param connection Conexão com o BD
     * @param pessoa Objeto a ser editado
     */
    public PessoaForm(java.awt.Window parent, java.sql.Connection connection, Pessoa pessoa) {
        super(parent);
        this.connection = connection;
        this.pessoa = pessoa;
        initComponents();
        obj2form();
        this.setVisible(true);
    }

    /** Exibe caixa de diálogo para preenchimento dos campos
     * @param parent Janela mãe
     * @param connection Conexão com o BD
     * @param pessoa Objeto a ser editado
     * @return the pessoa
     */
    public static Pessoa showInputDialog(java.awt.Window parent, java.sql.Connection connection, Pessoa pessoa) {
        return new PessoaForm(parent, connection, pessoa).pessoa;
    }

    /** Transfere os dados do objeto para o formulário */
    private void obj2form() {
        tId.setText(pessoa.getId()==null?"":pessoa.getId().toString());
        tNome.setText(pessoa.getNome()==null?"":pessoa.getNome());
        tNascimento.setText(pessoa.getNascimentoF("dd/MM/yyyy"));
        cGenero.setSelectedItem(pessoa.getGenero());
        tEmail.setText(pessoa.getEmail());
        tCelular.setText(pessoa.getCelular());
        tUsuario.setText(pessoa.getUsuario()==null?"":pessoa.getUsuario());
        tSenha.setText(pessoa.getSenha());
    }

    /** Transfere os dados do formulário para o objeto */
    private void form2obj() {
        pessoa.setId(tId.getText());
        pessoa.setNome(tNome.getText());
        pessoa.setNascimentoF("dd/MM/yyyy",tNascimento.getText());
        pessoa.setGenero(cGenero.getSelectedItem().toString());
        pessoa.setEmail(tEmail.getText());
        pessoa.setCelular(tCelular.getText());
        pessoa.setUsuario(tUsuario.getText());
        pessoa.setSenha(tSenha.getText());
    }

    /** valida os dados do formulário */
    private String validateForm() {
        String fieldError ="";
        if(tNome.getText().length()<1) fieldError +="Nome\n";
        if(cGenero.getSelectedItem()==null) fieldError +="Genero\n";
        if(tEmail.getText().length()<1) fieldError +="Email\n";
        if(tCelular.getText().length()<1) fieldError +="Celular\n";
        if(tUsuario.getText().length()<1) fieldError +="Usuario\n";
        if(tSenha.getText().length()<1) fieldError +="Senha\n";
        return fieldError;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pData = new javax.swing.JPanel();
        tbData = new javax.swing.JTabbedPane();
        pButtons = new javax.swing.JPanel();
        bOk = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        tId = new javax.swing.JLabel();
        tNome = new javax.swing.JFormattedTextField();
        tNascimento = new javax.swing.JFormattedTextField();
        cGenero = new javax.swing.JComboBox(Pessoa.GENERO);
        tEmail = new javax.swing.JFormattedTextField();
        tCelular = new javax.swing.JFormattedTextField();
        tUsuario = new javax.swing.JFormattedTextField();
        tSenha = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulário de Pessoa");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pData.setLayout(new java.awt.GridLayout(5, 0));
        tId.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tId.setBorder(javax.swing.BorderFactory.createTitledBorder("Id"));
        pData.add(tId);
        tNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));
        pData.add(tNome);
        tNascimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Nascimento"));
        try {
            tNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pData.add(tNascimento);
        cGenero.setBorder(javax.swing.BorderFactory.createTitledBorder("Genero"));
        pData.add(cGenero);
        tEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));
        pData.add(tEmail);
        tCelular.setBorder(javax.swing.BorderFactory.createTitledBorder("Celular"));
        try {
            tCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pData.add(tCelular);
        tUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));
        pData.add(tUsuario);
        tSenha.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha"));
        pData.add(tSenha);
        getContentPane().add(pData, java.awt.BorderLayout.NORTH);
        getContentPane().add(tbData, java.awt.BorderLayout.CENTER);
        pButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        bOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbox/images/stock_calc-accept-16.png"))); // NOI18N
        bOk.setMnemonic('O');
        bOk.setText("Ok");
        bOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });
        pButtons.add(bOk);
        bCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbox/images/stock_calc-cancel-16.png"))); // NOI18N
        bCancel.setMnemonic('C');
        bCancel.setText("Cancelar");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });
        pButtons.add(bCancel);
        getContentPane().add(pButtons, java.awt.BorderLayout.SOUTH);
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
        String fieldError =validateForm();
        if(fieldError.length()==0) {
            form2obj();
            this.setVisible(false);
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Verifique os campos seguintes e tente novamente!\n"+fieldError,"Aviso",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bOkActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        pessoa = null;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        bCancelActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bOk;
    private javax.swing.JPanel pButtons;
    private javax.swing.JPanel pData;
    private javax.swing.JTabbedPane tbData;
    private javax.swing.JLabel tId;
    private javax.swing.JFormattedTextField tNome;
    private javax.swing.JFormattedTextField tNascimento;
    private javax.swing.JComboBox cGenero;
    private javax.swing.JFormattedTextField tEmail;
    private javax.swing.JFormattedTextField tCelular;
    private javax.swing.JFormattedTextField tUsuario;
    private javax.swing.JFormattedTextField tSenha;
    // End of variables declaration//GEN-END:variables
}