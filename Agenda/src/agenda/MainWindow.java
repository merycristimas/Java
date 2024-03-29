package agenda;

/**
 *
 * @author JSQLGen
 */
public class MainWindow extends javax.swing.JFrame {

    private dbaccess.DBAccess dbAccess;

    /** Creates new form MainWindow */
    public MainWindow() {
        try {
            dbAccess = new dbaccess.DBAccess();
            initComponents();
            this.setVisible(true);
        } catch(ClassNotFoundException e){
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar driver JDBC", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch(java.sql.SQLException e){
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao conectar no Banco de Dados", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(2);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        menuBar = new javax.swing.JMenuBar();
        mArquivo = new javax.swing.JMenu();
        mPessoa = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mSair = new javax.swing.JMenuItem();
        mRelatorio = new javax.swing.JMenu();
        mSQLViewer = new javax.swing.JMenuItem();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        mArquivo.setMnemonic('A');
        mArquivo.setText("Arquivo");
        mPessoa.setText("Pessoa");
        mPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPessoaActionPerformed(evt);
            }
        });
        mArquivo.add(mPessoa);
        mArquivo.add(jSeparator1);
        mSair.setText("Sair");
        mSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSairActionPerformed(evt);
            }
        });
        mArquivo.add(mSair);
        menuBar.add(mArquivo);
        mRelatorio.setMnemonic('R');
        mRelatorio.setText("Relatórios");
        mSQLViewer.setText("Consulta SQL");
        mSQLViewer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSQLViewerActionPerformed(evt);
            }
        });
        mRelatorio.add(mSQLViewer);
        menuBar.add(mRelatorio);
        setJMenuBar(menuBar);
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(javax.swing.JOptionPane.showConfirmDialog(this, "Deseja sair?", "Questão", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE) == javax.swing.JOptionPane.OK_OPTION){
            try{
                dbAccess.disconnect();
                this.dispose();
                System.exit(0);
            } catch(java.sql.SQLException e){
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao desconectar no Banco de Dados", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void mSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSairActionPerformed
        formWindowClosing(null);
    }//GEN-LAST:event_mSairActionPerformed

    private void mSQLViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSQLViewerActionPerformed
        new toolbox.SQLViewer(this, dbAccess.getConnection());
    }//GEN-LAST:event_mSQLViewerActionPerformed

    private void mPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPessoaActionPerformed
        pessoa.PessoaTab.showDialog(this, dbAccess.getConnection());
    }//GEN-LAST:event_mPessoaActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu mArquivo;
    private javax.swing.JMenuItem mPessoa;
    private javax.swing.JMenu mRelatorio;
    private javax.swing.JMenuItem mSQLViewer;
    private javax.swing.JMenuItem mSair;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
