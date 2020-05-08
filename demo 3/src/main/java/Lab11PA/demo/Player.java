package Lab11PA.demo;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Player {
    private int id;
    private String playerName;
    private String gameName;
    private Integer playerScore;

    @Id
    @Column(name = "P. ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "P. Name")
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    @Basic
    @Column(name = "Game Name")
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    @Basic
    @Column(name = "Score")
    public Integer getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(Integer playerScore) {
        this.playerScore = playerScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName) &&
                Objects.equals(gameName, player.gameName) &&
                Objects.equals(playerScore, player.playerScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, gameName, playerScore);
    }
}

