package imc;

import java.text.DecimalFormat;
import java.text.ParsePosition;

/**
 *
 * @author ctalab
 */
public class IMC {

    //Atributos
    private Float peso;
    private Float altura;

    /**
     * Construtor
     */
    public IMC() {
        this.peso = 0f;
        this.altura = 0f;
    }

    /**
     * ********************
     * Encapsulamento
     *********************
     */
    /**
     * @return the peso
     */
    public Float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Float peso) {
        this.peso = Math.abs(peso);
    }

    /**
     * @param peso the peso to set
     */
    public void setPesoF(String peso) {
        setPeso(new DecimalFormat("#,##0.###").parse(peso, new ParsePosition(0)).floatValue());
    }

    /**
     * @return the altura
     */
    public Float getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(Float altura) {
        this.altura = Math.abs(altura);
    }

    /**
     * @param altura the altura to set
     */
    public void setAlturaF(String altura) {
        setAltura(new DecimalFormat("#,##0.###").parse(altura, new ParsePosition(0)).floatValue());
    }

    /**
     * ******************
     * Cálculos
     ******************
     */

    /**
     * @return cálculo do IMC
     */
    public Float getIMC() {
        return peso / (altura * altura);
    }

    /**
     * @return cálculo do IMC formatado
     */
    public String getIMC_F() {
        return new DecimalFormat("#,##0.###").format(getIMC());
    }

    /**
     * @return Classificação do IMC
     */
    public String getClassificacao(){
        /*Integer[] IMC_Valores = { 20,25,30,35,40,45,50 };
        String[] IMC_Classificacao = { "Abaixo do Peso","Peso Ideal","Sobrepeso","Obesidade Moderada","Obesidade Severa","Obesidade Mórbida","Super Obesidade"};
        for(int i=0;i<7;i++){
            if(getIMC()<=IMC_Valores[i]){
                return IMC_Classificacao[i];
            }
        }
        return "";*/
        if(getIMC()<=20){
            return "Abaixo do Peso";
        }
        if(getIMC()<=25){
            return "Peso Ideal";
        }
        if(getIMC()<=30){
            return "Sobrepeso";
        }
        if(getIMC()<=35){
            return "Obesidade Moderada";
        }
        if(getIMC()<=40){
            return "Obesidade Severa";
        }
        if(getIMC()<=45){
            return "Obesidade Mórbida";
        }
        return "Super Obesidade";
    }
}
