package util;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.List;


public class FileHandler {

  private String directory;
  private String filename;
  private Path filePath;

  public FileHandler(String directory, String filename) {
    this.directory = directory;
    this.filename = filename;
    this.createFile();
  }

  public boolean createFile(){
    Path dataDirectory = Paths.get(this.directory);
    this.filePath = Paths.get(this.directory, this.filename);

    try {
      if (Files.notExists(dataDirectory)) {
        Files.createDirectories(dataDirectory);
      }

      if (Files.notExists(this.filePath)) {
        Files.createFile(this.filePath);
      }
    }catch (IOException e){
      return false;
    }
    return true;
  }


  public List<String> readFile () throws IOException {
    return Files.readAllLines(this.filePath);
  }

  public void writeToFile (List list, boolean append) throws IOException {
    if(append){
      Files.write(this.filePath, list, StandardOpenOption.APPEND);
    } else{
      Files.write(this.filePath,list);
    }
  }

//  public void delete (List list) throws IOException {
//    Files.delete(this.filePath);
//  }


  }


