package com.kschenker.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Author: Kevin Schenker
 * Date: 03.02.2016
 * <p>
 * Project: Utilities
 * Package: com.kschenker.validation
 */
public class Validator
{
    private Validator()
    {

    }

    public static boolean isNullOrEmpty(String aString)
    {
        return aString == null || aString.isEmpty();
    }

    public static <E> boolean isNullOrEmpty(Collection<E> aCollection)
    {
        return aCollection == null || aCollection.isEmpty();
    }

    public static boolean isSameObject(Object anObject, Object anotherObject)
    {
        if (anObject == null || anotherObject == null)
        {
            return false;
        }

        return anObject == anotherObject;
    }

    public static boolean haveSameObjectReferences(List<?> aList, List<?> anotherList)
    {
        if (aList == null || anotherList == null)
        {
            return false;
        }

        if (aList.size() != anotherList.size())
        {
            return false;
        }

        List<?> copyOfAnotherList = new ArrayList<>(anotherList);
        return false;

    }


}
