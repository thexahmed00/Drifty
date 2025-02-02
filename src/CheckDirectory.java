import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
class CheckDirectory {
    CheckDirectory(String dir) throws IOException {
        if (!(checkIfFolderExists(dir))){
            Path directory = FileSystems.getDefault().getPath(dir);
            Files.createDirectory(directory);
            Drifty_CLI.cl.log("INFO", "Directory Created");
        }
    }
    private static boolean checkIfFolderExists(String folderName) {
        boolean found = false;
        try {
            File file = new File(folderName);
            if (file.exists() && file.isDirectory()) {
                found = true;
            }
        } catch (Exception e) {
            System.out.println("Error while checking for directory !");
            Drifty_CLI.cl.log("ERROR", "Error while checking for directory !");
        }
        return found;
    }
}
