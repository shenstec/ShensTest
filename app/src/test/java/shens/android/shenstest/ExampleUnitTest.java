package shens.android.shenstest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private String str = "good";

    private char[] chars = {'a','b','c'};


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void numformat(){
        String str = "1";
        Integer m = Integer.valueOf(str);
    }


    Integer[] datas={6,3,5,4,9,7};

    public void bubbleSort(int[] datas){
        for(int i = 0;i <datas.length-1;i++){
            for(int j=0;j<datas.length-1;j++){
                if(datas[j]>datas[j+1]){
                    int temp = datas[j];
                    datas[j] = datas[j+1];
                    datas[j+1] = temp;
                }

                for(int mum:datas){
                    System.out.print(mum+" ");
                }
            }
        }

        for(int mum:datas){
            System.out.print(mum+" ");
        }

    }

    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int k = i;
            // 找出最小值的下标
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            // 将最小值放到未排序记录的第一个位置
            if (k > i) {
                int tmp = a[i];
                a[i] = a[k];
                a[k] = tmp;
            }
        }

    }


    @Test
    public void testchange(){
//        bubbleSort(datas);
        List<Integer> list = Arrays.asList(datas);
        int min = Collections.min(list);
        System.out.print("最小值 "+min);
//        for(int mum:datas){
//            System.out.print(mum+" ");
//        }
//        ExampleUnitTest test = new ExampleUnitTest();
//        test.exchange(str,chars);
//        System.out.print(str);
//        System.out.print(chars);
//        M m1 = new M("一");
//        M m2 = new M("二");
//        m1.start();
//        m2.run();
    }


    public void exchange(String str,char[] chars){
        str = "haha";
        chars[0] = 'g';
    }

    class M extends Thread implements Runnable{

        private String str;

        public M(String str){
            this.str = str;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0 ; i<10;i++){
                System.out.print(str+i);
            }
        }
    }



    @Test
    public void testMath(){
        double num = 35.00;
        System.out.print(num/100);
    }

    private JsonArray jsonArray ;

    @Test
    public void teckTest(){
        jsonArray = new JsonArray();
        for(int i =0;i<10;i++){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id",i);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
        JsonArray jsns = jsonArray.deepCopy();
        JsonObject jsonObject = (JsonObject) jsns.get(0);
        jsonObject.addProperty("id",10);

        System.out.print(jsonArray.toString());

    }



}