package venda.vendaitem;
/**
 *
 * @author JSQLGen
 */
public final class VendaItem {


    /** Atributos */
    private Integer id;
    private produto.Produto produto;
    private Integer quantidade;
    private Float valor;

    /** Construtor */
    public VendaItem() {
        id = null;
        produto = new produto.Produto();
        quantidade = 0;
        valor = 0.0f;
    }
    /** Metodos */

    /**
     * @return id
     */
    public Integer getId() { return id; }
    /**
     * @param id Id to set
     */
    public void setId(Integer id) { this.id = id; }
    /**
     * @param id - String id to set
     */
    public void setId(String id) { this.id = (id.equals("null") || id.isEmpty())?null:Integer.parseInt(id); }

    /**
     * @return produto
     */
    public produto.Produto getProduto() { return produto; }
    /**
     * @param produto Produto to set
     */
    public void setProduto(produto.Produto produto) { this.produto = produto; }

    /**
     * @return quantidade
     */
    public Integer getQuantidade() { return quantidade; }
    /**
     * @param quantidade Quantidade to set
     */
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    /**
     * @param quantidade - String quantidade to set
     */
    public void setQuantidade(String quantidade) { this.quantidade = Integer.parseInt(quantidade); }

    /**
     * @return the valor
     */
    public Float getValor() { return valor; }
    /**
     * @return valor Formatado
     */
    public String getValorF() { return new java.text.DecimalFormat("#,##0.00").format(valor); }
    /**
     * @param valor the valor to set
     */
    public void setValor(Float valor) { this.valor = valor; }
    /**
     * @param valor - String Valor to set
     */
    public void setValorF(String valor) { this.valor = new java.text.DecimalFormat("#,##0.00").parse(valor,new java.text.ParsePosition(0)).floatValue(); }
}
