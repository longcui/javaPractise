package list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModifiableOrUnModifiableListTest {

    /**
     *can not change the size of class Arrays.ArrayList
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiable() {
        //return type is java.util.Arrays$ArrayList  not java.util.ArrayList
        List<String> strings = Arrays.asList("pek", "pvg", "hk");
        strings.clear();
    }

    /**
     * can not change the size of class Arrays.ArrayList, BUT can change the value!!!
     */
    @Test
    public void testArraysAsList() {
        String[] strings = {"a", "b", "c"};
        List<String> list = Arrays.asList(strings);
        Assert.assertEquals("a", list.get(0));

        strings[0] = "d";
        Assert.assertEquals("d", list.get(0));

        list.set(0, "e");
        Assert.assertEquals("e", list.get(0));
    }

    @Test
    public void testModifiable() {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("pek", "pvg", "hk"));
        strings.clear();
    }



    @Test(expected = UnsupportedOperationException.class)
    public void testModifyCnt() {
        String[] strings = {"a", "b", "c"};

        //below list is of type Arrays$ArrayList
        List<String> list = Arrays.asList(strings);

        list.clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testModifyCnt1() {
        String[] strings = {"a", "b", "c"};

        //below list is of type Arrays$ArrayList
        List<String> list = Arrays.asList(strings);

        list.add("");
    }


    /***************************************************************************************************************/

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiedList1() {
        ArrayList<AClass> arrayList = new ArrayList<AClass>();
        arrayList.add(new AClass("a", "aa", 1));
        arrayList.add(new AClass("b", "bb", 2));
        List<AClass> unmodifiableList = Collections.unmodifiableList(arrayList);
        unmodifiableList.remove(1);
    }

    /**
     *Unmodify means add(), set(), remove() is not supported for the list, NOT for get(0) and then modify.....
     */
    @Test
    public void testUnmodifiedList() {
        ArrayList<AClass> arrayList = new ArrayList<AClass>();
        arrayList.add(new AClass("a", "aa", 1));
        arrayList.add(new AClass("b", "bb", 2));
        List<AClass> unmodifiableList = Collections.unmodifiableList(arrayList);
        unmodifiableList.get(0).amount = 5;
    }


    private class AClass {
        String key, value;
        double amount;

        public AClass(String key, String value, double amount) {
            this.key = key;
            this.value = value;
            this.amount = amount;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
