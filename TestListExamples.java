import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

class Checker implements StringChecker {
  public boolean checkString(String s) {
      return s.contains("and");
  }
}

public class TestListExamples {
  @Test(timeout = 100)
  public void testTimeout() {
    while(true) {}
  }
  // Write your grading tests here!
  @Test
  public void testFilter() {
    List<String> input1 = new ArrayList<>();
    StringChecker sc = new Checker();

    String[] newarray1 = {"command","cruel","land","treat","panda","brand"};
    for(String t: newarray1) { input1.add(t); }
    
    List<String> result1 = new ArrayList<>();

    String[] temp1 = {"command","land","panda","brand"};
    for(String t: temp1) { result1.add(t); }

    assertEquals(result1, ListExamples.filter(input1, sc));
}

@Test
public void testMerge() {

    List<String> array1 = new ArrayList<>();
    String[] tempArray1 = {"apple","cat","elephant","goat","zebra"};
    for(String t: tempArray1) { array1.add(t); }
    
    List<String> array2 = new ArrayList<>();
    String[] tempArray2 = {"bat","donkey","fox","hippo","kangroo","parrot","racoon"};
    for(String t: tempArray2) { array2.add(t); }

    List<String> result1 = new ArrayList<>();
    String[] Answer1 = {"apple","bat","cat","donkey","elephant","fox","goat","hippo","kangroo","parrot","racoon","zebra"};
    for(String t: Answer1) { result1.add(t); }

    assertEquals(result1, ListExamples.merge(array1, array2));
  }
}
