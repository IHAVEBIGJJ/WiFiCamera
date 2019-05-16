package chird;

public class st_SystimeInfo
{
  public static int hour = 0;
  public static int mday;
  public static int min = 0;
  public static int month;
  public static int sec = 0;
  public static int wday;
  public static int year = 0;
  
  static
  {
    month = 0;
    mday = 0;
    wday = 0;
  }
  
  public void SetTimes(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    year = paramInt1;
    month = paramInt2;
    mday = paramInt3;
    wday = paramInt4;
    hour = paramInt5;
    min = paramInt6;
    sec = paramInt7;
  }
}


/* Location:              C:\Users\Brian\Desktop\Android\Apktool\dex2jar-2.0\classes-dex2jar.jar!\chird\st_SystimeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */