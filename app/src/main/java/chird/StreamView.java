package chird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class StreamView
  extends View
{
  private static final String ALBUM_PATH = null;
  private static int m_ScreenHeight = 0;
  private static int m_ScreenWidth = 0;
  private Bitmap bitmap = null;
  private int height = 480;
  private Paint m_Paint = null;
  private int width = 800;
  private int x = 0;
  private int y = 0;
  
  public StreamView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StreamView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.m_Paint = new Paint();
  }
  
  static int PicDraw(Canvas paramCanvas, Bitmap paramBitmap, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(paramInt1, paramInt2, paramInt3, paramInt4), paramPaint);
    return 0;
  }
  
  public void SetActivity(int paramInt1, int paramInt2)
  {
    m_ScreenWidth = paramInt1;
    m_ScreenHeight = paramInt2;
  }
  
  public void ShowBitmapFrame(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    postInvalidate();
  }
  
  public void ShowFullScreen()
  {
    this.width = m_ScreenWidth;
    this.height = m_ScreenHeight;
  }
  
  public void ShowSetResolu(int paramInt1, int paramInt2)
  {
    if (paramInt1 > m_ScreenWidth) {
      paramInt1 = m_ScreenWidth;
    }
    while (paramInt2 > m_ScreenHeight)
    {
      this.height = m_ScreenHeight;
      this.width = paramInt1;
      return;

    }
    this.height = paramInt2;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.bitmap == null) {
      return;
    }
    this.x = ((m_ScreenWidth - this.width) / 2);
    this.y = ((m_ScreenHeight - this.height) / 2);
    Bitmap localBitmap = this.bitmap;
    Paint localPaint = this.m_Paint;
    int i = this.x;
    int j = this.y;
    int k = this.x;
    int m = this.width;
    int n = this.y;
    PicDraw(paramCanvas, localBitmap, localPaint, i, j, m + k, this.height + n);
  }
}


/* Location:              C:\Users\Brian\Desktop\Android\Apktool\dex2jar-2.0\classes-dex2jar.jar!\chird\StreamView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */