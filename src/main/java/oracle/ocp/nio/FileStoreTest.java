package oracle.ocp.nio;

import sun.nio.fs.WindowsFileSystemProvider;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;
import java.util.Optional;

import static java.nio.file.spi.FileSystemProvider.installedProviders;

public class FileStoreTest {

    public static void main(String[] args) throws IOException {
        FileSystemProvider fsp = installedProviders().get(0);
        Path path = Paths.get("c:\\");
        FileStore fs = fsp.getFileStore(path);
        System.out.printf("Space on %s \nTotal space: %s\nAvailable: %s",path,
                humanReadableByteCount(fs.getTotalSpace(), true),
                humanReadableByteCount(fs.getUsableSpace(), true));
    }

    private static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

}
