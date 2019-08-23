package produto;

/**
 * Class ProdutoDAO responsável pela 
 * leitura/escrita de objetos Produto no BD
 *
 * @author JSQLGen
 */
public final class ProdutoDAO extends dbaccess.DAO {

    //*****************************************
    //CREATE TABLE
    //*****************************************

    /** createTable - Cria a tabela Produto no BD
     * @param connection Conexão com BD
     * @throws java.sql.SQLException
     */
    public static void createTable(java.sql.Connection connection) throws java.sql.SQLException {
        String sql = "CREATE TABLE Produto ("
                   + "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 0, INCREMENT BY 1),"
                   + "nome VARCHAR(30) UNIQUE NOT NULL,"
                   + "codBarras VARCHAR(25) NOT NULL,"
                   + "categoria INT NOT NULL,"
                   + "quantidade INT NOT NULL,"
                   + "valorCusto FLOAT NOT NULL,"
                   + "valorVenda FLOAT NOT NULL,"
                   + "foto BLOB NOT NULL,"
                   + "CONSTRAINT PK_Produto PRIMARY KEY (id)"
                   + ")";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
    }

    //*****************************************
    //UPDATE
    //*****************************************

    /** obj2stmt - Transfere o Objeto para o PreparedStatement.
     * @param connection Conexão com BD
     * @param produtoSave Produto a ser armazenado
     * @param statement PreparedStatement contendo SQL
     * @throws java.sql.SQLException
     */
    private static void obj2stmt(Produto produtoSave, java.sql.PreparedStatement statement) throws java.sql.SQLException {
        statement.setString(1, produtoSave.getNome());
        statement.setString(2, produtoSave.getCodBarras());
        statement.setInt(3, produtoSave.getCategoria());
        statement.setInt(4, produtoSave.getQuantidade());
        statement.setFloat(5, produtoSave.getValorCusto());
        statement.setFloat(6, produtoSave.getValorVenda());
        statement.setBlob(7, produtoSave.getFoto("PNG"));
    }

