package ru.geekbrains.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	SpriteBatch batchWallpaper;
	Texture imgWallpaprer;
	Texture img;
	
	@Override
	public void create () {
		batchWallpaper = new SpriteBatch();
		imgWallpaprer = new Texture("grass.jpg");
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batchWallpaper.begin();
		batchWallpaper.draw(imgWallpaprer,0,0);
		batchWallpaper.end();
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
