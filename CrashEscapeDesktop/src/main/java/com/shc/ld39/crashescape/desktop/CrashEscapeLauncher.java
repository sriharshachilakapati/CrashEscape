package com.shc.ld39.crashescape.desktop;

import com.shc.silenceengine.backend.lwjgl.LwjglRuntime;
import com.shc.ld39.crashescape.CrashEscape;

public class CrashEscapeLauncher
{
    public static void main(String[] args)
    {
        LwjglRuntime.start(new CrashEscape());
    }
}