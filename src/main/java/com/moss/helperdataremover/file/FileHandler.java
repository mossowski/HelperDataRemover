package com.moss.helperdataremover.file;

import java.io.File;
import java.net.URISyntaxException;

import com.moss.helperdataremover.Main;
import static com.moss.helperdataremover.utilities.Settings.documentsDirectory;
import static com.moss.helperdataremover.utilities.Settings.imagesDirectory;
import static com.moss.helperdataremover.utilities.Settings.mostWantedDirectory;

public class FileHandler {

    public static final File workingDirectory = getWorkingDirectory();

    private static File getWorkingDirectory() {
        String path = null;
        String filePath = null;
        File file = null;
        try {
            path = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (path != null) {
            if (path.endsWith("HelperDataRemover/target/classes/")) {
                filePath = path.replace("HelperDataRemover/target/classes/", "Helper");
            }
            else if (path.endsWith("helper-data-remover.jar")) {
                filePath = path.replace("helper-data-remover.jar", "");
            }
        }
        file = new File(filePath);
        return file;
    }

    // ------------------------------------------------------------------------------------------------------------------

    public static void removeFiles() {
        File docDirectory = new File(documentsDirectory);
        for (File file : docDirectory.listFiles())
            file.delete();
        File imgDirectory = new File(imagesDirectory);
        for (File file : imgDirectory.listFiles())
            file.delete();
        File mostWantDirectory = new File(mostWantedDirectory);
        for (File file : mostWantDirectory.listFiles())
            file.delete();
    }
}
