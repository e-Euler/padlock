import java.util.ArrayList;

public class keytest {
  public static void main(String[] args) {
    String key = args[0];
    ArrayList<Character> charKey = new ArrayList<Character>();
    ArrayList<Character> mutatedKey = new ArrayList<Character>();
    ArrayList<Character> constructorArray = new ArrayList<Character>();
    int keylength = key.length();
    int y=0;
    int passes = 0;
    int currentsize = 0;
    for(char x : key.toCharArray()){
      charKey.add(x);
    }
    mutatedKey = charKey;
    System.out.println("Key entered = "+ charKey.toString());
    System.out.println("mutated Key = "+mutatedKey.toString());

    while(mutatedKey.size() <= 255){
      currentsize = mutatedKey.size();
      for(int x=0; x < currentsize; x++){
        constructorArray.add(mutatedKey.get(x));
        if(x<charKey.size() & !(y >= charKey.size())){
          constructorArray.add(charKey.get(y));
        }else{
          y = 0;
          constructorArray.add(charKey.get(y));
        }
        y++;
        passes ++;

        System.out.print("\rMutating Key:"+ (passes/(255/key.length()))*100+"% pass #"+passes+" Key size = "+mutatedKey.size());
      }
      System.out.println(mutatedKey);
      mutatedKey = constructorArray;
    }

    System.out.print("\nmutated Key = ");
    for(char x : mutatedKey){
      System.out.print(x);
    }
    System.out.println();
  }
}