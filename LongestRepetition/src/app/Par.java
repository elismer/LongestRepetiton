package app;

public class Par<L, R> {

  public L fst;
  public R scd;

  public Par(L fst, R scd) {
    this.fst = fst;
    this.scd = scd;
  }

  public Par() {
    this.fst = null;
    this.scd = null;
  }

  public L getLeft() {
    return fst;
  }

  public R getRight() {
    return scd;
  }

  @Override
  public int hashCode() {
    return fst.hashCode() ^ scd.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Par))
      return false;
    Par<L, R> pairo = (Par) o;
    return this.fst.equals(pairo.getLeft()) && this.scd.equals(pairo.getRight());
  }

}