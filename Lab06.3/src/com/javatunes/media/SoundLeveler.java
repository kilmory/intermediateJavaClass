/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.media;

public class SoundLeveler
extends PlayerEffect {

  public SoundLeveler(Player decoratedPlayer) {
    super(decoratedPlayer);
  }
  
  /**
   * Add sound leveling *after* delegating to contained object.
   * Modeled with a simple message to stdout.
   */
  @Override
  public void play() {
    decoratedPlayer.play();
    System.out.println("Post-processing: leveling sound");
  }
}