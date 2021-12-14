package automation.project.controllers;

import automation.project.controllers.dto.GameDto;
import automation.project.domain.Game;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("games")
@CrossOrigin
public class GameController {
  private HashMap<String, Game> games;

  public GameController() {
	  games = new HashMap<String, Game>() {{
      put(UUID.randomUUID().toString(), new Game("Call of Duty: Black Ops Cold War", "Activision - Mohammad Alavi -Treyarch", 2020, "Belico", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Grand Theft Auto V", "Rockstar Games - Rockstar North",2013, "Accin-aventura - Mundo abierto", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Fortnite", "Epic Games - People Can Fly",2017, "Battle royale - Videojuego de disparos en tercera persona - Videojuego de rol de accin - Videojuego sandbox", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Minecraft", "Mojang Studios - Other Ocean Interactive - 4J Studios - Xbox Game Studios", 2009, "Sandbox", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Roblox", "Roblox Corporation", 2012, "Sandbox", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Among Us", "Innersloth", 2018, "Belico", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Garena Free Fire", "111dots Studio", 2017, "Battle royale - Supervivencia - Shooter", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Rocket League", "Psyonix - Panic Button Games", 2015, "Deportes", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Apex Legends", "Respawn Entertainment - Panic Button Games", 2019, "Battle Royale", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Brawl Stars", "Supercell", 2017, "Videojuego de accin", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Fall Guys: Ultimate Knockout", "Mediatonic", 2020, "Battle Royale", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Battlefield 6", "Electronic Arts", 2021, "Belico", "Xbox - PlayStation5 - PC"));
      put(UUID.randomUUID().toString(), new Game("Star Wars: Battlefront", "EA Digital Illusions CE - Criterion Games", 2015, "Belico", "Xbox - PlayStation5 - PC"));
    }};
  }

  @GetMapping("")
  public List<GameDto> getGames() {
    return games.entrySet().stream().map(current -> {
      var id = current.getKey();
      var game = current.getValue();

      return new GameDto(id, game.getName(), game.getDeveloper(), game.getYear(), game.getType(), game.getConsole());
    }).collect(Collectors.toList());
  }

  @DeleteMapping("{id}")
  public void removeGame(@PathVariable("id") String gameId) {
	  games.remove(gameId);
  }

  @PostMapping("")
  public GameDto saveGame(@RequestBody GameDto dto) {
    var id = UUID.randomUUID().toString();

    games.put(id, new Game(dto.getName(), dto.getDeveloper(), dto.getYear(), dto.getType(), dto.getConsole()));

    return new GameDto(id, dto.getName(), dto.getDeveloper(), dto.getYear(), dto.getType(), dto.getConsole());
  }

  @PutMapping("{id}")
  public GameDto updateGame(@PathVariable("id") String gameId, @RequestBody GameDto dto) {
	  games.put(gameId, new Game(dto.getName(), dto.getDeveloper(), dto.getYear(), dto.getType(), dto.getConsole()));

    return new GameDto(gameId, dto.getName(), dto.getDeveloper(), dto.getYear(), dto.getType(), dto.getConsole());
  }
}
