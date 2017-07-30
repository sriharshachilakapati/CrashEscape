package com.shc.ld39.crashescape;

import com.shc.ld39.crashescape.entities.Background;
import com.shc.ld39.crashescape.entities.Copter;
import com.shc.silenceengine.core.GameState;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.graphics.SceneRenderSystem;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.graphics.cameras.OrthoCam;
import com.shc.silenceengine.graphics.opengl.GLContext;
import com.shc.silenceengine.scene.Entity;
import com.shc.silenceengine.scene.Scene;
import com.shc.silenceengine.scene.components.SpriteComponent;

public class PlayState extends GameState
{
	private Scene scene;
	private OrthoCam cam;

	@Override
	public void onEnter()
	{
		scene = new Scene();

		scene.addEntity(new Background());
		scene.addEntity(new Copter(200, 200, scene));

		cam = new OrthoCam();
		resized();

		scene.registerRenderSystem(new SceneRenderSystem());
	}

	@Override
	public void update(float delta)
	{
		scene.update(delta);
	}

	@Override
	public void render(float delta)
	{
		cam.apply();
		scene.render(delta);
	}

	@Override
	public void resized()
	{
		cam.initProjection(1280, 720);
		GLContext.viewport(0, 0, SilenceEngine.display.getWidth(), SilenceEngine.display.getHeight());
	}
}
