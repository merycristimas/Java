package ferramentas;

public class Ferramentas {

    /**
     * @param mensagem
     */
    public static void escreva(String mensagem) {
        javax.swing.JOptionPane.showMessageDialog(null, mensagem);
    }

    /**
     *
     * @param mensagem
     * @return
     */
    public static String leia(String mensagem) {
        return javax.swing.JOptionPane.showInputDialog(null, mensagem);
    }

    /**
     * Lê um valor numérico inteiro
     *
     * @param mensagem Mensagem a ser exibida
     * @return Valor inteiro lido pelo teclado
     */
    public static Integer leiaInt(String mensagem) {
        return Integer.parseInt(javax.swing.JOptionPane.showInputDialog(mensagem));
    }

    /**
     * Lê um valor numérico float
     *
     * @param mensagem Mensagem a ser exibida
     * @return Valor float lido pelo teclado
     */
    public static Float leiaFloat(String mensagem) {
        return Float.parseFloat(javax.swing.JOptionPane.showInputDialog(mensagem));
    }

}
