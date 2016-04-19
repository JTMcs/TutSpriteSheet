package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch sbAnim;
	Texture txtrSheet;
	TextureRegion[] trAnimFrames;
	Animation aniJoel;
    float fTime;
	
	@Override
	public void create () {
		sbAnim = new SpriteBatch();
		txtrSheet = new Texture("spritesheet.png");
		TextureRegion[][] trAnimTemp = TextureRegion.split(txtrSheet, 256, 256);
		trAnimFrames = new TextureRegion[4];
		int index = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				trAnimFrames[index++] = trAnimTemp[j][i];
			}
		}
		aniJoel = new Animation(1f/3f, trAnimFrames);
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 0, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        fTime += Gdx.graphics.getDeltaTime();
		sbAnim.begin();
		sbAnim.draw(aniJoel.getKeyFrame(fTime, true), Gdx.graphics.getWidth()/2 -
                txtrSheet.getWidth() / 4, Gdx.graphics.getHeight()/2 - txtrSheet.getHeight() / 4);
		sbAnim.end();
	}
}
