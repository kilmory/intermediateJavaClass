/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.media;

public class NoiseReducer
extends PlayerEffect {

  public NoiseReducer(Player decoratedPlayer) {
    super(decoratedPlayer);
  }
  
  /**
   * Add noise reduction *before* delegating to contained object.
   * Modeled with a simple message to stdout.
   */
  @Override
  public void play() {
    System.out.println("Pre-processing: reducing noise");
    decoratedPlayer.play();
  }
}