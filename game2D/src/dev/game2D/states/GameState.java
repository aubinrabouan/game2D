package dev.game2D.states;

import dev.game2D.Game;
import dev.game2D.entity.creatures.Player;
import dev.game2D.gjx.Assets;

import java.awt.*;

public class GameState extends State {

    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game,100,100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);

    }
}
