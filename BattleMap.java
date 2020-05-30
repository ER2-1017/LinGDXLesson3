package com.dune.game.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class  BattleMap {
    public static final int COLUMNS = 16;
    public static final int ROWS = 9;
    private TextureRegion grassTexture;
    private TextureRegion resourceTexture;
    private int[][] data;
    public static final int CELLSIZE = 80;


    public BattleMap() {
        this.grassTexture = Assets.getInstance().getAtlas().findRegion("grass");
        this.resourceTexture = Assets.getInstance().getAtlas().findRegion("bullet");
        this.data = new int[COLUMNS][ROWS];
        for (int i = 0; i<COLUMNS; i++){
            for (int j = 0; j<ROWS; j++){
                if (MathUtils.random() < 0.1f){
                    data[i][j] = 1;
                }
            }
        }
    }

    public boolean checkPickUp(Tank pickUp){
        if (data[pickUp.getCellX()][pickUp.getCellY()]==1){
            data[pickUp.getCellX()][pickUp.getCellY()] = 0;
            return true;
        }
        return false;
    }





    public void render(SpriteBatch batch) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                batch.draw(grassTexture, i * 80, j * 80);
                if (data [i][j]==1){
                    batch.draw(resourceTexture, i*80, j*80);
                }
            }
        }
    }
}
