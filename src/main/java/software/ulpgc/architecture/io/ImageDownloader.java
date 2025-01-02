package software.ulpgc.architecture.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ImageDownloader {

    public static void downloadImage(String urlImage, String finalPath) throws Exception {
        try {
            URL url = new URL(urlImage);
            InputStream inputStream = url.openStream();
            Path path = Paths.get(finalPath);
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
            inputStream.close();
        } catch (IOException e) {
            throw new Exception("Error while downloading the image:" + e);
        }
    }
}