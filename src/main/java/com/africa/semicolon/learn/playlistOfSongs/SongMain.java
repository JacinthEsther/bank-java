package com.africa.semicolon.learn.playlistOfSongs;

import java.util.*;

public class SongMain {
    private static ArrayList <Album> albums = new ArrayList<Album>();
     public static void main(String[] args) {

        Album album = new Album("Gospel","Dunsin");

        album.addSong("Breathe",4.00);
        album.addSong("Fresh Oil",4.09);
        album.addSong("Ekaabo",5.00);
        album.addSong("I'll be here",6.00);

        albums.add(album);

         album = new Album("Hillsong","Hillsong United");

         album.addSong("A beautiful name",7.00);
         album.addSong("So will i",8.09);
         album.addSong("Oceans",4.00);
         album.addSong("King of kings",11.00);

         albums.add(album);

         LinkedList<Song> playlist= new LinkedList<>();

         albums.get(0).addToPlayList("Fresh Oil", playlist);
         albums.get(0).addToPlayList("Ekaabo", playlist);
         albums.get(0).addToPlayList("King of kings", playlist);
         albums.get(1).addToPlayList(3, playlist);
         albums.get(1).addToPlayList(2, playlist);
         albums.get(1).addToPlayList(8, playlist);

         play(playlist);
    }

    private static void play(LinkedList<Song>playlist){
         Scanner scanner = new Scanner(System.in);
         boolean quit = false;
         boolean forward = true;
         ListIterator<Song> listIterator = playlist.listIterator();
         if(playlist.size()==0){
             System.out.println("No song in playlist");
         } else {
             System.out.println("Now playing " + listIterator.next().toString());
                printMenu();
         }
         while(!quit){
             int action = scanner.nextInt();
             scanner.nextLine();

             switch (action) {
                 case 0 -> {
                     System.out.println("Playlist complete.");
                     quit = true;

                 }
                 case 1 -> {
                     if (!forward) {
                         if (listIterator.hasNext()) {
                             listIterator.next();
                         }
                         forward = true;
                     }
                     if (listIterator.hasNext()) {
                         System.out.println("Now playing " + listIterator.next().toString());
                     } else {
                         System.out.println("We have reached the end of the playlist");
                         forward = false;
                     }
                 }
                 case 2 -> {
                     if (forward) {
                         if (listIterator.hasPrevious()) {
                             listIterator.previous();
                         }
                         forward = false;
                     }
                     if (listIterator.hasPrevious()) {
                         System.out.println("Now playing " + listIterator.previous().toString());
                     } else {
                         System.out.println("We are at the start of the playlist");
                         forward = true;
                     }
                 }
                 case 3 -> {
                     if (forward) {
                         if (listIterator.hasPrevious()) {
                             System.out.println("Now replaying " + listIterator.previous().toString());
                             forward = false;
                         } else {
                             System.out.println("We are at the start of the list");
                         }
                     } else {
                         if (listIterator.hasNext()) {
                             System.out.println("Now replaying " + listIterator.next().toString());
                             forward = true;
                         } else System.out.println("We have reached the end of the list");
                     }
                 }
                 case 4 ->
                     printList(playlist);

                 case 5 ->
                     printMenu();
                case 6 -> {
                    if(playlist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing "+ listIterator.next());
                        } else if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+ listIterator.previous());
                        }
                    }
                }
             }
         }


    }
    private static void printMenu() {
            String menu = """
                    Choose Option:
                    0 - to quit
                    1 - to play next song
                    2 - to play previous song
                    3 - to replay the current song
                    4 - list songs in the playlist
                    5 - print available actions
                    6 - delete current song from playlist
                    """;
        System.out.println(menu);
    }
    private static void printList(LinkedList<Song> playlist){
         Iterator<Song> iterator = playlist.iterator();
        System.out.println("=".repeat(20));
         while(iterator.hasNext()){
             System.out.println(iterator.next());
         }
        System.out.println("================");

    }
}
