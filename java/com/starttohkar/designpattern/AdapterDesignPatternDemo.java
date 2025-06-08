package com.starttohkar.designpattern;

/**
 * The Adapter pattern helps different things to work together, even if they are not originally
 *   made to work together. It changes one thing to be like another thing so that they can work together.
 *   This is useful when there are things that cannot work together, but we still need them to work together.
 *
 * To implement the Adapter Pattern, we will need to:
 *
 * Identify the target interface that the client expects to use.
 * Identify the existing interface that needs to be adapted to meet the target interface.
 * Create an Adapter class that implements the target interface and contains an instance of the existing
 *       interface.
 * Implement the methods of the target interface in the Adapter class by calling the appropriate methods
 *     of the existing interface instance.
 *
 *
 */


// Target interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Existing interface
interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}

// Existing class that implements the AdvancedMediaPlayer interface
class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing
    }
}

// Existing class that implements the AdvancedMediaPlayer interface
class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}

// Adapter class that implements the MediaPlayer interface and contains an instance of the AdvancedMediaPlayer interface
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

// Client code
public class AdapterDesignPatternDemo {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaAdapter("mp4");
        mediaPlayer.play("mp4", "movie.mp4");

        mediaPlayer = new MediaAdapter("vlc");
        mediaPlayer.play("vlc", "song.vlc");
    }
}

