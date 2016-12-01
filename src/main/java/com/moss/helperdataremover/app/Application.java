package com.moss.helperdataremover.app;

import com.moss.helperdataremover.file.FileHandler;

public class Application {

    public Application() {
        FileHandler.removeFiles();
    }
}
