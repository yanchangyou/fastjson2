package com.alibaba.fastjson2.util;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareUtilsTest {
    @Test
    public void diffToArray() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        JSONArray result = CompareUtils.diffToArray(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "[\n" +
                "\t\n" +
                "]";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void diffToArray3() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'string':123," +
                "'null1':null," +
                "'null2':1," +
                "'objectNull1':null," +
                "'objectNull2':{'number':'abc','string':123,}," +
                "'object1': {'number':'abc','string':123,}," +
                "'arrayNull1': null," +
                "'arrayNull2': [{'number':'abc','string':123,}]," +
                "'array1': [{'number':'abc','string':123,}]," +
                "'field1': [{'number':'abc','string':123,}]," +
                "'field2': {'number':'abc','string':123,}," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'null1':1," +
                "'null2':null," +
                "'objectNull1':{'number':'abc','string':123,}," +
                "'objectNull2':null," +
                "'object2': {'number':'abc','string':123,}," +
                "'arrayNull1': [{'number':'abc','string':123,}]," +
                "'arrayNull2': null," +
                "'array2': [{'number':'abc','string':123,}]," +
                "'field1': {'number':'abc','string':123,}," +
                "'field2': [{'number':'abc','string':123,}]," +
                "}");
        JSONArray result = CompareUtils.diffToArray(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "[\n" +
                "\t{\n" +
                "\t\t\"path\":\"string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":123\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"null1\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":null,\n" +
                "\t\t\"value2\":1\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"null2\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":1,\n" +
                "\t\t\"value2\":null\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"objectNull1\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":null,\n" +
                "\t\t\"value2\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"objectNull2\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t},\n" +
                "\t\t\"value2\":null\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"objectNull2.number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":\"abc\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"objectNull2.string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":123\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"object1\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"arrayNull1\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":null,\n" +
                "\t\t\"value2\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\t\"string\":123\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"arrayNull2\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\t\"string\":123\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"value2\":null\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"arrayNull2[0].number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":\"abc\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"arrayNull2[0].string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":123\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"array1\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\t\"string\":123\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"field1\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\t\"string\":123\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"value2\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"field2\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t},\n" +
                "\t\t\"value2\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\t\"string\":123\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":1\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"objectNull1.number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"objectNull1.string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":123\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"object2\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"arrayNull1[0].number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"arrayNull1[0].string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":123\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"array2\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\t\"string\":123\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t}\n" +
                "]";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat, JSONWriter.Feature.WriteNulls));
    }

    @Test
    public void testDiff() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        JSONObject result = CompareUtils.diff(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "{\n" +
                "\t\n" +
                "}";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testDiff1() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        JSONObject result = CompareUtils.diff(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "{\n" +
                "\t\n" +
                "}";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testDiff2() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'number':'abc'," +
                "'string':123," +
                "'object': {'number':'abc','string':123,}," +
                "'array': [{'number':'abc','string':123,}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':123,'string':'abc',}," +
                "'array': [{'number':123,'string':'abc',}]," +
                "}");
        JSONObject result = CompareUtils.diff(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "{\n" +
                "\t\"number\":{\n" +
                "\t\t\"path\":\"number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"abc\",\n" +
                "\t\t\"value2\":1\n" +
                "\t},\n" +
                "\t\"string\":{\n" +
                "\t\t\"path\":\"string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":123,\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t\"object.number\":{\n" +
                "\t\t\"path\":\"object.number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"abc\",\n" +
                "\t\t\"value2\":123\n" +
                "\t},\n" +
                "\t\"object.string\":{\n" +
                "\t\t\"path\":\"object.string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":123,\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t\"array[0].number\":{\n" +
                "\t\t\"path\":\"array[0].number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"abc\",\n" +
                "\t\t\"value2\":123\n" +
                "\t},\n" +
                "\t\"array[0].string\":{\n" +
                "\t\t\"path\":\"array[0].string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":123,\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t}\n" +
                "}";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testDiff3() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'string':123," +
                "'object': {'number':'abc','string':123,}," +
                "'array': [{'number':'abc','string':123,}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'array': [{'number':123,'string':'abc',}]," +
                "}");
        JSONObject result = CompareUtils.diff(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "{\n" +
                "\t\"string\":{\n" +
                "\t\t\"path\":\"string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":123\n" +
                "\t},\n" +
                "\t\"object\":{\n" +
                "\t\t\"path\":\"object\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"array[0].number\":{\n" +
                "\t\t\"path\":\"array[0].number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"abc\",\n" +
                "\t\t\"value2\":123\n" +
                "\t},\n" +
                "\t\"array[0].string\":{\n" +
                "\t\t\"path\":\"array[0].string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":123,\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t\"number\":{\n" +
                "\t\t\"path\":\"number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":1\n" +
                "\t}\n" +
                "}";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testCompare() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        JSONObject result = CompareUtils.compare(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "{\n" +
                "\t\"number\":{\n" +
                "\t\t\"path\":\"number\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t},\n" +
                "\t\"string\":{\n" +
                "\t\t\"path\":\"string\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t},\n" +
                "\t\"object.number\":{\n" +
                "\t\t\"path\":\"object.number\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t},\n" +
                "\t\"object.string\":{\n" +
                "\t\t\"path\":\"object.string\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t},\n" +
                "\t\"array[0].number\":{\n" +
                "\t\t\"path\":\"array[0].number\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t},\n" +
                "\t\"array[0].string\":{\n" +
                "\t\t\"path\":\"array[0].string\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t}\n" +
                "}";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testCompare1() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'number':11," +
                "'string':'ab'," +
                "'object': {'number':11,'string':'ab',}," +
                "'array': [{'number':11,'string':'ab',}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        System.out.println(json1);
        System.out.println(json2);
        JSONObject result = CompareUtils.compare(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "{\n" +
                "\t\"number\":{\n" +
                "\t\t\"path\":\"number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":true,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":11,\n" +
                "\t\t\"value2\":1\n" +
                "\t},\n" +
                "\t\"string\":{\n" +
                "\t\t\"path\":\"string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":true,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"ab\",\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t\"object.number\":{\n" +
                "\t\t\"path\":\"object.number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":true,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":11,\n" +
                "\t\t\"value2\":1\n" +
                "\t},\n" +
                "\t\"object.string\":{\n" +
                "\t\t\"path\":\"object.string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":true,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"ab\",\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t\"array[0].number\":{\n" +
                "\t\t\"path\":\"array[0].number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":true,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":11,\n" +
                "\t\t\"value2\":1\n" +
                "\t},\n" +
                "\t\"array[0].string\":{\n" +
                "\t\t\"path\":\"array[0].string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":true,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"ab\",\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t}\n" +
                "}";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testCompare2() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'number':'abc'," +
                "'string':123," +
                "'object': {'number':'abc','string':123,}," +
                "'array': [{'number':'abc','string':123,}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':123,'string':'abc',}," +
                "'array': [{'number':123,'string':'abc',}]," +
                "}");
        System.out.println(json1);
        System.out.println(json2);
        JSONObject result = CompareUtils.compare(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "{\n" +
                "\t\"number\":{\n" +
                "\t\t\"path\":\"number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"abc\",\n" +
                "\t\t\"value2\":1\n" +
                "\t},\n" +
                "\t\"string\":{\n" +
                "\t\t\"path\":\"string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":123,\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t\"object.number\":{\n" +
                "\t\t\"path\":\"object.number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"abc\",\n" +
                "\t\t\"value2\":123\n" +
                "\t},\n" +
                "\t\"object.string\":{\n" +
                "\t\t\"path\":\"object.string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":123,\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t\"array[0].number\":{\n" +
                "\t\t\"path\":\"array[0].number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"abc\",\n" +
                "\t\t\"value2\":123\n" +
                "\t},\n" +
                "\t\"array[0].string\":{\n" +
                "\t\t\"path\":\"array[0].string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":123,\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t}\n" +
                "}";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testCompare3() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'string':123," +
                "'object': {'number':'abc','string':123,}," +
                "'array': [{'number':'abc','string':123,}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'array': [{'number':123,'string':'abc',}]," +
                "}");
        System.out.println(json1);
        System.out.println(json2);
        JSONObject result = CompareUtils.compare(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "{\n" +
                "\t\"string\":{\n" +
                "\t\t\"path\":\"string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":123\n" +
                "\t},\n" +
                "\t\"object\":{\n" +
                "\t\t\"path\":\"object\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"array[0].number\":{\n" +
                "\t\t\"path\":\"array[0].number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"abc\",\n" +
                "\t\t\"value2\":123\n" +
                "\t},\n" +
                "\t\"array[0].string\":{\n" +
                "\t\t\"path\":\"array[0].string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":123,\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t\"number\":{\n" +
                "\t\t\"path\":\"number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":1\n" +
                "\t}\n" +
                "}";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testCompareToArray3() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'string':123," +
                "'object': {'number':'abc','string':123,}," +
                "'array': [{'number':'abc','string':123,}]," +
                "'field': [{'number':'abc','string':123,}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'array': [{'number':123,'string':'abc',}]," +
                "'field': {'number':'abc','string':123,}," +
                "}");
        System.out.println(json1);
        System.out.println(json2);
        JSONArray result = CompareUtils.compareToArray(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "[\n" +
                "\t{\n" +
                "\t\t\"path\":\"string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":123\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"object\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"array[0].number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"abc\",\n" +
                "\t\t\"value2\":123\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"array[0].string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":123,\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"field\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\t\"string\":123\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"value2\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":1\n" +
                "\t}\n" +
                "]";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testCompareNull() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'array1':[123]," +
                "'object': {'number':'abc','string':123,}," +
                "'array': [{'number':'abc','string':123,}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'array': [{'number':123,'string':'abc',}]," +
                "}");
        System.out.println(json1);
        System.out.println(json2);
        JSONArray result = CompareUtils.compareToArray(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "[\n" +
                "\t{\n" +
                "\t\t\"path\":\"array1\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":[\n" +
                "\t\t\t123\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"object\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"REMOVE\",\n" +
                "\t\t\"value1\":{\n" +
                "\t\t\t\"number\":\"abc\",\n" +
                "\t\t\t\"string\":123\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"array[0].number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":\"abc\",\n" +
                "\t\t\"value2\":123\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"array[0].string\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"typeEqual\":false,\n" +
                "\t\t\"diffType\":\"MODIFY\",\n" +
                "\t\t\"value1\":123,\n" +
                "\t\t\"value2\":\"abc\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":1\n" +
                "\t}\n" +
                "]";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testCompareArray() {
        JSONObject json1 = null;
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'array': [{'number':123,'string':'abc',}]," +
                "}");
        System.out.println(json1);
        System.out.println(json2);
        JSONArray result = CompareUtils.compareToArray(json1, json2);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        String expected = "[\n" +
                "\t{\n" +
                "\t\t\"path\":\"number\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":1\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"array\",\n" +
                "\t\t\"valueEqual\":false,\n" +
                "\t\t\"diffType\":\"ADD\",\n" +
                "\t\t\"value2\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"number\":123,\n" +
                "\t\t\t\t\"string\":\"abc\"\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t}\n" +
                "]";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testEquals() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'string':'abc'," +
                "'object': {'number':1,'string':'abc',}," +
                "'array': [{'number':1,'string':'abc',}]," +
                "}");
        boolean result = CompareUtils.equals(json1, json2);
        System.out.println(result);
        Object expected = true;
        assertEquals(expected, result);
    }

    @Test
    public void testEquals3() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'string':123," +
                "'object': {'number':'abc','string':123,}," +
                "'array': [{'number':'abc','string':123,}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'array': [{'number':123,'string':'abc',}]," +
                "}");
        boolean result = CompareUtils.equals(json1, json2);
        System.out.println(result);
        Object expected = false;
        assertEquals(expected, result);
    }

    @Test
    public void testSum() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'number':123," +
                "'string':'abc'," +
                "'remove':'abc'," +
                "'object': {'number':'abc','string':123,}," +
                "'array': [{'number':'abc','string':123,}]," +
                "'field': [{'number':'abc','string':123,}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number':1," +
                "'new':'abc'," +
                "'string':'abc'," +
                "'array': [{'number':123,'string':'abc',}]," +
                "'field': {'number':'abc','string':123,}," +
                "}");
        JSONArray list = CompareUtils.compareToArray(json1, json2);
        System.out.println(list.toString(JSONWriter.Feature.PrettyFormat));
        JSONObject result = CompareUtils.sum(list);
        System.out.println(result.toJSONString(JSONWriter.Feature.PrettyFormat));
        Object expected = "{\n" +
                "\t\"equal\":false,\n" +
                "\t\"total\":8,\n" +
                "\t\"valueEqualCount\":1,\n" +
                "\t\"typeEqualCount\":1,\n" +
                "\t\"diffCount\":7,\n" +
                "\t\"addCount\":1,\n" +
                "\t\"removeCount\":2,\n" +
                "\t\"modifyCount\":4\n" +
                "}";
        assertEquals(expected, result.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void testCorner() {
        JSONObject json1 = JSONObject.parseObject("{" +
                "'number-1':123," +
                "'object': {'number-1':'abc','string':123,}," +
                "'array': [{'number-1':'abc','string':123,}]," +
                "}");
        JSONObject json2 = JSONObject.parseObject("{" +
                "'number-1':123," +
                "'object': {'number-1':'abc','string':123,}," +
                "'array': [{'number-1':'abc','string':123,}]," +
                "}");
        JSONArray list = CompareUtils.compareToArray(json1, json2);
        System.out.println(list.toString(JSONWriter.Feature.PrettyFormat));
        Object expected = "[\n" +
                "\t{\n" +
                "\t\t\"path\":\"['number-1']\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"object['number-1']\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"object.string\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"array[0]['number-1']\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"path\":\"array[0].string\",\n" +
                "\t\t\"valueEqual\":true\n" +
                "\t}\n" +
                "]";
        System.out.println(new CompareUtils());
        assertEquals(expected, list.toString(JSONWriter.Feature.PrettyFormat));
    }

    @Test
    public void buildJsonPathKey() {
        String[] keys = new String[]{"a", "a-b", "'ab'", "[ab]", "a.b"};
        String[] expected = new String[]{"a", "['a-b']", "'ab'", "ab", "['a.b']"};
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            String newKey = CompareUtils.buildJsonPathKey(key);
            System.out.println(newKey);
            assertEquals(newKey, expected[i]);
        }
    }
}
