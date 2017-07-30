package com.shc.ld39.crashescape.entities;

import com.shc.ld39.crashescape.Resources;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.input.Touch;
import com.shc.silenceengine.math.Vector2;
import com.shc.silenceengine.scene.Component;
import com.shc.silenceengine.scene.Entity;
import com.shc.silenceengine.scene.Scene;
import com.shc.silenceengine.scene.components.SpriteComponent;

public class Copter extends Entity
{
	public Copter(float x, float y, Scene scene)
	{
		addComponent(new SpriteComponent(new Sprite(Resources.Textures.COPTER)));
		transformComponent.setPosition(x, y);
		
		addComponent(new Behaviour());
		
		createSmoke(-70, 0, 2, scene);
		createSmoke(30, 40, -1, scene);
	}
	
	private void createSmoke(float x, float y, int layer, Scene scene)
	{
		Entity smoke = new Entity();
		Sprite smokeSprite = new Sprite(Resources.Animations.SMOKE);
		smokeSprite.setEndCallback(smokeSprite::start);
		smokeSprite.start();
		
		SpriteComponent spriteComponent = new SpriteComponent(smokeSprite);
		spriteComponent.layer = layer;
		
		smoke.addComponent(spriteComponent);
		smoke.transformComponent.setPosition(x, y);
		scene.addEntity(smoke);
	
		smoke.transformComponent.setParent(transformComponent);
	}
	
	private static final class Behaviour extends Component
	{
		private Vector2 velocity = new Vector2();
		
		@Override
		protected void onUpdate(float elapsedTime)
		{
			velocity.y = 4;
			
			if (Touch.isAnyFingerDown())
				velocity.y = -4;
			
			transformComponent.translate(velocity);
		}
	}
}
