package automation.practice.controllers.dto;

import lombok.Getter;
import lombok.Setter;

public class GameDto {
	
    public GameDto() {
	}

    public GameDto(String id, String name, String developer, int year, String type, String console) {
		super();
		this.id = id;
		this.name = name;
		this.developer = developer;
		this.year = year;
		this.type = type;
		this.console = console;
	}


	@Getter
    @Setter
    private String id;

    /**
     * This attribute refers to the name of the game
     */
    @Getter
    @Setter
    private String name;

    /**
     * This attribute refers to the name of the videogame developer
     */
    @Getter
    @Setter
    private String developer;
    
    /**
     * This attribute refers to the year of release
     */
    @Getter
    @Setter
    private int year;
    
    /**
     * This attribute refers to the type of genre to which the video game belongs.
     */
    @Getter
    @Setter
    private String type;
    
    /**
     * This attribute refers to the consoles on which the game can be played
     */
    @Getter
    @Setter
    private String console;
    
    /**
     * This attribute is the image of the video game.
     */
    @Getter
    @Setter
    private String img;
}
