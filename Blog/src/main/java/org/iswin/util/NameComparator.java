package org.iswin.util;

import java.util.Comparator;
import java.util.Hashtable;

public class NameComparator
  implements Comparator
{
  public int compare(Object a, Object b)
  {
    Hashtable hashA = (Hashtable)a;
    Hashtable hashB = (Hashtable)b;
    if ((((Boolean)hashA.get("is_dir")).booleanValue()) && (!((Boolean)hashB.get("is_dir")).booleanValue()))
      return -1;
    if ((!((Boolean)hashA.get("is_dir")).booleanValue()) && (((Boolean)hashB.get("is_dir")).booleanValue())) {
      return 1;
    }
    return ((String)hashA.get("filename")).compareTo((String)hashB.get("filename"));
  }
}