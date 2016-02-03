package com.kschenker.collections.tests;

import com.kschenker.collections.CollectionUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
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
}