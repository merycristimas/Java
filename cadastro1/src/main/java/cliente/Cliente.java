package cliente;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50, unique = true)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date nascimento;

    private Integer genero;

    @Column(length = 15)
    private String cpf;
    
    @Column(length = 20,unique = true)
    private String usuario;
    
    @Column(length = 20)
    private String senha;
/**
 * Construtor
 */
    public Cliente() {
        this.id = null;
        this.nome = null;
        this.nascimento = new Date(-1900, 0, 1);
        this.genero = 0;
        this.cpf = "";
    }

    /**
     * Construtor
     *
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
        try {
            this.id = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            this.id = null;
        }
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
     * @return the nascimento
     */
    public Date getNascimento() {
        return nascimento;
    }

    /**
     * @param formato
     * @return the nascimento
     */
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
