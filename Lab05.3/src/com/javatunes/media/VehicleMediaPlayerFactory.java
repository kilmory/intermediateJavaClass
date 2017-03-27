package com.javatunes.media;

import org.media.standard.MediaPlayer;
import org.media.standard.MediaPlayerFactory;

public class VehicleMediaPlayerFactory
implements MediaPlayerFactory {

  public MediaPlayer newPlayer() {
    return new VehicleMediaPlayer();
  }
}