package chird;

public class st_AudioFrame
{
  public static final int CHD_AUDIO_ADBITS_16 = 16;
  public static final int CHD_AUDIO_ADBITS_8 = 8;
  public static final int CHD_AUDIO_CHN_SIGNAL = 1;
  public static final int CHD_AUDIO_CHN_STEREO = 2;
  public static final int CHD_AUDIO_SAMPLE_44100 = 44100;
  public static final int CHD_AUDIO_SAMPLE_48000 = 48000;
  public static final int CHD_AUDIO_SAMPLE_8000 = 8000;
  public static int datalen = 0;
  public static int eadbits;
  public static int echn;
  public static int esample = 0;
  public static int timestamp;
  
  static
  {
    echn = 0;
    eadbits = 0;
    timestamp = 0;
  }
}


/* Location:              C:\Users\Brian\Desktop\Android\Apktool\dex2jar-2.0\classes-dex2jar.jar!\chird\st_AudioFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */