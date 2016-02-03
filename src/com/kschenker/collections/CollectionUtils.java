package com.kschenker.collections;

import java.util.List;

/**
 * Author: Kevin Schenker
 * Date: 03.02.2016
 * <p>
 * Project: Utilities
 * Package: com.kschenker.collections
 */
public class CollectionUtils
{
    private CollectionUtils()
    {

    }

    public static boolean containsObjectReference(List<?> aList, Object anObject)
    {
        if (aList == null)
        {
            return false;
        }

        for (Object element : aList)
        {
            if (element == anObject)
            {
                return true;
            }
        }

        return false;
    }
}
