import java.util.ArrayList;

public class Keytest {
  public static void main(String[] args) {
    String key = args[0];
    ArrayList<Character> charKey = new ArrayList<Character>();
    ArrayList<Character> mutatedKey = new ArrayList<Character>();
    ArrayList<Character> constructorArray = new ArrayList<Character>();
    int keylength = key.length();
    int y = 0;
    int passes = 0;
    int currentsize = 0;
    boolean flip = false;
    int keysize = 255;

    for (char x : key.toCharArray()) {
      charKey.add(x);
    }
    mutatedKey = charKey;
    System.out.println("Key entered = " + charKey.toString());
    System.out.println("mutated Key = " + mutatedKey.toString());

    while (mutatedKey.size() <= keysize) {
      currentsize = mutatedKey.size();
      constructorArray.clear();

      for (int x = 0; x < currentsize; x++) {
        // add character to new string at index of x
        constructorArray.add(mutatedKey.get(x));
        if (!flip) {
          if (x < charKey.size() - 1) {
            // insert character into new string at index of x
            constructorArray.add(charKey.get(y));
          } else {
            // adjust character used to add to new string if end of original key reached
            y = charKey.size() - 2;
            flip = true;
          }
          y++;
        }
        if (flip) {
          if (!(y < 0)) {
            constructorArray.add(charKey.get(y));
          } else {
            flip = false;
          }
        }
      }

      passes ++;
      //System.out.println(mutatedKey);
      //mutatedKey = constructorArray.;
      int p = 0;
      for (char w : constructorArray) {
        mutatedKey.add(p, w);
        p++;
      }
      System.out.print("\rMutating Key:" + (passes / (keysize / key.length())) * 100 / 4
          + "% pass #" + passes + " Key size = " + mutatedKey.size());
    }

    System.out.print("\nmutated Key = ");
    for (char x : mutatedKey) {
      System.out.print(x);
    }
    System.out.println();
  }
}