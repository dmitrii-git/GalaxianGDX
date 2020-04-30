package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.stargame.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture imgWallpaper;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 gravity;
    private Vector2 touch;

    @Override
    public void show() {
        super.show();
        imgWallpaper = new Texture("grass.jpg");
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        v = new Vector2(1, 1);
        gravity = new Vector2(0, -0.005f);
        touch = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        pos.add(v);
        v.add(gravity);
        batchWallpaper.begin();
        batchWallpaper.draw(imgWallpaper,0,0);
        batchWallpaper.end();
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    @Override
    public void dispose() {
        imgWallpaper.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("touchDown touch.x = " + touch.x + " touch.y = " + touch.y);
        pos.set(touch);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
