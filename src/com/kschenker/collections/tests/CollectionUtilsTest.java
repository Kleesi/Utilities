package com.kschenker.collections.tests;

import com.kschenker.collections.CollectionUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Author: Kevin Schenker
 * Date: 03.02.2016
 * <p>
 * Project: Utilities
 * Package: com.kschenker.collections.tests
 */
public class CollectionUtilsTest
{

    @Test
    public void containsObjectReference_ReturnFalseIfListIsNull() throws Exception
    {
        assertThat(CollectionUtils.containsObjectReference(null, ""), is(false));
        assertThat(CollectionUtils.containsObjectReference(null, null), is(false));
    }

    @Test
    public void containsObjectReference_ReturnFalseIfListIsEmpty() throws Exception
    {
        List<String> anEmptyStringList = new ArrayList<>();

        assertThat(CollectionUtils.containsObjectReference(anEmptyStringList, null), is(false));
        assertThat(CollectionUtils.containsObjectReference(anEmptyStringList, ""), is(false));
        assertThat(CollectionUtils.containsObjectReference(anEmptyStringList, "abc"), is(false));
    }

    @Test
    public void containsObjectReference_ReturnTrueIfNullIsContainedInList() throws Exception
    {
        List<String> aStringList = Arrays.asList("a", null, "b");
        List<String> anotherStringList = new ArrayList<>();
        anotherStringList.add(null);
        anotherStringList.add("c");

        assertThat(CollectionUtils.containsObjectReference(aStringList, null), is(true));
        assertThat(CollectionUtils.containsObjectReference(anotherStringList, null), is(true));
    }

    @Test
    public void containsObjectReference_ReturnTrueIfNonNullObjectReferenceIsContainedInList() throws Exception
    {
        String aStringContainedInList = "c";
        List<String> aStringList = Arrays.asList("a", "b", null, aStringContainedInList, "d");

        assertThat(CollectionUtils.containsObjectReference(aStringList, aStringContainedInList), is(true));
    }

    @Test
    public void containsObjectReference_ReturnFalseIfObjectReferenceNotContainedInList() throws Exception
    {
        String firstString = "first";
        String secondString = "second";
        String aStringNotContainedInList = "third";
        List<String> aStringList = Arrays.asList(firstString, secondString);

        assertThat(CollectionUtils.containsObjectReference(aStringList, aStringNotContainedInList), is(false));
    }

    @Test(dataProvider = "DataProvider_containsObjectReference")
    public void containsObjectReference_ReturnPredefinedResultWithPredefinedData(List<?> aList, Object anObject,
                                                                                 boolean result) throws Exception
    {
        assertThat(CollectionUtils.containsObjectReference(aList, anObject), is(result));
    }

    @DataProvider(name = "DataProvider_containsObjectReference")
    public static Object[][] provideData_containsObjectReference()
    {
        String firstString = "first";
        String secondString = "second";
        String thirdString = "third";

        Double firstDouble = 1d;
        Double secondDouble = 2d;
        Double aDoubleWithValueOfFirstDouble = new Double(firstDouble);

        assert firstDouble != aDoubleWithValueOfFirstDouble : "Precondition failed: Double objects must be different";

        return new Object[][] {
                { Arrays.asList(firstString, secondString, firstString), firstString, true },
                { Arrays.asList(firstString, secondString, firstString), thirdString, false },
                { Arrays.asList(firstDouble, secondDouble), aDoubleWithValueOfFirstDouble, false },
                { Arrays.asList(firstDouble, secondDouble), null, false },
                { Arrays.asList(firstDouble, secondDouble, null), null, true },
                { null, firstDouble, false },
                { null, null, false },
                };
    }

    @Test
    public void removeObjectReference_DoNothingWhenListIsNull() throws Exception
    {
        CollectionUtils.removeObjectReference(null, null);
        CollectionUtils.removeObjectReference(null, "");
        CollectionUtils.removeObjectReference(null, 3);
    }

    @Test
    public void removeObjectReference_DoNothingWhenObjectNotContainedInList() throws Exception
    {
        String firstString = "first";
        String secondString = "second";
        String stringNotContainedInList = "third";

        List<String> stringList = Arrays.asList(firstString, secondString);
        List<String> copyOfStringList = new ArrayList<>(stringList);

        CollectionUtils.removeObjectReference(stringList, stringNotContainedInList);
        assertThat(stringList, equalTo(copyOfStringList));
    }

    @Test
    public void removeObjectReference_RemoveAtMostOneObjectReferenceWhenContainedInList() throws Exception
    {
        String stringContainedTwiceInList = "twice";
        String stringContainedOnceInList = "once";

        List<String> stringList = new ArrayList<>();
        stringList.add(stringContainedTwiceInList);
        stringList.add(stringContainedOnceInList);
        stringList.add(stringContainedTwiceInList);
        List<String> copyOfStringList = new ArrayList<>(stringList);

        CollectionUtils.removeObjectReference(stringList, stringContainedTwiceInList);
        assertThat(stringList, not(equalTo(copyOfStringList)));
        assertThat(stringList.size(), equalTo(copyOfStringList.size() - 1));
        assertThat(null, stringList.get(0) == stringContainedOnceInList);
        assertThat(null, stringList.get(1) == stringContainedTwiceInList);

        CollectionUtils.removeObjectReference(stringList, stringContainedTwiceInList);
        assertThat(stringList.size(), equalTo(copyOfStringList.size() - 2));
        assertThat(null, stringList.get(0) == stringContainedOnceInList);
    }

    @Test
    public void removeObjectReference_RemoveNullWhenContainedInList() throws Exception
    {
        String firstString = "first";
        String secondString = "second";
        List<String> stringList = new ArrayList<>();
        stringList.add(firstString);
        stringList.add(null);
        stringList.add(secondString);
        List<String> copyOfStringList = new ArrayList<>(stringList);

        CollectionUtils.removeObjectReference(stringList, null);
        assertThat(stringList, not(equalTo(copyOfStringList)));
        assertThat(stringList.size(), equalTo(copyOfStringList.size() - 1));
        assertThat(null, stringList.get(0) == firstString);
        assertThat(null, stringList.get(1) == secondString);
    }
}