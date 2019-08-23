package cliente;
/**
 *
 * @author JSQLGen
 */
public final class Cliente {


    /** Atributos */
    private Integer id;
    private String nome;
    private String cpf;
    private java.util.Date nascimento;
    private String telFixo;
    private String telCelular;
    private String email;
    private javax.swing.ImageIcon foto;

    /** Construtor */
    public Cliente() {
        id = null;
        nome = null;
        cpf = "";
        setNascimentoF("dd/MM/yyyy","01/01/0001");
        telFixo = "";
        telCelular = "";
        email = "";
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
     * @return cpf
     */
    public String getCpf() { return cpf; }
    /**
     * @param cpf Cpf to set
     */
    public void setCpf(String cpf) { this.cpf = (cpf.length()>15?cpf.substring(0,15):cpf).replace('\'','`'); }

    /**
     * @return Nascimento
     */
    public java.util.Date getNascimento() { return nascimento; }
    /**
     * @param pattern Formato de Nascimento. Ex "yyyy-MM-dd" ou "dd/MM/yyyy"
     * @return Nascimento Formatado
     */
    public String getNascimentoF(String pattern) { return new java.text.SimpleDateFormat(pattern).format(nascimento); }
    /**
     * @param nascimento Nascimento to set
     */
    public void setNascimento(java.util.Date nascimento) { this.nascimento = nascimento; }
    /**
     * @param pattern Formato de Nascimento. Ex "yyyy-MM-dd" ou "dd/MM/yyyy"
     * @param nascimento - String Nascimento to set
     */
    public void setNascimentoF(String pattern, String nascimento) { this.nascimento = new java.text.SimpleDateFormat(pattern).parse(nascimento, new java.text.ParsePosition(0)); }

    /**
     * @return telFixo
     */
    public String getTelFixo() { return telFixo; }
    /**
     * @param telFixo TelFixo to set
     */
    public void setTelFixo(String telFixo) { this.telFixo = (telFixo.length()>15?telFixo.substring(0,15):telFixo).replace('\'','`'); }

    /**
     * @return telCelular
     */
    public String getTelCelular() { return telCelular; }
    /**
     * @param telCelular TelCelular to set
     */
    public void setTelCelular(String telCelular) { this.telCelular = (telCelular.length()>15?telCelular.substring(0,15):telCelular).replace('\'','`'); }

    /**
     * @return email
     */
    public String getEmail() { return email; }
    /**
     * @param email Email to set
     */
    public void setEmail(String email) { this.email = (email.length()>30?email.substring(0,30):email).replace('\'','`'); }

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
