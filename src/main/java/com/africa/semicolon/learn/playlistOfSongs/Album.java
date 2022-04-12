package com.africa.semicolon.learn.playlistOfSongs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    List<Song> listOfSongs = new ArrayList<>();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;

    }

    public boolean addSong(String title, double duration){
        if(findSong(title)== null){
            listOfSongs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for(Song checkedSong: listOfSongs){
            if(checkedSong.getSongTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= listOfSongs.size())) {
            playList.add(listOfSongs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
    return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song "+ title + " is not in this album");
        return false;
    }
}
