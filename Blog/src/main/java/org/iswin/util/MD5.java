package org.iswin.util;

import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  public static String getMd5(String plainText)
  {
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(plainText.getBytes());
      byte[] b = md.digest();

      StringBuffer buf = new StringBuffer("");
      for (int offset = 0; offset < b.length; offset++) {
        int i = b[offset];
        if (i < 0)
          i += 256;
        if (i < 16)
          buf.append("0");
        buf.append(Integer.toHexString(i));
      }

      return buf.toString();
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }return null;
  }

  public static void main(String[] args)
  {
    System.out.println(getMd5("gongyushan!myblog"));
  }
}