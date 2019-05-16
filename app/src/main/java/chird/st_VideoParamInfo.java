package chird;

public class st_VideoParamInfo
{
  public static final int CHD_FMT_H264 = 3;
  public static final int CHD_FMT_MJPEG = 2;
  public static final int CHD_FMT_YUYV = 1;
  public static int format = 0;
  public static int fps = 0;
  public static int height;
  public static int maxfps = 0;
  public static int width = 0;
  
  static
  {
    height = 0;
  }
  
  public String GetFormatString()
  {
    switch (format)
    {
    default: 
      return "other";
    case 1: 
      return "YUYV";
    case 2: 
      return "JPEG";
    }
//    return "H264";
  }
  
  public String GetResoluString()
  {
    return String.valueOf(width) + "x" + String.valueOf(height);
  }
}


/* Location:              C:\Users\Brian\Desktop\Android\Apktool\dex2jar-2.0\classes-dex2jar.jar!\chird\st_VideoParamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */