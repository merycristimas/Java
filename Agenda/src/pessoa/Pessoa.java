package pessoa;
/**
 *
 * @author JSQLGen
 */
public final class Pessoa {

    /** Atributos estaticos */
    public static String[] GENERO = {
        "-Selecione-",
        "MASCULINO",
        "FEMININO"
    };

    /** Atributos */
    private Integer id;
    private String nome;
    private java.util.Date nascimento;
    private String genero;
    private String email;
    private String celular;
    private String usuario;
    private String senha;

    /** Construtor */
    public Pessoa() {
        id = null;
        nome = null;
        setNascimentoF("dd/MM/yyyy","01/01/0001");
        genero = "";
        email = "";
        celular = "";
        usuario = null;
        senha = "";
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
    public void setNome(String nome) { this.nome = (nome.length()>40?nome.substring(0,40):nome).replace('\'','`'); }

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
     * @return the genero
     */
    public String getGenero() { return genero; }
    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) { this.genero = genero; }

    /**
     * @return email
     */
    public String getEmail() { return email; }
    /**
     * @param email Email to set
     */
    public void setEmail(String email) { this.email = (email.length()>60?email.substring(0,60):email).replace('\'','`'); }

    /**
     * @return celular
     */
    public String getCelular() { return celular; }
    /**
     * @param celular Celular to set
     */
    public void setCelular(String celular) { this.celular = (celular.length()>15?celular.substring(0,15):celular).replace('\'','`'); }

    /**
     * @return usuario
     */
    public String getUsuario() { return usuario; }
    /**
     * @param usuario Usuario to set
     */
    public void setUsuario(String usuario) { this.usuario = (usuario.length()>20?usuario.substring(0,20):usuario).replace('\'','`'); }

    /**
     * @return senha
     */
    public String getSenha() { return senha; }
    /**
     * @param senha Senha to set
     */
    public void setSenha(String senha) { this.senha = (senha.length()>20?senha.substring(0,20):senha).replace('\'','`'); }
}
