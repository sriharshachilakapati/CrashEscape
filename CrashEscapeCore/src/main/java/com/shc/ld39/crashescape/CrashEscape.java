package com.shc.ld39.crashescape;

import com.shc.silenceengine.core.Game;
import com.shc.silenceengine.core.SilenceEngine;
import com.shc.silenceengine.input.Keyboard;

public class CrashEscape extends Game
{
    public static Game INSTANCE;

    @Override
    public void init()
    {
        INSTANCE = this;

        SilenceEngine.display.setTitle("CrashEscape: SilenceEngine " + SilenceEngine.getVersionString());
        SilenceEngine.display.setSize(1280, 720);
        SilenceEngine.display.centerOnScreen();
        
        SilenceEngine.input.setSimulateTouch(true);

        setGameState(LoadingState.create());
    }

    @Override
    public void update(float deltaTime)
    {
        if (Keyboard.isKeyTapped(Keyboard.KEY_ESCAPE))
            SilenceEngine.display.close();
    }
}