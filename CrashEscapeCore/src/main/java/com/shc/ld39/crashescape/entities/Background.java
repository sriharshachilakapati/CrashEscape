package com.shc.ld39.crashescape.entities;

import com.shc.ld39.crashescape.Resources;
import com.shc.silenceengine.graphics.Sprite;
import com.shc.silenceengine.scene.Entity;
import com.shc.silenceengine.scene.components.SpriteComponent;

public class Background extends Entity
{
	public Background()
	{
		SpriteComponent backgroundSpriteComponent = new SpriteComponent(new Sprite(Resources.Textures.BACKGROUND));
		backgroundSpriteComponent.layer = 10;
		addComponent(backgroundSpriteComponent);
		transformComponent.setPosition(1280 / 2,  720 / 2);
	}
}
