package venda;

/**
 * Class VendaDAO responsável pela 
 * leitura/escrita de objetos Venda no BD
 *
 * @author JSQLGen
 */
public final class VendaDAO extends dbaccess.DAO {

    //*****************************************
    //CREATE TABLE
    //*****************************************

    /** createTable - Cria a tabela Venda no BD
     * @param connection Conexão com BD
     * @throws java.sql.SQLException
     */
    public static void createTable(java.sql.Connection connection) throws java.sql.SQLException {
        String sql = "CREATE TABLE Venda ("
                   + "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
                   + "data DATE NOT NULL,"
                   + "cliente INT NOT NULL,"
                   + "valor FLOAT NOT NULL,"
                   + "CONSTRAINT PK_Venda PRIMARY KEY (id),"
                   + "CONSTRAINT FKA_Venda_Cliente FOREIGN KEY (cliente) REFERENCES Cliente ON DELETE CASCADE"
                   + ")";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();

        sql = "CREATE INDEX IDX_Venda_data ON Venda (data)";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        statement.close();

        venda.vendaitem.VendaItemDAO.createTable(connection);
    }

    //*****************************************
    //UPDATE
    //*****************************************

    /** obj2stmt - Transfere o Objeto para o PreparedStatement.
     * @param connection Conexão com BD
     * @param vendaSave Venda a ser armazenado
     * @param statement PreparedStatement contendo SQL
     * @throws java.sql.SQLException
     */
    private static void obj2stmt(Venda vendaSave, java.sql.PreparedStatement statement) throws java.sql.SQLException {
        statement.setDate(1, new java.sql.Date(vendaSave.getData().getTime()));
        statement.setInt(2, vendaSave.getCliente().getId());
        statement.setFloat(3, vendaSave.getValor());
    }

