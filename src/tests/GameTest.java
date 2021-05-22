package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import automation.project.domain.Game;

class GameTest {

	private Game game;
	
	@Test
	void getTests() {
		game = new Game("MS", "KZ", 2000, "AAA", "PC");
		assertAll("All get methods sholud return the correct data of the game",
			() -> assertEquals("MS", game.getName()),
			() -> assertEquals("KZ", game.getDeveloper()),
			() -> assertEquals(2000, game.getYear()),
			() -> assertEquals("AAA", game.getType()),
			() -> assertEquals("PC", game.getConsole())
		);
	}
	
	@Test
	void setTests() {
		game = new Game("MS", "KZ", 2000, "AAA", "PC");
		game.setName("Borderlands 3");
		game.setDeveloper("GearBox Software");
		game.setYear(2019);
		game.setType("Shooter");
		game.setConsole("PlayStation 4, Xbox One, PlayStation 5, Project Scarlett, Google Stadia, Microsoft Windows, Mac OS");
		assertAll("All get methods sholud return the correct data of the game then of set new data",
			() -> assertEquals("Borderlands 3", game.getName()),
			() -> assertEquals("GearBox Software", game.getDeveloper()),
			() -> assertEquals(2019, game.getYear()),
			() -> assertEquals("Shooter", game.getType()),
			() -> assertEquals("PlayStation 4, Xbox One, PlayStation 5, Project Scarlett, Google Stadia, Microsoft Windows, Mac OS", game.getConsole())
		);
	}

}
