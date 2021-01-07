package br.com.study.strucktsandalgorithms.structs;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

/********************************************************************************************************************
 * The chalenge here is make a dinamic array using just de very basic tools of the Java. So I w'ont use Collections and Stream.
 *
 * The choiced
 */
public class DinamicArrayTest<T> {

    @Test
    public void addNewItem() {
        DinamicArray<Integer> array = new DinamicArray();
        array.put(1);
        Assert.assertEquals(1, array.lenth());
        Assert.assertTrue(array.get(0).equals(1));
        Assert.assertTrue(array.pop().equals(1));
        Assert.assertEquals(0, array.lenth());
    }

    @Test
    public void addNumerousItems() {
        DinamicArray<Integer> array = new DinamicArray();
        array.put(1);
        array.put(2);
        array.put(3);
        array.put(4);
        array.put(5);
        Assert.assertEquals(5, array.lenth());
        Assert.assertTrue(array.get(0).equals(1));
        Assert.assertTrue(array.get(1).equals(2));
        Assert.assertTrue(array.get(4).equals(5));
        Assert.assertTrue(array.pop().equals(5));
        Assert.assertEquals(4, array.lenth());

    }
}
