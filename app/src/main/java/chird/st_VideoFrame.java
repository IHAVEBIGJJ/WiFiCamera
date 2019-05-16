package chird;

public class st_VideoFrame
{
  public static int BPS = 0;
  public static final int CHD_FMT_H264 = 3;
  public static final int CHD_FMT_MJPEG = 2;
  public static final int CHD_FMT_YUYV = 1;
  public static int bexist = 0;
  public static int datalen = 0;
  public static int format = 0;
  public static int fps;
  public static int height;
  public static int timestamp;
  public static int width = 0;
  
  static
  {
    height = 0;
    fps = 0;
    BPS = 0;
    timestamp = 0;
  }
}


/* Location:              C:\Users\Brian\Desktop\Android\Apktool\dex2jar-2.0\classes-dex2jar.jar!\chird\st_VideoFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */