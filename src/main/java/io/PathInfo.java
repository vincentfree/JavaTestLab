package io;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Created by nerom on 2-9-2015.
 */
public class PathInfo {
    public static void main(String[] args) {
        Path path = Paths.get("../tmp.txt");
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.getFileSystem());
        System.out.println(path.toAbsolutePath());
        System.out.println(path.normalize().toAbsolutePath());
        try{
            System.out.println(path.toRealPath(LinkOption.valueOf(path.toAbsolutePath().toString()), LinkOption.NOFOLLOW_LINKS));
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
