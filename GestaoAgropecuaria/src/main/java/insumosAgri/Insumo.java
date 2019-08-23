package insumosAgri;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.ComboBoxModel;

/**
 *
 * @author cta
 */
@Entity
public class Insumo {

    public static final String[] CATEGORIA = {
        "-",
        "SEMENTE",
        "RAÇÃO",
        "MUDAS",
        "ADUBO",
        "RESTOS",
        "FERTILIZANTE",
        "MINERAIS",
        "DEFENSIVOS",
        "COMBÚSTIVEL"
    };
    public static final String[] UNIDADE = {
        "-",
        "PEÇA",
        "METRO LINEAR",
        "METRO QUADRADO",
        "METRO CUBICO",
        "LITRO",
        "MILI LITRO",
        "QUILO"
    };
    

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50, unique = true)
    private String nome;

    @Column
    private Integer categoria;

    @Column
    private Float quantidade;

    @Column
    private Integer unidade;
    
    @Column
    private Float valor;

    public Insumo() {
        this.id = null;
        this.nome = null;
        this.quantidade = 0f;
        this.valor = 0f;

    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the categoria
     */
    public Integer getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the quantidade
     */
    public Float getQuantidade() {
        return quantidade;
    }

    /**
     * @param formato
     * @return the quantidade
     */
    public String getQuantidade(String formato) {
        return new DecimalFormat(formato).format(quantidade);
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @param formato
     * @param quantidade the nascimento to set
     */
    public void setQuantidade(String formato, String quantidade) {
        this.quantidade = new DecimalFormat(formato).parse(quantidade, new ParsePosition(0)).floatValue();
    }

    /**
     * @return the unidade
     */
    public Integer getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the valor
     */
    public Float getValor() {
        return valor;
    }
     /**
     * @param formato
     * @return the valor
     */
    public String getValor(String formato) {
        return new DecimalFormat(formato).format(valor);
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }
    /**
     * @param formato
     * @param valor the nascimento to set
     */
    public void setValor(String formato, String valor) {
        this.valor = new DecimalFormat(formato).parse(valor, new ParsePosition(0)).floatValue();
    }
}
