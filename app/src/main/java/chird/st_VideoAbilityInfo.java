package chird;

public class st_VideoAbilityInfo
{
  public static final int CHD_FMT_H264 = 3;
  public static final int CHD_FMT_MJPEG = 2;
  public static final int CHD_FMT_YUYV = 1;
  public static int FormatNum = 0;
  public static int ResoluNum = 0;
  public int[] format = new int[5];
  public int[] height = new int[12];
  public int[] maxfps = new int[12];
  public int[] width = new int[12];
  
  public String GetFormatString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "OTHER";
    case 1: 
      return "YUYV";
    case 2: 
      return "JPEG";
    }
//    return "H264";
  }
  
  public String GetResoluString(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + "x" + String.valueOf(paramInt2);
  }
}


/* Location:              C:\Users\Brian\Desktop\Android\Apktool\dex2jar-2.0\classes-dex2jar.jar!\chird\st_VideoAbilityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */