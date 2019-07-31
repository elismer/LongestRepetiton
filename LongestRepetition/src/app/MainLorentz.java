package app;

public class MainLorentz {

  public static String arregloToString(int[] a, int begin, int end) {
    String str = new String();
    for (int i = begin; i < end; i++) {
      if (i != end - 1) {
        str = str + a[i] + " ,";
      } else {
        str = str + a[i];
      }
    }
    return "[" + str + "]";
  }

  public static String arregloCharToString(char[] a, int begin, int end) {
    String str = new String();
    for (int i = begin; i < end; i++) {
      if (i != end - 1) {
        str = str + a[i] + " ,";
      } else {
        str = str + a[i];
      }
    }
    return "[" + str + "]";
  }

  /**
   * Retorna un arreglo con las repeticiones del primer caracter.
   *
   * @param s texto a analizar
   * @return arreglo cargado con las repeticiones del primer caracter.
   **/
  private static int[] zFunction(String s) {
    int n = s.length();
    int[] z = new int[n];
    for (int i = 1, l = 0, r = 0; i < n; i++) {
      if (i <= r)
        z[i] = Math.min(r - i + 1, z[i - 1]);
      while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
        z[i] = z[i] + 1;
      }
      if (i + z[i] - 1 > r) {
        l = i;
        r = i + z[i] - 1;
      }
    }
    return z;
  }

  /**
   * Retorna el valor de z en el lugar i.
   *
   * @param z arreglo cargado con las repeticiones del primer caracter
   * @param i lugar a devolver
   * @return valor de z en i.
   **/
  private static int getZ(int[] z, int i) {
    if (0 <= i && i < (int) z.length)
      return z[i];
    else
      return 0;
  }

  /**
   * Devuelve una lista con las ubicaciones de los subcadenas repetidas.
   *
   * @param s texto a analizar
   * @return lista con las ubicaciones de los subcadenas repetidas.
   **/
  public static Par<Integer, Integer> darSubString(String s) {
    Par<Integer, Integer> repetitions = new Par<Integer, Integer>();
    findRepetitions(s, 0, repetitions);
    return repetitions;
  }

  /**
   * Agrega una subcadena si esta repetida a la lista.
   *
   * @param shift
   * @param left
   * @param cntr
   * @param l
   * @param k1
   * @param k2
   * @param repetitions
   * @return la lista con una subcadena repetida.
   **/
  private static void convertToRepetitions(int shift, Boolean left, int cntr, int l, int k1, int k2,
      Par<Integer, Integer> repetitions) {
    for (int l1 = Math.max(1, l - k2); l1 <= Math.min(l, k1); l1++) {
      if (left && l1 == l)
        break;
      int l2 = l - l1;
      int pos = shift + (left ? cntr - l1 : cntr - l - l1 + 1);
      if ((repetitions.scd - repetitions.fst) < ((pos + 2 * l - 1) - pos)) {
        repetitions.fst = pos;
        repetitions.scd = (pos + 2 * l - 1) - pos;
      }
    }
  }

  private static String reverseString(String str) {
    StringBuilder rev = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      rev.append(str.charAt(i));
    }
    return rev.toString();
  }

  public static void findRepetitions(String s, int shift, Par<Integer, Integer> repetitions) {
    int n = s.length();
    if (n == 1)
      return;

    int nu = n / 2;
    int nv = n - nu;
    String u = s.substring(0, nu);
    String v = s.substring(nu, s.length());
    String ru = new String(reverseString(u));

    String rv = new String(reverseString(v));
    findRepetitions(u, shift, repetitions);
    findRepetitions(v, shift + nu, repetitions);

    int[] z1 = zFunction(ru);
    int[] z2 = zFunction(v + '#' + u);
    int[] z3 = zFunction(ru + '#' + rv);
    int[] z4 = zFunction(v);
    for (int cntr = 0; cntr < n; cntr++) {
      int l, k1, k2;
      if (cntr < nu) {
        l = nu - cntr;
        k1 = getZ(z1, nu - cntr);
        k2 = getZ(z2, nv + 1 + cntr);
      } else {
        l = cntr - nu + 1;
        k1 = getZ(z3, nu + 1 + nv - 1 - (cntr - nu));
        k2 = getZ(z4, (cntr - nu) + 1);
      }
      if (k1 + k2 >= l)
        convertToRepetitions(shift, cntr < nu, cntr, l, k1, k2, repetitions);
    }
  }
}