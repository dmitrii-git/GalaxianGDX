package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

import org.w3c.dom.css.Rect;

import ru.geekbrains.stargame.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    public static final float SPEED = 1.f;
    private Texture img;
    private Texture imgWallpaper;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 gravity;
    private Vector2 touch;
    private Vector2 velocity;
    private Vector2 position;
    private Vector2 temp;



    private Rect screenBounds;
    private Rect worldBounds;
    private Rect glBounds;

    private Matrix4 worldToGl;

    private Matrix3 screenToWorld;

    @Override
    public void show() {
        super.show();
        imgWallpaper = new Texture("grass.jpg");
        img = new Texture("badlogic.jpg");
        velocity = new Vector2(0,0);
        position = new Vector2(0,0);
        pos = new Vector2();
        v = new Vector2(1, 1);
        gravity = new Vector2(0, -0.005f);
        touch = new Vector2();
    }

    @Override
    public void render(float delta) {


        super.render(delta);
        //pos.add(v);
        //v.add(gravity);
        temp.set(touch);
        if (temp.sub(position).len() > SPEED){
            position.add(velocity);
        }else{
            position.set(touch);
            velocity.setZero();
        }
        batch.begin();
        batch.draw(imgWallpaper, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    @Override
    public void dispose() {
        imgWallpaper.dispose();
        img.dispose();
        super.dispose();
    }

//   @Override
//   public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//       touch.set(screenX, Gdx.graphics.getHeight() - screenY);
//       System.out.println("touchDown touch.x = " + touch.x + " touch.y = " + touch.y);
//       pos.set(touch);
//       return super.touchDown(screenX, screenY, pointer, button);
//   }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        velocity.set(touch.cpy().sub(position).setLength(SPEED));
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);
        return false;
    }
}
