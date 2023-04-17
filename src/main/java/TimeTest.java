package main.java;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author zhangyaoyuan
 * @date 2022/03/24
 */
public class TimeTest {

    public static void main(String[] args) {

        String hello = "skdhskjdkjsand";
        System.out.println(hello.substring(0, 3));
        // 1 写好
        List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        // 2 读好
        CopyOnWriteArrayList<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        // if 比 switch 好在有一个CPU分支预测==》也是为什么有序数组比非有序数组对if的判断快

        int number1 = 128;
        long number2 = 128L;
        double number3 = 128.0;
        double number4 = 3*0.1;
        double number5 = 0.3;

        System.out.println(number1 == number2);
        System.out.println(number2 == number3);
        System.out.println(3*0.1 == 0.3);
        System.out.println(number4 == number5);
        System.out.println(3*0.1);

        String str = "dfdffd";
        StringBuilder str2 = new StringBuilder("hello");
        StringBuilder reverse = str2.reverse();
        System.out.println("reverse = " + reverse);

        List<Integer> asList = Arrays.asList(2, 23, 23, 4545, 3232);
//        asList.sort(Comparator.naturalOrder());

        System.out.println(asList);
        System.out.println(asList.toString());
        System.out.println(String.valueOf(asList));

        System.out.println("transPastTime(\"2022-06-14 12:12:12\", 10) = " + transPastTime("2022-06-14 00:02:12", 10));

    }

    public static String transPastTime(String time, int past) {
        String result = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = format.parse(time);
            calendar.setTime(date);
            calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - past);
            Date newData = calendar.getTime();
            result = format.format(newData);
        } catch (ParseException e) {
            System.out.println("====");
        }
        return result;
    }
}
