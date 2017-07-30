package com.shc.ld39.crashescape.html;

import com.google.gwt.core.client.EntryPoint;
import com.shc.silenceengine.backend.gwt.GwtRuntime;
import com.shc.ld39.crashescape.CrashEscape;

public class CrashEscapeLauncher implements EntryPoint
{
    @Override
    public void onModuleLoad()
    {
        GwtRuntime.start(new CrashEscape());
    }
}