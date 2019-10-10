package com.conveyal.object_differ;

/**
 * Enable the comparison of two copies of a map originally designed to use identity equality on the keys.
 * This is a functional interface with a single method, to allow simple lambda syntax.
 */
public interface KeyExtractor<T, U> {

    /**
     * Given an object that does not have equals and hashcode defined, or has non-semantic definitions of these methods,
     * return an object with a working semantic definition of equals and hashcode. This could be one of the original
     * object's fields (e.g. a String id), or a wrapper around the original object or several of its fields which
     * fetches some combination of its fields, or could be a completely new object using some combination of those same
     * fields.
     */
     public U extractKey (T t);

}
