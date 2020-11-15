package offer.arrays_and_matrices;

public class Offer005 {
  public static void main(String[] args) {
    Offer005 offer005 = new Offer005();
    System.out.print(offer005.replaceSpace("We are happy."));
  }

  public String replaceSpace(String s) {
    char[] chars = s.toCharArray();
    StringBuilder stringBuffer = new StringBuilder();
    for (char aChar : chars) {
      if (aChar == ' ') {
        stringBuffer.append("%20");
      } else {
        stringBuffer.append(aChar);
      }
    }
    return stringBuffer.toString();
  }
}
