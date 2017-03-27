package com.javatunes.media;

import org.media.standard.MediaPlayer;

public class VehicleMediaPlayer
implements MediaPlayer {
  
  private static final String[] CONTENT_TYPES = {"AM, FM, XM, AUX, CD"};

  public String[] getSupportedContentTypes() {
    return CONTENT_TYPES;
  }
  
  public String play() {
    return "VehicleMediaPlayer playing Vehicle media";
  }
}
