package MusicAlbums;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    Statement statement = Database.get_statement();
    public void create(String name, int artistId, int releaseYear){
        try { statement.executeUpdate("Insert into albums (name,artist_id,release_year) VALUES (\'" + name + "\',\'" + artistId +"\',\'" + releaseYear +"\')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public String findByArtist(int artistId){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            ResultSet resultSet = statement.executeQuery("Select * from albums where artist_id="+artistId);
            while(resultSet.next()){
                stringBuilder.append(resultSet.getInt(1)).append(" ").append(resultSet.getString(2)).append(" ").append(resultSet.getInt(3)).append(" ").append(resultSet.getInt(4)).append("\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
