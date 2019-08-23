package cliente;

/**
 * Class ClienteDAO responsável pela 
 * leitura/escrita de objetos Cliente no BD
 *
 * @author JSQLGen
 */
public final class ClienteDAO extends dbaccess.DAO {

    //*****************************************
    //CREATE TABLE
    //*****************************************

    /** createTable - Cria a tabela Cliente no BD
     * @param connection Conexão com BD
     * @throws java.sql.SQLException
     */
    public static void createTable(java.sql.Connection connection) throws java.sql.SQLException {
        String sql = "CREATE TABLE Cliente ("
                   + "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 0, INCREMENT BY 1),"
                   + "nome VARCHAR(30) UNIQUE NOT NULL,"
                   + "cpf VARCHAR(15) NOT NULL,"
                   + "nascimento DATE NOT NULL,"
                   + "telFixo VARCHAR(15) NOT NULL,"
                   + "telCelular VARCHAR(15) NOT NULL,"
                   + "email VARCHAR(30) NOT NULL,"
                   + "foto BLOB NOT NULL,"
                   + "CONSTRAINT PK_Cliente PRIMARY KEY (id)"
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
     * @param clienteSave Cliente a ser armazenado
     * @param statement PreparedStatement contendo SQL
     * @throws java.sql.SQLException
     */
    private static void obj2stmt(Cliente clienteSave, java.sql.PreparedStatement statement) throws java.sql.SQLException {
        statement.setString(1, clienteSave.getNome());
        statement.setString(2, clienteSave.getCpf());
        statement.setDate(3, new java.sql.Date(clienteSave.getNascimento().getTime()));
        statement.setString(4, clienteSave.getTelFixo());
        statement.setString(5, clienteSave.getTelCelular());
        statement.setString(6, clienteSave.getEmail());
        statement.setBlob(7, clienteSave.getFoto("PNG"));
    }

    /** insert - Este método insere no BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param clienteInsert Cliente a ser inserido
     * @throws java.sql.SQLException
     */
    public static void insert(java.sql.Connection connection, Cliente clienteInsert) throws java.sql.SQLException {
        String sql = "INSERT INTO Cliente (nome,cpf,nascimento,telFixo,telCelular,email,foto) "
                   + "VALUES (?,?,?,?,?,?,?)";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        obj2stmt(clienteInsert, statement);
        statement.executeUpdate();
        statement.close();
        sql = "SELECT IDENTITY_VAL_LOCAL() FROM Cliente";
        statement = connection.prepareStatement(sql);
        java.sql.ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            clienteInsert.setId(resultSet.getInt(1));
        }
        statement.close();
    }

    /** update - Este método atualiza no BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param clienteUpdate Cliente a ser atualizado
     * @throws java.sql.SQLException
     */
    public static void update(java.sql.Connection connection, Cliente clienteUpdate) throws java.sql.SQLException {
        String sql = "UPDATE Cliente SET "
                   + "nome = ?,"
                   + "cpf = ?,"
                   + "nascimento = ?,"
                   + "telFixo = ?,"
                   + "telCelular = ?,"
                   + "email = ?,"
                   + "foto = ? "
                   + "WHERE id = ?";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        obj2stmt(clienteUpdate, statement);
        statement.setInt(8, clienteUpdate.getId());
        statement.executeUpdate();
        statement.close();
    }

    /** delete - Este método apaga do BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param clienteDelete Cliente a ser apagado
     * @throws java.sql.SQLException
     */
    public static void delete(java.sql.Connection connection, Cliente clienteDelete) throws java.sql.SQLException {
        String sql = "DELETE FROM Cliente WHERE id = ?";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, clienteDelete.getId());
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
    private static Cliente rs2obj(java.sql.Connection connection, java.sql.ResultSet resultSet) throws java.sql.SQLException {
        Cliente clienteLoad = new Cliente();
        clienteLoad.setId(resultSet.getInt("id"));
        clienteLoad.setNome(resultSet.getString("nome"));
        clienteLoad.setCpf(resultSet.getString("cpf"));
        clienteLoad.setNascimento(resultSet.getDate("nascimento"));
        clienteLoad.setTelFixo(resultSet.getString("telFixo"));
        clienteLoad.setTelCelular(resultSet.getString("telCelular"));
        clienteLoad.setEmail(resultSet.getString("email"));
        try {
            clienteLoad.setFoto(new javax.swing.ImageIcon(javax.imageio.ImageIO.read(resultSet.getBlob("foto").getBinaryStream())));
        } catch (java.io.IOException e) {
            clienteLoad.setFoto(new javax.swing.ImageIcon());
        } catch (NullPointerException e) {
            clienteLoad.setFoto(new javax.swing.ImageIcon());
        }
        return clienteLoad;
    }

    /** load - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param condition Condição WHERE
     * @return objeto Cliente || null caso não encontrar
     * @throws java.sql.SQLException
     */
    private static Cliente load(java.sql.Connection connection, String condition) throws java.sql.SQLException {
        if(!condition.isEmpty()){
            String sql = "SELECT id,nome,cpf,nascimento,telFixo,telCelular,email,foto "
                       + "FROM Cliente "
                       + "WHERE "+condition;
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            Cliente clienteLoad;
            if (resultSet.next()) {
                clienteLoad = rs2obj(connection, resultSet);
            } else {
                clienteLoad = null;
            }
            statement.close();
            return clienteLoad;
        } else {
            return null;
        }
    }

