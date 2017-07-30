package com.shc.ld39.crashescape;

import com.shc.ld39.crashescape.Resources.Animations;
import com.shc.ld39.crashescape.Resources.Textures;
import com.shc.silenceengine.core.ResourceLoader;
import com.shc.silenceengine.graphics.Animation;
import com.shc.silenceengine.graphics.SpriteSheet;
import com.shc.silenceengine.graphics.opengl.Texture;
import com.shc.silenceengine.io.FilePath;
import com.shc.silenceengine.utils.ResourceLoadingState;
import com.shc.silenceengine.utils.TimeUtils;
import com.shc.silenceengine.utils.functional.SimpleCallback;

public class LoadingState extends ResourceLoadingState
{
    private LoadingState(ResourceLoader loader, SimpleCallback doneCallback)
    {
        super(loader, doneCallback);
    }

    static LoadingState create()
    {
        ResourceLoader loader = new ResourceLoader();

        long backgroundTexID = loader.define(Texture.class, FilePath.getResourceFile("background.png"));
        long smokeTexID = loader.define(Texture.class, FilePath.getResourceFile("smoke.png"));
        long copterTexID = loader.define(Texture.class, FilePath.getResourceFile("copter.png"));
        
        long building1TexID = loader.define(Texture.class, FilePath.getResourceFile("building1.png"));
        long building2TexID = loader.define(Texture.class, FilePath.getResourceFile("building2.png"));
        long building3TexID = loader.define(Texture.class, FilePath.getResourceFile("building3.png"));

        return new LoadingState(loader, () ->
        {
            Resources.Textures.BACKGROUND = loader.get(backgroundTexID);
            Resources.Textures.SMOKE_SHEET = loader.get(smokeTexID);
            Resources.Textures.COPTER = loader.get(copterTexID);
            
            Resources.Textures.BUILDING[0] = loader.get(building1TexID);
            Resources.Textures.BUILDING[1] = loader.get(building2TexID);
            Resources.Textures.BUILDING[2] = loader.get(building3TexID);
            
            Animation smokeAnim = Animations.SMOKE = new Animation();
            SpriteSheet smokeSheet = new SpriteSheet(Textures.SMOKE_SHEET, 41, 41);
            
            smokeAnim.addFrame(smokeSheet.getCell(0, 0), 100, TimeUtils.Unit.MILLIS);
            smokeAnim.addFrame(smokeSheet.getCell(0, 1), 100, TimeUtils.Unit.MILLIS);
            smokeAnim.addFrame(smokeSheet.getCell(0, 2), 100, TimeUtils.Unit.MILLIS);
            smokeAnim.addFrame(smokeSheet.getCell(1, 0), 100, TimeUtils.Unit.MILLIS);
            smokeAnim.addFrame(smokeSheet.getCell(1, 1), 100, TimeUtils.Unit.MILLIS);
            smokeAnim.addFrame(smokeSheet.getCell(1, 2), 100, TimeUtils.Unit.MILLIS);

            CrashEscape.INSTANCE.setGameState(new PlayState());
        });
    }
}
