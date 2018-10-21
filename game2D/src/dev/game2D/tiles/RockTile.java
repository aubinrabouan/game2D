package dev.game2D.tiles;

import dev.game2D.gjx.Assets;

import java.awt.image.BufferedImage;

public class RockTile extends Tile {
    public RockTile(int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
