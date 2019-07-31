package app;

import java.util.*;

public class LongestRepetition {

  /**
   * Calcula Longest repetition usando D&C.
   *
   * @param text texto a analizar
   * 
   * @returns subString de mayor longitud que se repite .
   */
  public static String repetitionDc(String texto) {
    Par<Integer, Integer> repetidos = MainLorentz.darSubString(texto);
    String res = mostLarge(repetidos, texto);
    return res;
  }

  /**
   * Calcula Longest repetition.
   *
   * @param repetidos par donde se encuentra la palabra repetida mas larga
   * 
   * @param str       texto donde se encuentran los repetidos
   * 
   * @returns subcadena de mayor longitud que se repite .
   */

  public static String mostLarge(Par<Integer, Integer> par, String str) {
    String resultado = str.substring(par.fst, ((par.scd + par.fst) / 2) + 1);
    return resultado;
  }

  /**
   * Devuelve la ubicacion de la primer aparicion de la palabra mas larga. si esta
   * a la izquerda devuelve -1. si esta a la centro devuelve 0. si esta a la
   * derecha devuelve 1.
   * 
   * @param text texto para analizar
   * @return la ubicacion de la primera aparicion de la palabra mas larga
   */
  public static int WhereIsIt(String text) {
    int mid = text.length() / 2;
    Par<Integer, Integer> par = MainLorentz.darSubString(text);
    if (par.fst < mid && mid < par.scd) {
      return 0;
    } else if (mid <= par.fst && mid < par.scd) {
      return 1;
    } else {
      return -1;
    }
  }
}