    /** insert - Este método insere no BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param produtoInsert Produto a ser inserido
     * @throws java.sql.SQLException
     */
    public static void insert(java.sql.Connection connection, Produto produtoInsert) throws java.sql.SQLException {
        String sql = "INSERT INTO Produto (nome,codBarras,categoria,quantidade,valorCusto,valorVenda,foto) "
                   + "VALUES (?,?,?,?,?,?,?)";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        obj2stmt(produtoInsert, statement);
        statement.executeUpdate();
        statement.close();
        sql = "SELECT IDENTITY_VAL_LOCAL() FROM Produto";
        statement = connection.prepareStatement(sql);
        java.sql.ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            produtoInsert.setId(resultSet.getInt(1));
        }
        statement.close();
    }

    /** update - Este método atualiza no BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param produtoUpdate Produto a ser atualizado
     * @throws java.sql.SQLException
     */
    public static void update(java.sql.Connection connection, Produto produtoUpdate) throws java.sql.SQLException {
        String sql = "UPDATE Produto SET "
                   + "nome = ?,"
                   + "codBarras = ?,"
                   + "categoria = ?,"
                   + "quantidade = ?,"
                   + "valorCusto = ?,"
                   + "valorVenda = ?,"
                   + "foto = ? "
                   + "WHERE id = ?";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        obj2stmt(produtoUpdate, statement);
        statement.setInt(8, produtoUpdate.getId());
        statement.executeUpdate();
        statement.close();
    }

    /** delete - Este método apaga do BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param produtoDelete Produto a ser apagado
     * @throws java.sql.SQLException
     */
    public static void delete(java.sql.Connection connection, Produto produtoDelete) throws java.sql.SQLException {
        String sql = "DELETE FROM Produto WHERE id = ?";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, produtoDelete.getId());
        statement.executeUpdate();
        statement.close();
    }

    //*****************************************
    //QUERY private
    //*****************************************

    /**
     * rs2obj - Transfere do ResultSet da Query SQL para um novo objeto
     * @param connection
     * @param resultSet to parse
     * @return novo objeto
     * @throws java.sql.SQLException 
     */
    private static Produto rs2obj(java.sql.Connection connection, java.sql.ResultSet resultSet) throws java.sql.SQLException {
        Produto produtoLoad = new Produto();
        produtoLoad.setId(resultSet.getInt("id"));
        produtoLoad.setNome(resultSet.getString("nome"));
        produtoLoad.setCodBarras(resultSet.getString("codBarras"));
        produtoLoad.setCategoria(resultSet.getInt("categoria"));
        produtoLoad.setQuantidade(resultSet.getInt("quantidade"));
        produtoLoad.setValorCusto(resultSet.getFloat("valorCusto"));
        produtoLoad.setValorVenda(resultSet.getFloat("valorVenda"));
        try {
            produtoLoad.setFoto(new javax.swing.ImageIcon(javax.imageio.ImageIO.read(resultSet.getBlob("foto").getBinaryStream())));
        } catch (java.io.IOException e) {
            produtoLoad.setFoto(new javax.swing.ImageIcon());
        } catch (NullPointerException e) {
            produtoLoad.setFoto(new javax.swing.ImageIcon());
        }
        return produtoLoad;
    }

    /** load - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param condition Condição WHERE
     * @return objeto Produto || null caso não encontrar
     * @throws java.sql.SQLException
     */
    private static Produto load(java.sql.Connection connection, String condition) throws java.sql.SQLException {
        if(!condition.isEmpty()){
            String sql = "SELECT id,nome,codBarras,categoria,quantidade,valorCusto,valorVenda,foto "
                       + "FROM Produto "
                       + "WHERE "+condition;
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            Produto produtoLoad;
            if (resultSet.next()) {
                produtoLoad = rs2obj(connection, resultSet);
            } else {
                produtoLoad = null;
            }
            statement.close();
            return produtoLoad;
        } else {
            return null;
        }
    }

    /** loadList - Carrega lista de objetos Produto
     * @param connection Conexão com BD
     * @param condition Condição WHERE
     * @return List contendo a tabela
     */
    private static java.util.List<Produto> loadList(java.sql.Connection connection, String condition) {
        java.util.List<Produto> list = new java.util.ArrayList<Produto>();
        try {
            String sql = "SELECT id,nome,codBarras,categoria,quantidade,valorCusto,valorVenda,foto "
                       + "FROM Produto "
                       + (condition.isEmpty()?"":"WHERE "+condition);
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Produto produtoLoad = rs2obj(connection, resultSet);
                list.add(produtoLoad);
            }
            statement.close();
        } catch (java.sql.SQLException sqlex) {
            System.out.println("Falha na leitura do banco de dados !\n"+sqlex.getMessage());
        }
        return list;
    }

    /** loadView - Carrega visão de atributos de objetos Produto
     * @param connection Conexão com BD
     * @param attributesList Atributos listados
     * @param condition condição WHERE
     * @param order Ordem da lista
     * @return lista de atributo
     */
    private static java.util.List loadView(java.sql.Connection connection, String attributesList, String condition, String order) {
        String sql = "SELECT " + attributesList + " "
                   + "FROM Produto "
                   + (condition.isEmpty() ? "" : "WHERE " + condition)
                   + (order.isEmpty() ? "" : "ORDER BY " + order);
        return execQueryF(connection, sql);
    }

    //*****************************************
    //QUERY public
    //*****************************************

    //*****************************************
    //LOAD Object BY
    //*****************************************

    /** loadById - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de Produto
     * @return objeto Produto || null caso não encontrar
     * @throws java.sql.SQLException
     */
    public static Produto loadById(java.sql.Connection connection, Integer id) throws java.sql.SQLException {
        return load(connection, "id = "+id);
    }

    /** loadByNome - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param nome campo identificador de Produto
     * @return objeto Produto || null caso não encontrar
     * @throws java.sql.SQLException
     */
    public static Produto loadByNome(java.sql.Connection connection, String nome) throws java.sql.SQLException {
        return load(connection, "nome = '"+nome+"'");
    }

    //*****************************************
    //EXISTS Object BY
    //*****************************************

    /** existsById - Este método verifica a existência de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de Produto
     * @return true caso exista || false caso não exista
     */
    public static Boolean existsById(java.sql.Connection connection, Integer id) {
        java.util.List<Produto> l = loadList(connection, "id="+id);
        return !l.isEmpty();
    }

    /** existsByNome - Este método verifica a existência de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param nome campo identificador de Produto
     * @return true caso exista || false caso não exista
     */
    public static Boolean existsByNome(java.sql.Connection connection, String nome) {
        java.util.List<Produto> l = loadList(connection, "nome='"+nome+"'");
        return !l.isEmpty();
    }

    //*****************************************
    //GET Unique Attribute BY 
    //*****************************************

    /** getNomeById - Este método carrega o campo de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de Produto
     * @return nome || null caso não exista
     */
    public static String getNomeById(java.sql.Connection connection, Integer id) {
        java.util.List l = execQuery(connection, "SELECT nome FROM Produto WHERE id="+id);
        if(!l.isEmpty()){
            return(String)l.get(0);
        } else {
            return null;
        }
    }

    /** getIdByNome - Este método carrega o campo de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param nome campo identificador de Produto
     * @return id || null caso não exista
     */
    public static Integer getIdByNome(java.sql.Connection connection, String nome) {
        java.util.List l = execQuery(connection, "SELECT id FROM Produto WHERE nome='"+nome+"'");
        if(!l.isEmpty()){
            return(Integer)l.get(0);
        } else {
            return null;
        }
    }

    //*****************************************
    //LOAD Attribute List
    //*****************************************

    /** loadIdList - Carrega lista de id de objetos Produto
     * @param connection Conexão com BD
     * @return List contendo Id
     */
    public static java.util.List<String> loadIdList(java.sql.Connection connection) {
        return loadView(connection, "id", "", "id");
    }

    /** loadNomeList - Carrega lista de nome de objetos Produto
     * @param connection Conexão com BD
     * @return List contendo Nome
     */
    public static java.util.List<String> loadNomeList(java.sql.Connection connection) {
        return loadView(connection, "nome", "", "nome");
    }

    //*****************************************
    //LOAD Object List
    //*****************************************

    /** loadList - Carrega lista de objetos Produto
     * @param connection Conexão com BD
     * @return List contendo os objetos
     */
    public static java.util.List<Produto> loadList(java.sql.Connection connection) {
        return loadList(connection, "");
    }

    //*****************************************
    //LOAD Object View
    //*****************************************

    /** loadView - Carrega visão de atributos de objetos Produto
     * @param connection Conexão com BD
     * @return lista com visão de atributos
     */
    public static java.util.List loadView(java.sql.Connection connection) {
        String sql = "SELECT "
                   + "Produto.id,"
                   + "Produto.nome,"
                   + "Produto.codBarras,"
                   + "Produto.categoria,"
                   + "Produto.quantidade,"
                   + "Produto.valorCusto,"
                   + "Produto.valorVenda "
                   + "FROM Produto ";
        return execQueryF(connection, sql);
    }

}
