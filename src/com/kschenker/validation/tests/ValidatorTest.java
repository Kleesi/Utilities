package com.kschenker.validation.tests;

import com.kschenker.validation.Validator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
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
    public void testIsNullOrEmpty() throws Exception
    {
        assertThat("Not implemented yet", false);

    }


    @Test
    public void isNullOrEmpty_FeatureToTest() throws Exception
    {
        assertThat("Not implemented yet", false);

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