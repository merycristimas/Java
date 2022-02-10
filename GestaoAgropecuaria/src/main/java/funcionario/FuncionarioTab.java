/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author cta
 */
public class FuncionarioTab extends javax.swing.JDialog {

    private final Session session;
    private final List<Funcionario> lista;

    /**
     * Creates new form FuncionarioTab
     */
    public FuncionarioTab(java.awt.Window parent, Session session) {
        super(parent);
        this.session = session;
        this.lista = new ArrayList<>();
        initComponents();
        refresh();
        this.setVisible(true);

    }

    /**
     *
     * @param parent
     * @param session
     */
    public static void showDialog(java.awt.Window parent, Session session) {
        new FuncionarioTab(parent, session);
    }
    /*
     * Atualiza tabela
     */

    private void refresh() {
        //limpa a lista
        lista.removeAll(lista);
        //obtem uma lista de clientes do banco de dados
        lista.addAll(FuncionarioDAO.loadList(session));

        //obtem o modelo da tabela para edição
        DefaultTableModel mTabela = (DefaultTableModel) tTabela.getModel();

        //remove todas as linhas da tabela
        while (mTabela.getRowCount() > 0) { //Enquanto a contagem de linha for maior que zero
            mTabela.removeRow(0); //Remove linha 0
        }

        //adciona linhas na tabela
        for (Funcionario c : lista) {
            List linha = new ArrayList(); //Instancia nova linha
            //define os valores para a linha
            linha.add(c.getId());
            linha.add(c.getNome());
            linha.add(c.getNascimento("dd/MM/yyyy"));
            linha.add(c.getCpf());
            mTabela.addRow(linha.toArray()); //adiciona linha na tabela
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

        sTabela = new javax.swing.JScrollPane();
        tTabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        bInserir = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        tTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sTabela.setViewportView(tTabela);

        getContentPane().add(sTabela, java.awt.BorderLayout.CENTER);

        bInserir.setText("Inserir");
        bInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInserirActionPerformed(evt);
            }
        });
        jPanel1.add(bInserir);

        bEditar.setText("Editar");
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });
        jPanel1.add(bEditar);

        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(bExcluir);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(410, 330));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInserirActionPerformed
        Funcionario c = new Funcionario();          //instancia novo cliente
        c = FuncionarioForm.showDialog(this, c);    //exibe o formulário
        if (c != null) {                            //se objeto editado não for nulo 
            FuncionarioDAO.save(session, c);        //salva
            refresh();                              //atualiza tabela
        }
    }//GEN-LAST:event_bInserirActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        Funcionario c = lista.get(tTabela.getSelectedRow()); //obtem cliente da lista
        c = FuncionarioForm.showDialog(this, c);   //exibe o formulário
        if (c != null) {                           //se objeto editado não for nulo 
            FuncionarioDAO.save(session, c);       //salva
            refresh();                             //atualiza tabela
        }
    }//GEN-LAST:event_bEditarActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        Funcionario c = lista.get(tTabela.getSelectedRow()); //obtem cliente da lista
        Integer resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir o cliente " + c.getNome() + "?");
        if (resposta == JOptionPane.YES_OPTION) {
            FuncionarioDAO.delete(session, c);
            refresh();
        }
    }//GEN-LAST:event_bExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bInserir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane sTabela;
    private javax.swing.JTable tTabela;
    // End of variables declaration//GEN-END:variables
}