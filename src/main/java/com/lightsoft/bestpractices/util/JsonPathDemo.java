package com.lightsoft.bestpractices.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonPathDemo {

    private static String json = "{\n" +
            "  \"action\": \"/interface.service/xxx/queryBlackUserData\",\n" +
            "  \"all\": \"1\",\n" +
            "  \"result\": {\n" +
            "    \"count\": 2,\n" +
            "    \"tenant_count\": 2,\n" +
            "    \"records\": [\n" +
            "      {\n" +
            "        \"namen\": \"张三\",\n" +
            "        \"pid\": \"500234199212121212\",\n" +
            "        \"mobile\": \"18623456789\",\n" +
            "        \"applied_at\": \"3\",\n" +
            "        \"confirmed_at\": \"5\",\n" +
            "        \"confirm_type\": \"overdue\",\n" +
            "        \"loan_type\": 1,\n" +
            "        \"test\": \"mytest\",\n" +
            "        \"all\": \"2\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"namen\": \"李四\",\n" +
            "        \"pid\": \"500234199299999999\",\n" +
            "        \"mobile\": \"13098765432\",\n" +
            "        \"applied_at\": \"1\",\n" +
            "        \"confirmed_at\": \"\",\n" +
            "        \"confirm_type\": \"overdue\",\n" +
            "        \"loan_type\": 3,\n" +
            "        \"all\": \"3\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"namen\": \"王五\",\n" +
            "        \"pid\": \"50023415464654659\",\n" +
            "        \"mobile\": \"1706454894\",\n" +
            "        \"applied_at\": \"-1\",\n" +
            "        \"confirmed_at\": \"\",\n" +
            "        \"confirm_type\": \"overdue\",\n" +
            "        \"loan_type\": 3\n" +
            "      }\n" +
            "    ],\n" +
            "    \"all\": \"4\"\n" +
            "  },\n" +
            "  \"code\": 200,\n" +
            "  \"subtime\": \"1480495123550\",\n" +
            "  \"status\": \"success\",\n" +
            "  \"ok\": 3\n" +
            "}";

    public static void main(String[] args) {

        log.info("print json message {}", json);

        DocumentContext context = JsonPath.parse(json);
        // 输出姓名
        List<String> names = (List<String>) context.read("$.result.records[*].name");
//        Optional.ofNullable((JSONObject.toJSON(names))).ifPresent(log::getName());
        log.info("find result names= {}", JSONObject.toJSON(names));
        List<Map<String, Object>> records = context.read("$.result.records[*]");
        log.info("find result records= {}", JSONObject.toJSON(records));


//        // 返回数组所有值
//        //两种方式接收json
//        List<Map<String, Object>> records = context.read("$.result.records[*]");
//        Optional.ofNullable(gson.toJson(records)).ifPresent(log::info);
//
//        List<Person> personList = context.read("$.result.records[*]");
//        Optional.ofNullable(gson.toJson(personList)).ifPresent(log::info);
//
//        List<String> nameList0and2List = context.read("$.result.records[0,2].name");
//        Optional.ofNullable(gson.toJson(nameList0and2List)).ifPresent(log::info);
//
//        // not contain last value
//        List<String> nameList0to2List = context.read("$.result.records[0:2].name");
//        Optional.ofNullable(gson.toJson(nameList0to2List)).ifPresent(log::info);
//
//        List<String> lastTwoNames = context.read("$.result.records[-2:].name");
//        Optional.ofNullable(gson.toJson(lastTwoNames)).ifPresent(log::info);
//
//        List<String> nameFromOne = context.read("$.result.records[1:].name");
//        Optional.ofNullable(gson.toJson(nameFromOne)).ifPresent(log::info);
//
//        List<String> nameEndTwo = context.read("$.result.records[:3].name");
//        Optional.ofNullable(gson.toJson(nameEndTwo)).ifPresent(log::info);
//
//        personList = context.read("$.result.records[?(@.name == '李四')]");
//        Optional.ofNullable(gson.toJson(personList)).ifPresent(log::info);
//
//        personList = context.read("$.result.records[?(@.test)]");
//        Optional.ofNullable(gson.toJson(personList)).ifPresent(log::info);
//
//        List<String> existAlllist = context.read("$..all");
//        Optional.ofNullable(gson.toJson(existAlllist)).ifPresent(log::info);
//
//        //12 以当前json的某个值为条件查询 这里ok为1 取出records数组中applied_at等于1的数组
//        List<String> ok = context.read("$.result.records[?(@.applied_at == $['ok'])]");
//        Optional.ofNullable(gson.toJson(ok)).ifPresent(log::info);
//
//        //13 正则匹配
//        personList = context.read("$.result.records[?(@.pid =~ /.*999/i)]");
//        Optional.ofNullable(gson.toJson(personList)).ifPresent(log::info);
//
//        //14 多条件
//        List<String> mobile = context.read("$.result.records[?(@.all == '2' || @.name == '李四' )].mobile");
//        Optional.ofNullable(gson.toJson(mobile)).ifPresent(log::info);
//
//        //14 查询数组长度
//        Integer length01 = context.read("$.result.records.length()");
//        Optional.ofNullable(gson.toJson(mobile)).ifPresent(log::info);
//
//        //15 查询list里面每个对象长度
//        List<Integer> length02 = context.read("$.result.records[?(@.all == '2' || @.name == '李四' )].length()");
//        Optional.ofNullable(gson.toJson(length02)).ifPresent(log::info);
//
//        //16 最大值
//        double maxV = context.read("$.max($.result.records[0].loan_type,$.result.records[1].loan_type,$.result.records[2].loan_type)");
//        Optional.ofNullable(gson.toJson(maxV)).ifPresent(log::info);
//
//        //17 最小值
//        double minV = context.read("$.min($.result.records[0].loan_type,$.result.records[1].loan_type,$.result.records[2].loan_type)");
//        Optional.ofNullable(gson.toJson(minV)).ifPresent(log::info);
//
//        //18 平均值
//        double avgV = context.read("$.avg($.result.records[0].loan_type,$.result.records[1].loan_type,$.result.records[2].loan_type)");
//        Optional.ofNullable(gson.toJson(avgV)).ifPresent(log::info);
//
//        //19 标准差
//        double stddevV = context.read("$.stddev($.result.records[0].loan_type,$.result.records[1].loan_type,$.result.records[2].loan_type)");
//        Optional.ofNullable(gson.toJson(stddevV)).ifPresent(log::info);

    }

}
