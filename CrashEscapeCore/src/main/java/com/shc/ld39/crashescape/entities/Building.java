package com.shc.ld39.crashescape.entities;

import com.shc.ld39.crashescape.Resources;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.graphics.opengl.Texture;
import com.shc.silenceengine.scene.Component;
import com.shc.silenceengine.scene.Entity;
import com.shc.silenceengine.scene.components.SpriteComponent;
import com.shc.silenceengine.utils.TaskManager;

public class Building extends Entity
{
	public Building(int type, float x)
	{
		Texture texture = Resources.Textures.BUILDING[type];
		
		SpriteComponent spriteComponent = new SpriteComponent(new Sprite(texture));
		spriteComponent.layer = 9;
		
		addComponent(spriteComponent);
		addComponent(new Behaviour());
		
		transformComponent.setPosition(x, 720 - texture.getHeight() / 2 - 50);
	}
	
	private static final class Behaviour extends Component
	{
		@Override
		protected void onUpdate(float elapsedTime)
		{
			transformComponent.translate(-4, 0);
			
			if (transformComponent.getPosition().x < -400)
				TaskManager.runOnRender(() -> entity.destroy());
		}
	}
}
