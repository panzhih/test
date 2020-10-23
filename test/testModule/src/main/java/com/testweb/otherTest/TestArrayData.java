package com.testweb.otherTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.testweb.BasicTest.ResultEnum;
import com.testweb.BasicTest.ServerResult;
import org.apache.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestArrayData {

    public static void main(String[] args){
        /*Integer a = 100;
        Integer b = 100;

        Integer num1 = 400;
        int num2 = 400;
        System.out.println(a == b);
        System.out.println(num1 == num2);

        System.out.println(new Gson().toJson(new ServerResult(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMsg())));
*/
        Set<String> set1 = new HashSet<>();
        for(int i = 0; i<300000;i++){
            set1.add("set_"+i);
        }
        Set<String> set2 = new HashSet<>();
        for(int i = 0;i<300010;i++){
            set2.add("set_"+i);
        }

        Set<String> qcSet = new HashSet<>();
        qcSet.addAll(set2);
        qcSet.removeAll(set1);

        System.out.println("qcSetSize"+qcSet.size()+"=="+qcSet);



        /*String datastr = "{\"cusCity\":\"\",\"device\":\"设备凯旋\",\"card\":46464664548484}";
        JSONObject dataJson2=new JSONObject(datastr);
        Gson gson = new Gson();
        System.out.println(dataJson2.get("cusCity"));*/

        /*List<String> lists = new ArrayList<>();
        lists.add("2020-09-02 01:00:00");
        lists.add("2020-09-03 02:00:00");
        lists.add("2020-10-04 04:00:00");
        //lists.add(null);
        new TestArrayData().sort(lists);*/

        /*String field2 = "[{\"json\":\"2020-09-01 00:00:00-24:00:00;2020-09-02 00:00:00-24:00:00;2020-09-03 00:00:00-24:00:00;2020-09-04 00:00:00-24:00:00;2020-09-05 00:00:00-24:00:00;2020-09-06 00:00:00-24:00:00\",\"materialId\":\"9022,8918,9041,9040,9038,8917,8916,9021,8814,8812,8548,8632\",\"showEffectId\":\"\",\"materialType\":\"IMAGE\"}]";
        Map<Object, Object> scheduleMap = new HashMap<>();
        scheduleMap.put("field2",field2);
        List<String> times = getScheduleDate(scheduleMap);
        System.out.println("之前="+new Gson().toJson(times));
        sort(times);
        System.out.println("之后="+new Gson().toJson(times));*/
    }
    /*
    ["2020-09-01 00:00:00","2020-09-02 00:00:00","2020-09-01 00:00:00","2020-09-02 00:00:00","2020-09-01 00:00:00",
    "2020-09-02 00:00:00",
    "2020-09-01 00:00:00","2020-09-02 00:00:00","2020-09-01 00:00:00","2020-09-02 00:00:00","2020-09-01 00:00:00",
    "2020-09-02 00:00:00",
    "2020-09-01 00:00:00","2020-09-02 00:00:00","2020-09-01 00:00:00","2020-09-02 00:00:00","2020-09-01 00:00:00",
    "2020-09-02 00:00:00",
    "2020-09-01 00:00:00","2020-09-02 00:00:00","2020-09-01 00:00:00","2020-09-02 00:00:00","2020-09-01 00:00:00",
    "2020-09-02 00:00:00",
    "2020-09-02 00:00:00","2020-09-03 00:00:00","2020-09-02 00:00:00","2020-09-03 00:00:00","2020-09-02 00:00:00",
    "2020-09-03 00:00:00",
    "2020-09-02 00:00:00","2020-09-03 00:00:00","2020-09-02 00:00:00","2020-09-03 00:00:00","2020-09-02 00:00:00",
    "2020-09-03 00:00:00",
    "2020-09-02 00:00:00","2020-09-03 00:00:00","2020-09-02 00:00:00","2020-09-03 00:00:00","2020-09-02 00:00:00",
    "2020-09-03 00:00:00",
    "2020-09-02 00:00:00","2020-09-03 00:00:00","2020-09-02 00:00:00","2020-09-03 00:00:00","2020-09-02 00:00:00",
    "2020-09-03 00:00:00","2020-09-03 00:00:00","2020-09-04 00:00:00","2020-09-03 00:00:00",
    "2020-09-04 00:00:00","2020-09-03 00:00:00","2020-09-04 00:00:00","2020-09-03 00:00:00","2020-09-04 00:00:00",
    "2020-09-03 00:00:00","2020-09-04 00:00:00","2020-09-03 00:00:00","2020-09-04 00:00:00","2020-09-03 00:00:00",
    "2020-09-04 00:00:00","2020-09-03 00:00:00","2020-09-04 00:00:00","2020-09-03 00:00:00","2020-09-04 00:00:00",
    "2020-09-03 00:00:00","2020-09-04 00:00:00","2020-09-03 00:00:00","2020-09-04 00:00:00","2020-09-03 00:00:00",
    "2020-09-04 00:00:00","2020-09-04 00:00:00","2020-09-05 00:00:00","2020-09-04 00:00:00","2020-09-05 00:00:00",
    "2020-09-04 00:00:00","2020-09-05 00:00:00","2020-09-04 00:00:00","2020-09-05 00:00:00","2020-09-04 00:00:00",
    "2020-09-05 00:00:00","2020-09-04 00:00:00","2020-09-05 00:00:00","2020-09-04 00:00:00","2020-09-05 00:00:00",
    "2020-09-04 00:00:00","2020-09-05 00:00:00","2020-09-04 00:00:00","2020-09-05 00:00:00","2020-09-04 00:00:00",
    "2020-09-05 00:00:00","2020-09-04 00:00:00","2020-09-05 00:00:00","2020-09-04 00:00:00","2020-09-05 00:00:00",
    "2020-09-05 00:00:00","2020-09-06 00:00:00","2020-09-05 00:00:00","2020-09-06 00:00:00","2020-09-05 00:00:00",
    "2020-09-06 00:00:00","2020-09-05 00:00:00","2020-09-06 00:00:00","2020-09-05 00:00:00","2020-09-06 00:00:00",
    "2020-09-05 00:00:00","2020-09-06 00:00:00","2020-09-05 00:00:00","2020-09-06 00:00:00","2020-09-05 00:00:00",
    "2020-09-06 00:00:00","2020-09-05 00:00:00","2020-09-06 00:00:00","2020-09-05 00:00:00","2020-09-06 00:00:00",
    "2020-09-05 00:00:00","2020-09-06 00:00:00","2020-09-05 00:00:00","2020-09-06 00:00:00","2020-09-06 00:00:00",
    "2020-09-07 00:00:00","2020-09-06 00:00:00","2020-09-07 00:00:00","2020-09-06 00:00:00","2020-09-07 00:00:00",
    "2020-09-06 00:00:00","2020-09-07 00:00:00","2020-09-06 00:00:00","2020-09-07 00:00:00","2020-09-06 00:00:00",
    "2020-09-07 00:00:00","2020-09-06 00:00:00","2020-09-07 00:00:00","2020-09-06 00:00:00","2020-09-07 00:00:00",
    "2020-09-06 00:00:00","2020-09-07 00:00:00","2020-09-06 00:00:00","2020-09-07 00:00:00","2020-09-06 00:00:00",
    "2020-09-07 00:00:00","2020-09-06 00:00:00","2020-09-07 00:00:00"]

     */


    public static void sort(List<String> times) {
        //实现排序方法
        Collections.sort(times, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String str1 = (String) o1;
                String str2 = (String) o2;
                if(str1.equals(str2)){
                    System.out.println("str1 == str2");
                }
                if (str1.compareToIgnoreCase(str2) < 0) {
                    return -1;
                }
                return 1;
            }
        });
    }

    private static List<String> getScheduleDate(Map<Object, Object> scheduleMap){
        List<String> scheduleDate = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONArray array = JSON.parseArray(scheduleMap.get("field2").toString());
        for (int i = 0; i < array.size(); i++) {
            JSONObject subObject = (JSONObject) array.get(i);
            String json = subObject.get("json").toString();
            String materialId = subObject.get("materialId").toString();

            //解析获取到的时间Json串,存储TimeBlock信息
            String[] blockArr = json.split(";");//2019-01-15 15：00：00-17：00：00
            for (int j = 0; j < blockArr.length; j++) {//存储timeBlock对象
                String[] timeStr = blockArr[j].split(" ");
                String timeText = StringUtils.isNotEmpty(timeStr[1]) ? timeStr[1] : null;
                String[] section = StringUtils.isNotEmpty(timeText) ? timeText.split(",") : null;
                for (String time : section) {
                    String[] t = time.split("-");
                    String[] ms = materialId.split(",");
                    for(String id : ms){
                        try {
                            String startStr = timeStr[0] + " " + t[0];
                            Date startDate = format.parse(startStr);
                            String endStr = timeStr[0] + " " + t[1];//times.get(times.size() - 1);
                            Date endDate = format.parse(endStr);
                            scheduleDate.add(format.format(startDate));
                            scheduleDate.add(format.format(endDate));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return scheduleDate;
    }
}
