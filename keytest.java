import java.util.ArrayList;

public class keytest {
  public static void main(String[] args) {
    String key = args[0];
    ArrayList<Character> charKey = new ArrayList<Character>();
    ArrayList<Character> mutatedKey = new ArrayList<Character>();
    ArrayList<Character> constructorArray = new ArrayList<Character>();
    int keylength = key.length();
    int y=0;
    for(char x : key.toCharArray()){
      charKey.add(x);
    }
    mutatedKey = charKey;

    System.out.println("Key entered = "+ charKey.toString());
    while(mutatedKey.size() <= 255){
      for(int x=0; x <= mutatedKey.size(); x++){
        constructorArray.add(mutatedKey.get(x));
        if(x<=keylength){
          constructorArray.add(charKey.get(y));

        }else{
          y = 0;
          constructorArray.add(charKey.get(y));
        }
        y++;
        mutatedKey = constructorArray;
        System.out.println("mutated Key = "+mutatedKey.toString());
      }
    }
  }
}