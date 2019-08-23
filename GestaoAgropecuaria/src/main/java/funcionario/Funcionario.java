package funcionario;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cta
 */
@Entity
public class Funcionario {

    public static final String[] GENERO = {
        "-", "MASCULINO", "FEMININO"
    };
    public static final String[] CONTRATO = {
        "-", "MENSALISTA", "DIARISTA", "HORISTA"
    };
    public static final String[] CARGO = {
        "-", "ADMINISTRADOR", "GERENTE", "AGRONOMO", "VETERINARIO", "TRATORISTA", "PEAO"
    };
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 50, unique = true)
    private String nome;
    @Column
    private Integer genero;
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @Column(length = 20)
    private String cpf;
    @Column
    private Integer cargo;
    @Column
    private Integer contrato;
    @Column
    private Float salario;
    @Column
    private Float encargos;
    @Column(length = 20)
    private String telefone;
    @Column(length = 20, unique = true)
    private String usuario;
    @Column(length = 20)
    private String senha;

    /**
     * Construtor
     */
    public Funcionario() {
        this.id = null;
        this.nome = null;
        this.genero = 0;
        this.nascimento = new Date(-1900,0,1);
        this.cpf = "";
        this.cargo = 0;
        this.contrato = 0;
        this.salario = 0f;
        this.encargos = 0f;
        this.telefone = "";
        this.usuario = "";
        this.senha = "";
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
        try {
            this.id = Integer.parseInt(id);
        } catch (NumberFormatException e){
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
        this.nome = nome.trim().toUpperCase();
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
     * @return the nascimento
     */
    public Date getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @param formato
     * @return the nascimento
     */
    public String getNascimento(String formato) {
        return new SimpleDateFormat(formato).format(nascimento);
    }

    /**
     * @param formato
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String formato, String nascimento) {
        this.nascimento = new SimpleDateFormat(formato).parse(nascimento, new ParsePosition(0));
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
     * @return the cargo
     */
    public Integer getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the contrato
     */
    public Integer getContrato() {
        return contrato;
    }

    /**
     * @param contrato the contrato to set
     */
    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    /**
     * @return the salario
     */
    public Float getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Float salario) {
        this.salario = salario;
    }

    /**
     * @param formato
     * @return the salario
     */
    public String getSalario(String formato) {
        return new DecimalFormat(formato).format(salario);
    }

    /**
     * @param formato
     * @param salario the salario to set
     */
    public void setSalario(String formato, String salario) {
        this.salario = new DecimalFormat(formato).parse(salario, new ParsePosition(0)).floatValue();
    }

    /**
     * @return the encargos
     */
    public Float getEncargos() {
        return encargos;
    }

    /**
     * @param encargos the encargos to set
     */
    public void setEncargos(Float encargos) {
        this.encargos = encargos;
    }

    /**
     * @param formato
     * @return the encargos
     */
    public String getEncargos(String formato) {
        return new DecimalFormat(formato).format(encargos);
    }

    /**
     * @param formato
     * @param encargos the encargos to set
     */
    public void setEncargos(String formato, String encargos) {
        this.encargos = new DecimalFormat(formato).parse(encargos, new ParsePosition(0)).floatValue();
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
