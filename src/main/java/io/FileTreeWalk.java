import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

/**
 * Voorbeeld voor het uitvoeren van een tree walk
 */
public class FileTreeWalk {

  private PathMatcher matcher;

  FileTreeWalk(PathMatcher matcher) {
    this.matcher = matcher;
    this.new MyFileVisitor();
  }

  class MyFileVisitor implements FileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
      return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
      if (find(file)) {
        System.out.println("file name :" + file.getFileName());
      }
      return FileVisitResult.CONTINUE;
    }

    private boolean find(Path path) {
      Path fileName = path.getFileName();
      if (matcher.matches(fileName)) {
        return true;
      } else
        return false;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
      System.out.println("Failed to read " + file + " " + exc);
      return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
      return FileVisitResult.CONTINUE;
    }
  }
}