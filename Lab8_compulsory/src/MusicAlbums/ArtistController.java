package MusicAlbums;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
    Statement statement = Database.get_statement();
    public void create(String name, String country){
        try { statement.executeUpdate("Insert into artists (name,country) VALUES (\'"+name+"\',\'"+country+"\')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public String findByName(String name){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            ResultSet resultSet = statement.executeQuery("Select * from artists where name=\'"+name+"\'");
            while(resultSet.next()){
                stringBuilder.append(resultSet.getInt(1)).append(" ").append(resultSet.getString(2)).append(" ").append(resultSet.getString(3)).append("\n");
            }
            return stringBuilder.toString();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
