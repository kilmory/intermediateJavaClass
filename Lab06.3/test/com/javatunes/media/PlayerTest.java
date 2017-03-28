/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.media;

import static org.junit.Assert.*;
import org.junit.Test;
import com.javatunes.media.Equalizer;
import com.javatunes.media.NoiseReducer;
import com.javatunes.media.Player;
import com.javatunes.media.Radio;
import com.javatunes.media.SoundLeveler;
import com.javatunes.media.Television;

public class PlayerTest {

  @Test
  public void testUndecoratedPlayer() {
    Player p1 = new Television();
    p1.play();
    
    Player p2 = new Radio();
    p2.play();
  }
  
  /**
   * Example: Television with sound leveling and noise reduction applied.
   * Uncomment below after SoundLeveler and NoiseReducer have been written.
   */
  @Test
  public void testSoundLevelerNoiseReducerTelevision() {
    Player p = new SoundLeveler(new NoiseReducer(new Television()));
    p.play();
  }
  
  /**
   * Inverse of above test. Same results.
   * BUT this is because one is a pre-processor and one is post.
   * What would be the case if they were both pre-processors (or post-processors)?
   */
  @Test
  public void testNoiseReducerSoundLevelerTelevision() {
    Player p = new NoiseReducer(new SoundLeveler(new Television()));
    p.play();
  }

  @Test
  public void testEqualizerTelevision() {
    Player p = new Equalizer(new Television());
    p.play();
  }
  
  @Test
  public void testEqualizerJAZZRadio() {
    Player p = new Equalizer(new Radio(), EqualizerMode.JAZZ);
    p.play();
  }
  
  @Test
  public void testNoiseReducerEqualizerRadio() {
    Equalizer eq = new Equalizer(new Radio());  // keep a reference, to adjust this later
    Player p = new NoiseReducer(eq);
    p.play();
    System.out.println();
    
    eq.setMode(EqualizerMode.JAZZ);
    p.play();
  }
  
  @Test
  public void testEqualizerSoundLevelerTelevisionThenAddNoiseReducer() {
    Player p = new Equalizer(new SoundLeveler(new Television()));
    p.play();
    System.out.println();
    
    p = new NoiseReducer(p);
    p.play();
  }
  
  @Test
  public void testEqualizerROCKSoundLevelerNoiseReducerRadio() {
    Player p = new Equalizer(new SoundLeveler(new NoiseReducer(new Radio())), EqualizerMode.ROCK);
    p.play();
  }
}