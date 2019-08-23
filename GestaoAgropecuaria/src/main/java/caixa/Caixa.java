package caixa;

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
public class Caixa {

    public static final String[] TIPO = {
        "RECEITA", "DESPESA"
    };

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer tipo;

    @Column(length = 50)
    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    @Column
    private Float valor;
    @Column
    private Float valorPago;

    @Column
    private String observacao;

    /**
     * Construtor
     */
    public Caixa() {
        this.id = null;
        this.tipo = 0;
        this.descricao = "";
        this.dataCadastro = new Date();
        this.dataVencimento = new Date();
        this.dataPagamento = new Date();
        this.valor = 0f;
        this.valorPago = 0f;
        this.observacao = "";

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
        } catch (NumberFormatException e) {

            this.id = null;
        }
    }

    /**
     * @return the tipo
     */
    public Integer getTipo() {
        return tipo;
    }
    /**
     * @return the tipo
     */
    public String getTipoF() {
        return TIPO[tipo];
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param formato
     * @return
     */
    public String getDataCadastro(String formato) {
        return new SimpleDateFormat(formato).format(dataCadastro);
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @param formato
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(String formato, String dataCadastro) {
        this.dataCadastro = new SimpleDateFormat(formato).parse(dataCadastro, new ParsePosition(0));
    }

    /**
     * @return the dataVencimento
     */
    public Date getDataVencimento() {
        return dataVencimento;
    }

    /**
     *
     * @param formato
     * @return
     */

    public String getDataVencimento(String formato) {
        return new SimpleDateFormat(formato).format(dataVencimento);
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     *
     * @param formato
     * @param dataVencimento
     */
    public void setDataVencimento(String formato, String dataVencimento) {
        this.dataVencimento = new SimpleDateFormat(formato).parse(dataVencimento, new ParsePosition(0));
    }

    /**
     * @return the dataPagamento
     */
    public Date getDataPagamento() {
        return dataPagamento;
    }

    /**
     *
     * @param formato
     * @return
     */
    public String getDataPagamento(String formato) {
        return new SimpleDateFormat(formato).format(dataPagamento);
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     *
     * @param formato
     * @param dataPagamento
     */
    public void setDataPagamento(String formato, String dataPagamento) {
        this.dataPagamento = new SimpleDateFormat(formato).parse(dataPagamento, new ParsePosition(0));
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
     * @param valor the valor to set
     */
    public void setValor(String formato, String valor) {
        this.valor = new DecimalFormat(formato).parse(valor, new ParsePosition(0)).floatValue();
    }

    /**
     * @return the valorPago
     */
    public Float getValorPago() {
        return valorPago;
    }

    /**
     *
     * @param formato
     * @return
     */
    public String getValorPago(String formato) {
        return new DecimalFormat(formato).format(valorPago);
    }

    /**
     * @param valorPago the valorPago to set
     */
    public void setValorPago(Float valorPago) {
        this.valorPago = valorPago;
    }

    /**
     *
     * @param formato
     * @param valorPago
     */
    public void setValorPago(String formato, String valorPago) {
        this.valorPago = new DecimalFormat(formato).parse(valorPago, new ParsePosition(0)).floatValue();
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
