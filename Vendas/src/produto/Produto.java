package produto;
/**
 *
 * @author JSQLGen
 */
public final class Produto {

    /** Atributos estaticos */
    public static String[] CATEGORIA = {
        "- Selecione-",
        "SALGADOS",
        "DOCES",
        "REFRIGERANTES",
        "SUCOS",
        "BEBIDA ALCOÓLICAS",
        "FRIOS"
    };

    /** Atributos */
    private Integer id;
    private String nome;
    private String codBarras;
    private Integer categoria;
    private Integer quantidade;
    private Float valorCusto;
    private Float valorVenda;
    private javax.swing.ImageIcon foto;

    /** Construtor */
    public Produto() {
        id = null;
        nome = null;
        codBarras = "";
        categoria = 0;
        quantidade = 0;
        valorCusto = 0.0f;
        valorVenda = 0.0f;
        foto = new javax.swing.ImageIcon();
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
     * @return nome
     */
    public String getNome() { return nome; }
    /**
     * @param nome Nome to set
     */
    public void setNome(String nome) { this.nome = (nome.length()>30?nome.substring(0,30):nome).replace('\'','`'); }

    /**
     * @return codBarras
     */
    public String getCodBarras() { return codBarras; }
    /**
     * @param codBarras CodBarras to set
     */
    public void setCodBarras(String codBarras) { this.codBarras = (codBarras.length()>25?codBarras.substring(0,25):codBarras).replace('\'','`'); }

    /**
     * @return the categoria
     */
    public Integer getCategoria() { return categoria; }
    /**
     * @return the categoria Formatted
     */
    public String getCategoriaF() { return CATEGORIA[categoria]; }
    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Integer categoria) { this.categoria = categoria; }

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
     * @return the valorCusto
     */
    public Float getValorCusto() { return valorCusto; }
    /**
     * @return valorCusto Formatado
     */
    public String getValorCustoF() { return new java.text.DecimalFormat("#,##0.00").format(valorCusto); }
    /**
     * @param valorCusto the valorCusto to set
     */
    public void setValorCusto(Float valorCusto) { this.valorCusto = valorCusto; }
    /**
     * @param valorCusto - String ValorCusto to set
     */
    public void setValorCustoF(String valorCusto) { this.valorCusto = new java.text.DecimalFormat("#,##0.00").parse(valorCusto,new java.text.ParsePosition(0)).floatValue(); }

    /**
     * @return the valorVenda
     */
    public Float getValorVenda() { return valorVenda; }
    /**
     * @return valorVenda Formatado
     */
    public String getValorVendaF() { return new java.text.DecimalFormat("#,##0.00").format(valorVenda); }
    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(Float valorVenda) { this.valorVenda = valorVenda; }
    /**
     * @param valorVenda - String ValorVenda to set
     */
    public void setValorVendaF(String valorVenda) { this.valorVenda = new java.text.DecimalFormat("#,##0.00").parse(valorVenda,new java.text.ParsePosition(0)).floatValue(); }

    /**
     * @return Foto
     */
    public javax.swing.ImageIcon getFoto() { return foto; }
    /**
     * @param formatName - a String containg the informal name of the format.(PNG,JPEG,GIF)
     * @return the ByteArrayInputStream representing the Foto.
     */
    public java.io.ByteArrayInputStream getFoto(String formatName) {
        try {
            java.awt.image.BufferedImage bf = new java.awt.image.BufferedImage(foto.getIconWidth(),foto.getIconHeight(),java.awt.image.BufferedImage.TYPE_INT_ARGB);
            bf.createGraphics().drawImage(foto.getImage(), null, null);
            java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
            //javax.imageio.ImageIO.write(bf,"PNG",output);
            javax.imageio.ImageIO.write(bf,formatName,output);
            return new java.io.ByteArrayInputStream(output.toByteArray());
        } catch(java.io.IOException e){
            return new java.io.ByteArrayInputStream(new byte[0]);
        } catch(IllegalArgumentException  e){
            return new java.io.ByteArrayInputStream(new byte[0]);
        }
    }
    /**
     * @param foto Foto to set
     */
    public void setFoto(javax.swing.ImageIcon foto) { this.foto = foto; }
    /**
     * @param foto Foto to set
     * @param width Foto fixed width
     */
    public void setFoto(javax.swing.ImageIcon foto, int width) {
        width = Math.abs(width);
        if(width==0) width = foto.getIconWidth();
        int height = (width*foto.getIconHeight()) / foto.getIconWidth();
        java.awt.image.BufferedImage bf = new java.awt.image.BufferedImage(width, height,java.awt.image.BufferedImage.TYPE_INT_ARGB);
        bf.createGraphics().drawImage(foto.getImage(), 0, 0, width, height, null);
        this.foto = new javax.swing.ImageIcon(bf);
    }
    /**
     * Salva Foto em arquivo
     * @param path - path file
     * @param format - JPG,PNG,GIF
     * @throws java.io.IOException 
     */
    public void saveFoto(String path, String format) throws java.io.IOException{
        java.awt.image.BufferedImage bf = new java.awt.image.BufferedImage(foto.getIconWidth(),foto.getIconHeight(),java.awt.image.BufferedImage.TYPE_INT_ARGB);
        bf.createGraphics().drawImage(foto.getImage(), null, null);
        java.io.File file = new java.io.File(path);
        javax.imageio.ImageIO.write(bf,format,file);
    }
    /**
     * Carrega arquivo de imagem para Foto
     * @param path - path file
     */
    public void loadFoto(String path) {
        this.foto = new javax.swing.ImageIcon(path);
    }
}
