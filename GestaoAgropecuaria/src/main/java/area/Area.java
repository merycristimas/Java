package area;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Area {

    private static String[] TIPO = {
        "A.P.P.", "Talhoes", "Benfeitorias", "Pasto"
    };
    private static String[] UNIDADE = {
        "hectare", "m²", "alqueire", "are"
    };

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50, unique = true)
    private String nome;

    private Integer tipo;

    private Float area;

    private Integer unidade;
    
    

    public Area() {
        this.id = null;
        this.nome = "";
        this.tipo = 0;
        this.area = 0f;
        this.unidade = 0;
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
     * @return the tipo
     */
    public Integer getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the area
     */
    public Float getArea() {
        return area;
    }

    /**
     * @param formato
     * @return the area
     */
    public String getArea(String formato) {
        return new DecimalFormat(formato).format(area);
    }

    /**
     * @param area the area to set
     */
    public void setArea(Float area) {
        this.area = area;
    }

    /**
     * @param formato
     * @param area the nascimento to set
     */
    public void setArea(String formato, String area) {
        this.area = (Float) new DecimalFormat(formato).parse(area, new ParsePosition(0));
    }

    /**
     * @return the unidade
     */
    public Integer getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }
}
