package shens.android.shenstest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import shens.android.shenstest.simple.pattern.adpter.AutoPlay;
import shens.android.shenstest.simple.pattern.build.Computer;
import shens.android.shenstest.simple.pattern.build.ConcreateBuilder;
import shens.android.shenstest.simple.pattern.build.Director;
import shens.android.shenstest.simple.pattern.factory.abstr.AudiTrunk;
import shens.android.shenstest.simple.pattern.factory.abstr.ProduceFactory;
import shens.android.shenstest.simple.pattern.factory.abstr.BmwTrunk;
import shens.android.shenstest.simple.pattern.factory.abstr.Trunk;
import shens.android.shenstest.simple.pattern.prototype.Resume;
import shens.android.shenstest.simple.pattern.prototype.Student;

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






    /**
     *
     *
     *
     * 通过对象的一个属性进行排序，并且对象的另一个属性满足另外一个条件的情况下 取前10条数据
     * 例如 一个班级有100个学生，首先按照总分进行排序 并抽取平均分在70以上的前10名
     *
     *
     */













    @Test
    public void test(){
        List<Score> list = initData();
        System.out.print(list);
        //首先打印出所有学生的成绩
        for(int i = 0;i<list.size();i++){
            Score score = list.get(i);
            System.out.println("student core id = "+score.getId()+", englishCore = "+score.getEnglishScore()
                    +", mathCore"+score.getMathScore()+",chineseCore = "+score.getChineseScore()+",sportCore = "+score.getSportScore()
                    + ",average = "+score.getAverage());
        }

        System.out.println("============开始排序==============");
        //开始排序
        for(int i = 0; i <list.size();i++){

            for(int j=i+1;j<list.size();j++){
                Score scoreI = list.get(i);
                //计算总分
                double totleI = scoreI.getChineseScore()+scoreI.getMathScore()+scoreI.getEnglishScore()+scoreI.getSportScore();
                scoreI.setTotalScore(totleI);
                scoreI.setAverage(totleI/4);
                list.set(i,scoreI);

                Score scoreJ = list.get(j);
                double totleJ = scoreJ.getChineseScore()+scoreJ.getMathScore()+scoreJ.getEnglishScore()+scoreJ.getSportScore();
                scoreJ.setTotalScore(totleJ);
                scoreJ.setAverage(totleJ/4);
                list.set(j,scoreJ);
                if(totleI<totleJ){
                    list.set(i,scoreJ);
                    list.set(j,scoreI);

                }
            }
        }
        System.out.println("============排序结束==============");
        //查看排序是否正确
        for(int i = 0 ;i<list.size();i++){
            Score score = list.get(i);
            System.out.println("student core totalScore ="+score.getTotalScore()+", id = "+score.getId()+", englishCore = "+score.getEnglishScore()
                    +", mathCore"+score.getMathScore()+",chineseCore = "+score.getChineseScore()+",sportCore = "+score.getSportScore()
                    + ",average = "+score.getAverage());
        }
        System.out.println("============开始抽取==============");
        for(int i = 0;i<10;i++){
            if(list.size()-1>=i){
                Score score = list.get(i);
                if(score.getAverage()<70){
                    list.remove(i);
                    i= i-1;
                }
            }

        }
        System.out.println("============抽取结果==============");
        for(int i = 0;i<list.size();i++){
            Score score = list.get(i);
            System.out.println("student core totalScore ="+score.getTotalScore()+", id = "+score.getId()+", englishCore = "+score.getEnglishScore()
                    +", mathCore"+score.getMathScore()+",chineseCore = "+score.getChineseScore()+",sportCore = "+score.getSportScore()
                    + ",average = "+score.getAverage());
        }
    }

    /**
     * 初始化学生的成绩
     * @return
     */
    private List<Score> initData(){

        List<Score> cores = new ArrayList<>();
        Score core;
        Random random = new Random(1);//初始化随机数  随机100以内的数
        for(int i=1;i<=100;i++){
            core = new Score();
            core.setId(i);
            core.setChineseScore(random.nextInt(100));
            core.setEnglishScore(random.nextInt(100));
            core.setMathScore(random.nextInt(100));
            core.setSportScore(random.nextInt(100));
            cores.add(core);
        }


        return cores;
    }

    /**
     * 学生成绩单
     */
    class Score{
        private int id;// 学生编号
        private double englishScore;//英语成绩
        private double mathScore;//数学成绩
        private double chineseScore;//语文成绩
        private double sportScore;//体育成绩
        private double totalScore;//总分
        private double average;//平均分  平均分为空需要在排序的时候进行计算

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getEnglishScore() {
            return englishScore;
        }

        public void setEnglishScore(double englishScore) {
            this.englishScore = englishScore;
        }

        public double getMathScore() {
            return mathScore;
        }

        public void setMathScore(double mathScore) {
            this.mathScore = mathScore;
        }

        public double getChineseScore() {
            return chineseScore;
        }

        public void setChineseScore(double chineseScore) {
            this.chineseScore = chineseScore;
        }

        public double getSportScore() {
            return sportScore;
        }

        public void setSportScore(double sportScore) {
            this.sportScore = sportScore;
        }

        public double getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(double totalScore) {
            this.totalScore = totalScore;
            this.average = totalScore/4;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }
    }

    @Test
    public void testFactory(){
        ProduceFactory factory = new ProduceFactory();
        AudiTrunk audiTrunk = (AudiTrunk) factory.crateTrunk(AudiTrunk.class);
        audiTrunk.run();
        audiTrunk.getPrice();

        Trunk bmwTrunk = factory.crateTrunk(BmwTrunk.class);
        bmwTrunk.run();


    }

    @Test
    public void testBuilder(){
        ConcreateBuilder builder = new ConcreateBuilder();
        Director director = new Director(builder);
        Computer computer = director.build("Intel","硬盘","主板");
        System.out.println(computer);
    }
    @Test
    public void testPrototye(){
        try {
            Resume resume = new Resume();
            resume.setName("哈啊哈");
            Student student = new Student();
            student.setName("123");
            resume.setStudent(student);

            Resume resume1 = (Resume) resume.clone();

            resume1.setAge(18);


            student.setName("4444");
            resume1.setStudent(student);

            System.out.println(resume);
            System.out.println(resume1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testAdapter(){
        AutoPlay autoPlay = new AutoPlay();
        autoPlay.play("mp3","sdcard/file/1.mp3");
        autoPlay.play("vlc","sdcard/file/2.vlc");
        autoPlay.play("mp4","sdcard/file/3.mp4");

        ArrayList<String> al = new ArrayList<>();
        al.add("one");
        al.add("two");

        Iterator<String> it = al.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        Iterator<String> itll = linkedList.iterator();
        while (itll.hasNext()){
            System.out.println(itll.next());
        }

        HashSet<String> hs = new HashSet<>();
        hs.add("one");
        hs.add("two");
        hs.add("three");

        for(String str:hs){
            System.out.println(str);
        }
        Iterator iterator = hs.iterator();
        while (iterator.hasNext()){
            System.out.println(it.next());
        }

        TreeSet<String> ts = new TreeSet<>();
        ts.add("one");
        ts.add("two");
        ts.add("three");


    }





}