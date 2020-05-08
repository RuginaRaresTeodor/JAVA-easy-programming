package Lab11PA.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//https://youtu.be/MaI0_XdpdP8    INFO from here 80%
//https://www.baeldung.com/spring-requestmapping INFO from here
@Controller
@RequestMapping(value = "/getMp", method = RequestMethod.GET)
public class ControllerProb {
    @Autowired
    private AllPlayers allPlayers;
    @Autowired
    private AllGames allGames;
    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<Player> getAllPlayers() {
        return allPlayers.findAll();
    }

    @RequestMapping(value = "/addPlayer", method = RequestMethod.POST)
    public ResponseEntity<String>
    addPlayer(@RequestParam String playerName) {
        Player player = new Player();
        player.setPlayerName(playerName);
        allPlayers.save(player);
        return new ResponseEntity<>(
                "Player added", HttpStatus.CREATED);
    }

    @RequestMapping(value ="/modifyPlayer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String>
    modifyPlayer(@PathVariable int id, @RequestParam String name) {
        Optional<Player> optionalPlayer = allPlayers.findById(id);
        if (optionalPlayer == null) {
            return new ResponseEntity<>(
                    "Player N/A", HttpStatus.NOT_FOUND);
        }
        Player player = optionalPlayer.get();
        player.setPlayerName(name);
        allPlayers.save(player);
        return
                new ResponseEntity<>(
                "Player name modified", HttpStatus.OK);
    }

    @RequestMapping(value="/deletePlayer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String>
    deletePlayer(@PathVariable int id)
    {
        Optional<Player> optionalPlayer = allPlayers.findById(id);
        if (optionalPlayer == null) {
            return new ResponseEntity<>(
                    "Player N/A", HttpStatus.GONE);
        }
        Player player = optionalPlayer.get();
        allPlayers.delete(player);
        return
                new ResponseEntity<>("Player deleted from DBA", HttpStatus.OK);
    }
}
