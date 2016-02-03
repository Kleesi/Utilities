package com.kschenker.validation.tests;

import com.kschenker.validation.Validator;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Author: Kevin Schenker
 * Date: 03.02.2016
 * <p>
 * Project: Utilities
 * Package: com.kschenker.validation.tests
 */
public class ValidatorTest
{
    @Test
    public void isNullOrEmpty_ReturnTrueIfCollectionIsNull() throws Exception
    {
        Collection<String> aCollection = null;
        assertThat(Validator.isNullOrEmpty(aCollection), is(true));
    }

    @Test
    public void isNullOrEmpty_ReturnTrueIfCollectionIsEmpty() throws Exception
    {
        Collection<String> aCollection = Arrays.asList();
        Collection<Double> anotherCollection = Arrays.asList();

        assertThat(Validator.isNullOrEmpty(aCollection), is(true));
        assertThat(Validator.isNullOrEmpty(anotherCollection), is(true));
    }

    @Test
    public void isNullOrEmpty_ReturnFalseIfCollectionHasAtLeastOneElement() throws Exception
    {
        Collection<String> stringCollection = Arrays.asList("a");
        Collection<Double> doubleCollection = Arrays.asList(1d, 2d, 3d);

        assertThat(Validator.isNullOrEmpty(stringCollection), is(false));
        assertThat(Validator.isNullOrEmpty(doubleCollection), is(false));
    }

    @Test
    public void isNullOrEmpty_ReturnTrueIfStringIsNull() throws Exception
    {
        String aString = null;

        assertThat(Validator.isNullOrEmpty(aString), is(true));
    }

    @Test
    public void isNullOrEmpty_ReturnTrueIfStringIsEmpty() throws Exception
    {
        String aString = "";

        assertThat(Validator.isNullOrEmpty(aString), is(true));
    }

    @Test
    public void isNullOrEmpty_ReturnFalseIfStringHasAtLeastOneCharacter() throws Exception
    {
        String aString = "x";

        assertThat(Validator.isNullOrEmpty(aString), is(false));
    }

    @Test
    public void isSameObject_ReturnFalseIfEitherArgumentIsNull() throws Exception
    {
        assertThat(Validator.isSameObject(null, ""), is(false));
        assertThat(Validator.isSameObject(null, null), is(false));
        assertThat(Validator.isSameObject("", null), is(false));
    }

    @Test
    public void isSameObject_ReturnTrueIfArgumentsReferenceSameObject() throws Exception
    {
        String first = "";
        String second = first;

        assertThat(Validator.isSameObject(first, second), is(true));
        assertThat(Validator.isSameObject(second, first), is(true));
    }

}