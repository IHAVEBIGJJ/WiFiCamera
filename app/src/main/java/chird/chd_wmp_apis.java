package chird;

import android.graphics.Bitmap;

public class chd_wmp_apis
{
  public static final int CHD_POLL_TYPE_AUDIO = 2;
  public static final int CHD_POLL_TYPE_PICTURE = 1;
  public static final int CHD_POLL_TYPE_SERIAL = 3;
  public static final int CHD_POLL_TYPE_VIDEO = 0;
  public static final int CHD_POOL_TYPE_CHANGE_AUDEO = 7;
  public static final int CHD_POOL_TYPE_CHANGE_GPIO = 9;
  public static final int CHD_POOL_TYPE_CHANGE_SERIAL = 8;
  public static final int CHD_POOL_TYPE_CHANGE_VABILITY = 4;
  public static final int CHD_POOL_TYPE_CHANGE_VCTRL = 6;
  public static final int CHD_POOL_TYPE_CHANGE_VPARAM = 5;
  public static final int CHD_TRANS_MODE_EFAST = 1;
  public static final int CHD_TRANS_MODE_TCP = 0;
  
  static
  {
    System.loadLibrary("chd_base");
    System.loadLibrary("chd_efast");
    System.loadLibrary("chd_decode");
    System.loadLibrary("chd_wmp_sdk");
  }
  
  public native int CHD_WMP_Audio_Begin(long paramLong);
  
  public native int CHD_WMP_Audio_End(long paramLong);
  
  public native int CHD_WMP_Audio_GetParam(long paramLong, st_AudioParamInfo paramst_AudioParamInfo);
  
  public native int CHD_WMP_Audio_RequestData(long paramLong, st_AudioFrame paramst_AudioFrame, byte[] paramArrayOfByte);
  
  public native long CHD_WMP_ConnectDevice(String paramString);
  
  public native int CHD_WMP_Decode_MjpegToBitmap(long paramLong, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, byte[] paramArrayOfByte);
  
  public native int CHD_WMP_Decode_YuyvToBitmap(long paramLong, int paramInt1, int paramInt2, Bitmap paramBitmap, byte[] paramArrayOfByte);
  
  public native int CHD_WMP_Disconnect(long paramLong);
  
  public native int CHD_WMP_GetDeviceInfo(long paramLong, st_DeviceInfo paramst_DeviceInfo);
  
  public native String CHD_WMP_GetEncrypt(long paramLong);
  
  public native String CHD_WMP_GetMac(long paramLong);
  
  public native int CHD_WMP_GetSystemTime(long paramLong, st_SystimeInfo paramst_SystimeInfo);
  
  public native int CHD_WMP_Gpio_GetStatus(long paramLong, int paramInt, st_GpioInfo paramst_GpioInfo);
  
  public native int CHD_WMP_Gpio_SetStatus(long paramLong, int paramInt1, int paramInt2);
  
  public native int CHD_WMP_I2C_GetValue(long paramLong, st_I2CInfo paramst_I2CInfo);
  
  public native int CHD_WMP_I2C_SetValue(long paramLong, st_I2CInfo paramst_I2CInfo);
  
  public native int CHD_WMP_Mjpeg2Avi_Begin(long paramLong, String paramString);
  
  public native int CHD_WMP_Mjpeg2Avi_End(long paramLong);
  
