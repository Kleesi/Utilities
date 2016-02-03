package com.kschenker.validation;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

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

    public static boolean isSameObject(Object first, Object second)
    {
        if (first == null || second == null)
        {
            return false;
        }

        return first == second;
    }
}
