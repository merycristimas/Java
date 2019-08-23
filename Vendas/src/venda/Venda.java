package venda;
/**
 *
 * @author JSQLGen
 */
public final class Venda {


    /** Atributos */
    private Integer id;
    private java.util.Date data;
    private cliente.Cliente cliente;
    private Float valor;
    private java.util.List<venda.vendaitem.VendaItem> itens;

    /** Construtor */
    public Venda() {
        id = null;
        data = new java.util.Date();
        cliente = new cliente.Cliente();
        valor = 0.0f;
        itens = new java.util.ArrayList<venda.vendaitem.VendaItem>();
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
     * @return Data
     */
    public java.util.Date getData() { return data; }
    /**
     * @param pattern Formato de Data. Ex "yyyy-MM-dd" ou "dd/MM/yyyy"
     * @return Data Formatado
     */
    public String getDataF(String pattern) { return new java.text.SimpleDateFormat(pattern).format(data); }
    /**
     * @param data Data to set
     */
    public void setData(java.util.Date data) { this.data = data; }
    /**
     * @param pattern Formato de Data. Ex "yyyy-MM-dd" ou "dd/MM/yyyy"
     * @param data - String Data to set
     */
    public void setDataF(String pattern, String data) { this.data = new java.text.SimpleDateFormat(pattern).parse(data, new java.text.ParsePosition(0)); }

    /**
     * @return cliente
     */
    public cliente.Cliente getCliente() { return cliente; }
    /**
     * @param cliente Cliente to set
     */
    public void setCliente(cliente.Cliente cliente) { this.cliente = cliente; }

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

    /**
     * @return the itens
     */
    public java.util.List<venda.vendaitem.VendaItem> getItens() { return itens; }
    /**
     * @param itens the itens to set
     */
    public void setItens(java.util.List<venda.vendaitem.VendaItem> itens) { this.itens = itens; }
}
