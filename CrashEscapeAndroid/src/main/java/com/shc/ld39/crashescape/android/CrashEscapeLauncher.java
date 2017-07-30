package com.shc.ld39.crashescape.android;

import com.shc.ld39.crashescape.CrashEscape;
import com.shc.silenceengine.backend.android.AndroidRuntime;
import com.shc.silenceengine.backend.android.AndroidLauncher;

/**
 * @author Sri Harsha Chilakapati
 */
public class CrashEscapeLauncher extends AndroidLauncher
{
    @Override
    public void launchGame()
    {
        AndroidRuntime.start(new CrashEscape());
    }
}