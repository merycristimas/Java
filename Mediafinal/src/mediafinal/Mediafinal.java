/*
 Este progama mostrara a media final de um aluno
 */
package mediafinal;

import static ferramentas.Ferramentas.*;

/**
 *
 * @author ctalab
 */
public class Mediafinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaração de variavel
        Float n1;
        Float n2;
        Float n3;
        Float n4;
        Float media;
        //Leitura de variavel
        n1 = leiaFloat("Digite a nota do 1º Bimestre");
        n2 = leiaFloat("Digite a nota do 2º Bimestre");
        n3 = leiaFloat("Digite a nota do 3º Bimestre");
        n4 = leiaFloat("Digite a nota do 4º Bimestre");
        //Calculo da variavel
        media = (n1 + n2 + n3 + n4) / 4;
        //Exiba resultado
        if (media >= 7) {
            escreva("Aprovado");
        } else {
            escreva("Reprovado");

        }

    }

}

}