    /** loadList - Carrega lista de objetos Cliente
     * @param connection Conexão com BD
     * @param condition Condição WHERE
     * @return List contendo a tabela
     */
    private static java.util.List<Cliente> loadList(java.sql.Connection connection, String condition) {
        java.util.List<Cliente> list = new java.util.ArrayList<Cliente>();
        try {
            String sql = "SELECT id,nome,cpf,nascimento,telFixo,telCelular,email,foto "
                       + "FROM Cliente "
                       + (condition.isEmpty()?"":"WHERE "+condition);
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente clienteLoad = rs2obj(connection, resultSet);
                list.add(clienteLoad);
            }
            statement.close();
        } catch (java.sql.SQLException sqlex) {
            System.out.println("Falha na leitura do banco de dados !\n"+sqlex.getMessage());
        }
        return list;
    }

    /** loadView - Carrega visão de atributos de objetos Cliente
     * @param connection Conexão com BD
     * @param attributesList Atributos listados
     * @param condition condição WHERE
     * @param order Ordem da lista
     * @return lista de atributo
     */
    private static java.util.List loadView(java.sql.Connection connection, String attributesList, String condition, String order) {
        String sql = "SELECT " + attributesList + " "
                   + "FROM Cliente "
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
     * @param id campo identificador de Cliente
     * @return objeto Cliente || null caso não encontrar
     * @throws java.sql.SQLException
     */
    public static Cliente loadById(java.sql.Connection connection, Integer id) throws java.sql.SQLException {
        return load(connection, "id = "+id);
    }

    /** loadByNome - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param nome campo identificador de Cliente
     * @return objeto Cliente || null caso não encontrar
     * @throws java.sql.SQLException
     */
    public static Cliente loadByNome(java.sql.Connection connection, String nome) throws java.sql.SQLException {
        return load(connection, "nome = '"+nome+"'");
    }

    //*****************************************
    //EXISTS Object BY
    //*****************************************

    /** existsById - Este método verifica a existência de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de Cliente
     * @return true caso exista || false caso não exista
     */
    public static Boolean existsById(java.sql.Connection connection, Integer id) {
        java.util.List<Cliente> l = loadList(connection, "id="+id);
        return !l.isEmpty();
    }

    /** existsByNome - Este método verifica a existência de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param nome campo identificador de Cliente
     * @return true caso exista || false caso não exista
     */
    public static Boolean existsByNome(java.sql.Connection connection, String nome) {
        java.util.List<Cliente> l = loadList(connection, "nome='"+nome+"'");
        return !l.isEmpty();
    }

    //*****************************************
    //GET Unique Attribute BY 
    //*****************************************

    /** getNomeById - Este método carrega o campo de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de Cliente
     * @return nome || null caso não exista
     */
    public static String getNomeById(java.sql.Connection connection, Integer id) {
        java.util.List l = execQuery(connection, "SELECT nome FROM Cliente WHERE id="+id);
        if(!l.isEmpty()){
            return(String)l.get(0);
        } else {
            return null;
        }
    }

    /** getIdByNome - Este método carrega o campo de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param nome campo identificador de Cliente
     * @return id || null caso não exista
     */
    public static Integer getIdByNome(java.sql.Connection connection, String nome) {
        java.util.List l = execQuery(connection, "SELECT id FROM Cliente WHERE nome='"+nome+"'");
        if(!l.isEmpty()){
            return(Integer)l.get(0);
        } else {
            return null;
        }
    }

    //*****************************************
    //LOAD Attribute List
    //*****************************************

    /** loadIdList - Carrega lista de id de objetos Cliente
     * @param connection Conexão com BD
     * @return List contendo Id
     */
    public static java.util.List<String> loadIdList(java.sql.Connection connection) {
        return loadView(connection, "id", "", "id");
    }

    /** loadNomeList - Carrega lista de nome de objetos Cliente
     * @param connection Conexão com BD
     * @return List contendo Nome
     */
    public static java.util.List<String> loadNomeList(java.sql.Connection connection) {
        return loadView(connection, "nome", "", "nome");
    }

    //*****************************************
    //LOAD Object List
    //*****************************************

    /** loadList - Carrega lista de objetos Cliente
     * @param connection Conexão com BD
     * @return List contendo os objetos
     */
    public static java.util.List<Cliente> loadList(java.sql.Connection connection) {
        return loadList(connection, "");
    }

    //*****************************************
    //LOAD Object View
    //*****************************************

    /** loadView - Carrega visão de atributos de objetos Cliente
     * @param connection Conexão com BD
     * @return lista com visão de atributos
     */
    public static java.util.List loadView(java.sql.Connection connection) {
        String sql = "SELECT "
                   + "Cliente.id,"
                   + "Cliente.nome,"
                   + "Cliente.cpf,"
                   + "Cliente.nascimento,"
                   + "Cliente.telFixo,"
                   + "Cliente.telCelular,"
                   + "Cliente.email "
                   + "FROM Cliente ";
        return execQueryF(connection, sql);
    }

}
