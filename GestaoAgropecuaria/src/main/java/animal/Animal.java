package animal;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cta
 */
@Entity
public class Animal {

    private static final String[] ESPECIE = {
        "-",
        "Bovino",
        "Equino",
        "Suíno",
        "Caprino",
        "Ovino",
        "Coelho",
        "Ave"
    };

    private static final String[] CATEGORIA = {
        "-",
        "CORTE",
        "PRODUÇÃO",
        "CONSUMO"
    };
    private static final String[] ORIGEM = {
        "-",
        "IATF",
        "Fazenda",
        "Lote"
    };

    private static final String[] GENERO = {
        "-",
        "Macho",
        "Fêmea"
    };

    /**
     * @return the ESPECIE
     */
    public static String[] getESPECIE() {
        return ESPECIE;
    }

    /**
     * @return the CATEGORIA
     */
    public static String[] getCATEGORIA() {
        return CATEGORIA;
    }

    /**
     * @return the ORIGEM
     */
    public static String[] getORIGEM() {
        return ORIGEM;
    }

    /**
     * @return the GENERO
     */
    public static String[] getGENERO() {
        return GENERO;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50, unique = true)
    private String identificacao;

    @Column
    private Integer especie;

    @Column(length = 50)
    private String pai;

    @Column(length = 50)
    private String mae;

    @Column
    private Integer genero;

    @Column
    private Integer origem;

    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @Column
    private Integer categoria;

    @Column(length = 50)
    private String raca;

    @Column
    private String observacao;


    /**
     * Construtor
     */
    public Animal() {
        id = null;
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
     * @return the identificacao
     */
    public String getIdentificacao() {
        return identificacao;
    }

    /**
     * @param identificacao the identificacao to set
     */
    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    /**
     * @return the especie
     */
    public Integer getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(Integer especie) {
        this.especie = especie;
    }

    /**
     * @return the pai
     */
    public String getPai() {
        return pai;
    }

    /**
     * @param pai the pai to set
     */
    public void setPai(String pai) {
        this.pai = pai;
    }

    /**
     * @return the mae
     */
    public String getMae() {
        return mae;
    }

    /**
     * @param mae the mae to set
     */
    public void setMae(String mae) {
        this.mae = mae;
    }

    /**
     * @return the genero
     */
    public Integer getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    /**
     * @return the origem
     */
    public Integer getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(Integer origem) {
        this.origem = origem;
    }

    /**
     * @return the nascimento
     */
    public Date getNascimento() {
        return nascimento;
    }

    public String getNascimento(String formato) {
        return new SimpleDateFormat(formato).format(nascimento);
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @param formato
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String formato, String nascimento) {
        this.nascimento = new SimpleDateFormat(formato).parse(nascimento, new ParsePosition(0));
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
     * @return the raca
     */
    public String getRaca() {
        return raca;
    }

    /**
     * @param raca the raca to set
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
