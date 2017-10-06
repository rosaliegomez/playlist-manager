package playlistManager;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.io.IOException;
import java.util.List;

import util.Input;
import util.FileHandler;

import static java.util.Collections.list;

public class PlaylistApp {

    public static Input input = new Input();

    public static void main(String[] args) throws IOException {

        FileHandler fileHandler = new FileHandler("thePlaylist","songs.txt");

        fileHandler.createFile();
        do{
            System.out.println("1. View playlist");
            System.out.println("2. Add song");
            System.out.println("3. Remove song");
            System.out.println("4. Shuffle playlist");
            System.out.println("5. Sort list by duration");
            System.out.println("6. Filter by artist");
            System.out.println("7. Exit");

            int selection = input.getInt("Select an option");

            switch(selection){

                case 1:
                    viewSongs(fileHandler);
                    break;
                case 2:
                    addSong(fileHandler);
                    break;
                case 3:
                    deleteSong(fileHandler);
                    break;
                case 4:
                    shuffleSongs(fileHandler);
                    break;
                case 5:
                    sortByDuration(fileHandler);
            }

        } while (input.yesNo("Would you like to continue?"));

    }

    public static void viewSongs (FileHandler fileHandler) throws IOException {
        for(String songs: fileHandler.readFile()){
            System.out.println(songs);
        }
    }

    public static void addSong (FileHandler fileHandler) throws IOException {
        fileHandler.createFile();
        String songName = input.getString("What is the name of the song?");
        String songArtist = input.getString("What is the name of the artist");
        double songLength = input.getDouble("How long is this song?");
        String songInfo = songName + " | " + songArtist + " | " + songLength;
        List<String> playlist = new ArrayList<>();
        playlist.add(songInfo);
        fileHandler.writeToFile(playlist, true);

    }

    public static void deleteSong (FileHandler fileHandler) throws IOException {
        String songToBeDeleted = input.getString("Which song would you like to delete?");
        List<String> playlist = fileHandler.readFile();
        List<String> newList = new ArrayList<>();

        for(String song: playlist) {
            if (song.contains(songToBeDeleted) && input.yesNo("Delete " + song + " ? (y/n)")) {

            continue;
        }newList.add(song);
                fileHandler.writeToFile(newList, false);

        }
    }

    public static void shuffleSongs(FileHandler fileHandler) throws IOException {
        List<String> playList = fileHandler.readFile();
            Collections.shuffle(playList);
            System.out.println(playList);

    }

    public static void sortByDuration(FileHandler fileHandler) throws IOException {
        List<String> playlist = fileHandler.readFile();

        System.out.println(playlist);
    }
}
