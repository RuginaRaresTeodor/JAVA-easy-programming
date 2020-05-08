package Lab11PA.demo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Game {

    private String gameName;
    private String content;
    private String result;
    private String playerNames;

    @Id
    @Column(name = "Game NAME")
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Basic
    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "Result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    @Basic
    @Column (name = "Players")
    public String getPlayerNames() {
        return playerNames;
    }
    public void setPlayerNames(String playerNames) {
        this.playerNames = playerNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(gameName, game.gameName) &&
                Objects.equals(content, game.content) &&
                Objects.equals(result, game.result) &&
                Objects.equals(playerNames, game.playerNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameName, content, result, playerNames);
    }
}


