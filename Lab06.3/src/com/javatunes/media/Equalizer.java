/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.media;

public class Equalizer
extends PlayerEffect {
  private EqualizerMode mode = EqualizerMode.NORMAL;
  
  public Equalizer(Player decoratedPlayer) {
    super(decoratedPlayer);
  }
  
  public Equalizer(Player decoratedPlayer, EqualizerMode mode) {
    super(decoratedPlayer);
    setMode(mode);
  }
  
  /**
   * Add equalizer functionality *before* delegating to contained object.
   * Modeled with a simple message to stdout.
   */
  @Override
  public void play() {
    System.out.println("Pre-processing: equalizing to " + mode);
    decoratedPlayer.play();
  }
  
  public EqualizerMode getMode() {
    return this.mode;
  }
  public void setMode(EqualizerMode mode) {
    this.mode = mode;
  }
}