    /** insert - Este método insere no BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param vendaInsert Venda a ser inserido
     * @throws java.sql.SQLException
     */
    public static void insert(java.sql.Connection connection, Venda vendaInsert) throws java.sql.SQLException {
        String sql = "INSERT INTO Venda (data,cliente,valor) "
                   + "VALUES (?,?,?)";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        obj2stmt(vendaInsert, statement);
        statement.executeUpdate();
        statement.close();
        sql = "SELECT IDENTITY_VAL_LOCAL() FROM Venda";
        statement = connection.prepareStatement(sql);
        java.sql.ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            vendaInsert.setId(resultSet.getInt(1));
        }
        statement.close();
        for (venda.vendaitem.VendaItem vendaitemInsert : vendaInsert.getItens()) {
            venda.vendaitem.VendaItemDAO.insert(connection, vendaitemInsert, vendaInsert);
        }
    }

    /** update - Este método atualiza no BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param vendaUpdate Venda a ser atualizado
     * @throws java.sql.SQLException
     */
    public static void update(java.sql.Connection connection, Venda vendaUpdate) throws java.sql.SQLException {
        String sql = "UPDATE Venda SET "
                   + "data = ?,"
                   + "cliente = ?,"
                   + "valor = ? "
                   + "WHERE id = ?";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        obj2stmt(vendaUpdate, statement);
        statement.setInt(4, vendaUpdate.getId());
        statement.executeUpdate();
        statement.close();
    }

    /** delete - Este método apaga do BD o objeto passado como parâmetro.
     * @param connection Conexão com BD
     * @param vendaDelete Venda a ser apagado
     * @throws java.sql.SQLException
     */
    public static void delete(java.sql.Connection connection, Venda vendaDelete) throws java.sql.SQLException {
        String sql = "DELETE FROM Venda WHERE id = ?";
        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, vendaDelete.getId());
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
    private static Venda rs2obj(java.sql.Connection connection, java.sql.ResultSet resultSet) throws java.sql.SQLException {
        Venda vendaLoad = new Venda();
        vendaLoad.setId(resultSet.getInt("id"));
        vendaLoad.setData(resultSet.getDate("data"));
        try {
            vendaLoad.setCliente(cliente.ClienteDAO.loadById(connection, resultSet.getInt("cliente")));
        } catch (java.sql.SQLException e) {
            vendaLoad.setCliente(new cliente.Cliente());
        }
        vendaLoad.setValor(resultSet.getFloat("valor"));
        vendaLoad.setItens(venda.vendaitem.VendaItemDAO.loadList(connection, vendaLoad));
        return vendaLoad;
    }

    /** load - Este método carrega o objeto com o seu identificador
     * @param connection Conexão com BD
     * @param condition Condição WHERE
     * @return objeto Venda || null caso não encontrar
     * @throws java.sql.SQLException
     */
    private static Venda load(java.sql.Connection connection, String condition) throws java.sql.SQLException {
        if(!condition.isEmpty()){
            String sql = "SELECT id,data,cliente,valor "
                       + "FROM Venda "
                       + "WHERE "+condition;
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            Venda vendaLoad;
            if (resultSet.next()) {
                vendaLoad = rs2obj(connection, resultSet);
            } else {
                vendaLoad = null;
            }
            statement.close();
            return vendaLoad;
        } else {
            return null;
        }
    }

    /** loadList - Carrega lista de objetos Venda
     * @param connection Conexão com BD
     * @param condition Condição WHERE
     * @return List contendo a tabela
     */
    private static java.util.List<Venda> loadList(java.sql.Connection connection, String condition) {
        java.util.List<Venda> list = new java.util.ArrayList<Venda>();
        try {
            String sql = "SELECT id,data,cliente,valor "
                       + "FROM Venda "
                       + (condition.isEmpty()?"":"WHERE "+condition);
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Venda vendaLoad = rs2obj(connection, resultSet);
                list.add(vendaLoad);
            }
            statement.close();
        } catch (java.sql.SQLException sqlex) {
            System.out.println("Falha na leitura do banco de dados !\n"+sqlex.getMessage());
        }
        return list;
    }

    /** loadView - Carrega visão de atributos de objetos Venda
     * @param connection Conexão com BD
     * @param attributesList Atributos listados
     * @param condition condição WHERE
     * @param order Ordem da lista
     * @return lista de atributo
     */
    private static java.util.List loadView(java.sql.Connection connection, String attributesList, String condition, String order) {
        String sql = "SELECT " + attributesList + " "
                   + "FROM Venda "
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
     * @param id campo identificador de Venda
     * @return objeto Venda || null caso não encontrar
     * @throws java.sql.SQLException
     */
    public static Venda loadById(java.sql.Connection connection, Integer id) throws java.sql.SQLException {
        return load(connection, "id = "+id);
    }

    //*****************************************
    //EXISTS Object BY
    //*****************************************

    /** existsById - Este método verifica a existência de um objeto pelo o seu identificador
     * @param connection Conexão com BD
     * @param id campo identificador de Venda
     * @return true caso exista || false caso não exista
     */
    public static Boolean existsById(java.sql.Connection connection, Integer id) {
        java.util.List<Venda> l = loadList(connection, "id="+id);
        return !l.isEmpty();
    }

    //*****************************************
    //LOAD Attribute List
    //*****************************************

    /** loadIdList - Carrega lista de id de objetos Venda
     * @param connection Conexão com BD
     * @return List contendo Id
     */
    public static java.util.List<String> loadIdList(java.sql.Connection connection) {
        return loadView(connection, "id", "", "id");
    }

    //*****************************************
    //LOAD Object List
    //*****************************************

    /** loadList - Carrega lista de objetos Venda
     * @param connection Conexão com BD
     * @return List contendo os objetos
     */
    public static java.util.List<Venda> loadList(java.sql.Connection connection) {
        return loadList(connection, "");
    }

    //*****************************************
    //LOAD Object View
    //*****************************************

    /** loadView - Carrega visão de atributos de objetos Venda
     * @param connection Conexão com BD
     * @return lista com visão de atributos
     */
    public static java.util.List loadView(java.sql.Connection connection) {
        String sql = "SELECT "
                   + "Venda.id,"
                   + "Venda.data,"
                   + "Cliente.nome,"
                   + "Venda.valor "
                   + "FROM Venda, Cliente "
                   + "WHERE Venda.cliente = Cliente.id ";
        return execQueryF(connection, sql);
    }

}
