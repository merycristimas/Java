package maquina;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.annotations.Entity;

/**
 *
 * @author cta17
 */
@Entity
public class Maquina {

    private Integer id;
    private String maquina;
    private String descricao;
    private Integer vidaUtil;
    private Date dataCompra;
    private Float valorCompra;
    private Float abrigo;
    private Float manutencao;
    private Float lubrificacao;

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
     * @return the maquina
     */
    public String getMaquina() {
        return maquina;
    }

    /**
     * @param maquina the maquina to set
     */
    public void setMaquina(String maquina) {
        this.maquina = maquina;
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
     * @return the vidaUtil
     */
    public Integer getVidaUtil() {
        return vidaUtil;
    }

    /**
     * @param vidaUtil the vidaUtil to set
     */
    public void setVidaUtil(Integer vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    /**
     * @param vidaUtil the vidaUtil to set
     */
    public void setVidaUtil(String vidaUtil) {
        this.vidaUtil = Integer.parseInt(vidaUtil);
    }

    /**
     * @return the dataCompra
     */
    public Date getDataCompra() {
        return dataCompra;
    }

    /**
     * @param formato
     * @return
     */
    public String getDataCompra(String formato) {
        return new SimpleDateFormat(formato).format(dataCompra);
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @param dataCompra the nascimento to set
     */
    public void setDataCompra(String formato, String dataCompra) {
        this.dataCompra = new SimpleDateFormat(formato).parse(dataCompra, new ParsePosition(0));
    }

    /**
     * @return the valorCompra
     */
    public Float getValorCompra() {
        return valorCompra;
    }

    /**
     * @param formato
     * @return
     */
    public String getValorCompra(String formato) {
        return new DecimalFormat(formato).format(valorCompra);
    }

    /**
     * @param valorCompra the valorCompra to set
     */
    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
    }

    /**
     * @param dataCompra the nascimento to set
     */
    public void setValorCompra(String formato, String valorCompra) {
        this.valorCompra = new DecimalFormat(formato).parse(valorCompra, new ParsePosition(0)).floatValue();
    }

    /**
     * @return the abrigo
     */
    public Float getAbrigo() {
        return abrigo;
    }

    /**
     * @param abrigo the abrigo to set
     */
    public void setAbrigo(String formato, String abrigo) {
        this.abrigo =  new DecimalFormat(formato).parse(abrigo, new ParsePosition(0)).floatValue();
    }

    /**
     * @param abrigo the abrigo to set
     */
    public void setAbrigo(Float abrigo) {
        this.abrigo =  abrigo;
    }
    
    /**
     * @return the manutencao
     */
    public Float getManutencao() {
        return manutencao;
    }

    /**
     * @param manutencao the manutencao to set
     */
    public void setManutencao(String formato, String manutencao) {
        this.manutencao =  new DecimalFormat(formato).parse(manutencao, new ParsePosition(0)).floatValue();
    }
    
    /**
     * @param manutencao the manutencao to set
     */
    public void setManutencao(Float manutencao) {
        this.manutencao = manutencao;
    }

    /**
     * @return the lubrificacao
     */
    public Float getLubrificacao() {
        return lubrificacao;
    }

    /**
     * @param lubrificacao the lubrificacao to set
     */
    public void setLubrificacao(Float lubrificacao) {
        this.lubrificacao = lubrificacao;
    }
    
    /**
     * @param lubrificacao the lubrificacao to set
     */
    public void setLubrificacao(String formato,String lubrificacao) {
        this.lubrificacao = new DecimalFormat(formato).parse(lubrificacao, new ParsePosition(0)).floatValue();
    }
    
    
}
