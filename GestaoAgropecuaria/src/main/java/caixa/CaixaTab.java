package caixa;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author cta
 */
public class CaixaTab extends javax.swing.JDialog {

    private final Session session;
    private final List<Caixa> lista;

    /**
     * Creates new form ClienteTab
     *
     * @param parent
     */
    public CaixaTab(java.awt.Window parent, Session session) {
        super(parent);
        this.session = session;
        this.lista = new ArrayList<>();
        initComponents();
        refresh();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tTabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        bInserir = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" Tabela do Caixa");

        tTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo", "Descrição", "Cadastro", "Vencimento", "Pagamento", "Valor", "Valor Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tTabela);
        if (tTabela.getColumnModel().getColumnCount() > 0) {
            tTabela.getColumnModel().getColumn(0).setMinWidth(0);
            tTabela.getColumnModel().getColumn(0).setPreferredWidth(0);
            tTabela.getColumnModel().getColumn(0).setMaxWidth(0);
        }
        tTabela.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        bInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock_new-16.png"))); // NOI18N
        bInserir.setText("Inserir");
        bInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInserirActionPerformed(evt);
            }
        });
        jPanel1.add(bInserir);

        bEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock_open-16.png"))); // NOI18N
        bEditar.setText("Editar");
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });
        jPanel1.add(bEditar);

        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock_delete-16.png"))); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(bExcluir);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(719, 488));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param parent
     * @param session 
     */
    public static void showDialog(java.awt.Window parent, Session session) {
        new CaixaTab(parent, session);
    }

    private void refresh() {
        ///limpa a lista
        lista.removeAll(lista);
        //Obtem uma lista de clientes do banco de dados
        lista.addAll(CaixaDAO.loadList(session));

        DefaultTableModel mTabela = (DefaultTableModel) tTabela.getModel();
        while (mTabela.getRowCount() > 0) {
            mTabela.removeRow(0);

        }
        for (Caixa c : lista) {
            List linha = new ArrayList();
            linha.add(c.getId());
            linha.add(c.getTipoF());
            linha.add(c.getDescricao());
            linha.add(c.getDataCadastro("dd/MM/yyyy"));
            linha.add(c.getDataPagamento("dd/MM/yyyy"));
            linha.add(c.getDataVencimento("dd/MM/yyyy"));
            linha.add(c.getValor("#,##0.00"));
            linha.add(c.getValorPago("#,##0.00"));
            mTabela.addRow(linha.toArray());
        }
    }

    private void bInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInserirActionPerformed
        Caixa c = new Caixa();
        c = CaixaForm.showDialog(this, c);
        if (c != null) {
            CaixaDAO.save(session, c);
            refresh();
        }
    }//GEN-LAST:event_bInserirActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        Caixa c = lista.get(tTabela.getSelectedRow());
        Integer resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir a movimentação da data de vencimento " + c.getDataVencimento("dd/MM/yyyy") + "?");
        if (resposta == JOptionPane.YES_OPTION) {
            CaixaDAO.delete(session, c);
            refresh();
        }
    }//GEN-LAST:event_bExcluirActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        Caixa c = lista.get(tTabela.getSelectedRow());
        c = CaixaForm.showDialog(this, c);
        if (c != null) {
            CaixaDAO.save(session, c);
            refresh();
        }
    }//GEN-LAST:event_bEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bInserir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tTabela;
    // End of variables declaration//GEN-END:variables
}
