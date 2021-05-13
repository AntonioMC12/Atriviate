package es.antoniomc.Atriviate.utils;

import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
import static javax.sound.sampled.AudioSystem.getAudioInputStream;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;



import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioFilePlayer extends Thread {
  
  @Override
  public void run() {
    play("/home/ertonix12/JavaProjects/Atriviate/src/main/resources/es/antoniomc/Atriviate/media/PlayMusic.WAV");
  }

  public static void play(String inputStream) {
    final File file = new File(inputStream);

    try (final AudioInputStream in = getAudioInputStream(file)) {

      final AudioFormat outFormat = getOutFormat(in.getFormat());
      final Info info = new Info(SourceDataLine.class, outFormat);

      try (final SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info)) {

        if (line != null) {
          line.open(outFormat);
          line.start();
          stream(getAudioInputStream(outFormat, in), line);
          line.drain();
          line.stop();
        }
      }

    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private static AudioFormat getOutFormat(AudioFormat inFormat) {
    final int ch = inFormat.getChannels();

    final float rate = inFormat.getSampleRate();
    return new AudioFormat(PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
  }

  private static void stream(AudioInputStream in, SourceDataLine line) throws IOException {
    final byte[] buffer = new byte[4096];
    for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
      line.write(buffer, 0, n);
    }
  }
}