  public native int CHD_WMP_Mjpeg2Avi_PutData(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public native int CHD_WMP_Mjpeg2Avi_SetParam(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native int CHD_WMP_Poll(long paramLong, int paramInt1, int paramInt2);
  
  public native int CHD_WMP_SaveFile(long paramLong, String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public native int CHD_WMP_ScanDevice_Init(int paramInt);
  
  public native int CHD_WMP_ScanDevice_UnInit();
  
  public native int CHD_WMP_Scan_GetDeviceInfo(st_SearchInfo paramst_SearchInfo);
  
  public native int CHD_WMP_Serial_Begin(long paramLong);
  
  public native int CHD_WMP_Serial_End(long paramLong);
  
  public native int CHD_WMP_Serial_GetCurRxCacheSize(long paramLong);
  
  public native int CHD_WMP_Serial_GetDataBit(long paramLong);
  
  public native int CHD_WMP_Serial_GetParamt(long paramLong, st_SerialInfo paramst_SerialInfo);
  
  public native int CHD_WMP_Serial_GetParity(long paramLong);
  
  public native int CHD_WMP_Serial_GetRxTotalNum(long paramLong);
  
  public native int CHD_WMP_Serial_GetSpeed(long paramLong);
  
  public native int CHD_WMP_Serial_GetStopBit(long paramLong);
  
  public native int CHD_WMP_Serial_GetTimeout(long paramLong);
  
  public native int CHD_WMP_Serial_GetTxTotalNum(long paramLong);
  
  public native int CHD_WMP_Serial_RequestData(long paramLong, byte[] paramArrayOfByte);
  
  public native int CHD_WMP_Serial_SendData(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public native int CHD_WMP_Serial_SetDataBit(long paramLong, int paramInt);
  
  public native int CHD_WMP_Serial_SetParity(long paramLong, int paramInt);
  
  public native int CHD_WMP_Serial_SetSpeed(long paramLong, int paramInt);
  
  public native int CHD_WMP_Serial_SetStopBit(long paramLong, int paramInt);
  
  public native int CHD_WMP_Serial_SetTimeout(long paramLong, int paramInt);
  
  public native int CHD_WMP_SetSystemTime(long paramLong, st_SystimeInfo paramst_SystimeInfo);
  
  public native int CHD_WMP_SetTransMode(long paramLong, int paramInt);
  
  public native int CHD_WMP_Video_Begin(long paramLong);
  
  public native int CHD_WMP_Video_End(long paramLong);
  
  public native int CHD_WMP_Video_GetAbility(long paramLong, st_VideoAbilityInfo paramst_VideoAbilityInfo);
  
  public native int CHD_WMP_Video_GetCurPictureFrameNum(long paramLong);
  
  public native int CHD_WMP_Video_GetCurVideoFrameNum(long paramLong);
  
  public native int CHD_WMP_Video_GetFPS(long paramLong);
  
  public native int CHD_WMP_Video_GetFormat(long paramLong);
  
  public native int CHD_WMP_Video_GetLocalMaxFrameNum(long paramLong);
  
  public native int CHD_WMP_Video_GetParam(long paramLong, st_VideoParamInfo paramst_VideoParamInfo);
  
  public native int CHD_WMP_Video_GetPeerMaxFrameNum(long paramLong);
  
  public native int CHD_WMP_Video_GetResolu(long paramLong, st_VideoParamInfo paramst_VideoParamInfo);
  
  public native int CHD_WMP_Video_GetVideoCtrl(long paramLong, int paramInt, st_VideoCtrlInfo paramst_VideoCtrlInfo);
  
  public native int CHD_WMP_Video_RequestPicData(long paramLong, st_VideoFrame paramst_VideoFrame, byte[] paramArrayOfByte);
  
  public native int CHD_WMP_Video_RequestVideoData(long paramLong, st_VideoFrame paramst_VideoFrame, byte[] paramArrayOfByte);
  
  public native int CHD_WMP_Video_ResetVCtrl(long paramLong);
  
  public native int CHD_WMP_Video_SetFPS(long paramLong, int paramInt);
  
  public native int CHD_WMP_Video_SetFormat(long paramLong, int paramInt);
  
  public native int CHD_WMP_Video_SetLocalMaxFrameNum(long paramLong, int paramInt);
  
  public native int CHD_WMP_Video_SetPeerMaxFrameNum(long paramLong, int paramInt);
  
  public native int CHD_WMP_Video_SetResolu(long paramLong, int paramInt1, int paramInt2);
  
  public native int CHD_WMP_Video_SetVideoCtrl(long paramLong, int paramInt, st_VideoCtrlInfo paramst_VideoCtrlInfo);
  
  public native int CHD_WMP_Video_SnapShot(long paramLong);
  
  public native int CHD_WMP_Video_SnapShotResolu(long paramLong, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\Brian\Desktop\Android\Apktool\dex2jar-2.0\classes-dex2jar.jar!\chird\chd_wmp_apis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */