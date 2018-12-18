package com.conveyal.object_differ;

/**
 * This provides a small subset of Map functionality across several Map-like classes that do not naturally share a
 * common superclass. The functions provided are just enough to allow comparing two maps in a read-only manner.
 *
 * Created by abyrd on 2018-11-02
 */
abstract class MapComparisonWrapper {

    public abstract Iterable<?> allKeys();

    public abstract boolean containsKey(Object key);

    public abstract Object get(Object key);

    public abstract int size();

    /**
     * @return the value this map uses to represent a missing entry. This is usually null but must be a numeric value
     *         for primitive maps.
     */
    public Object getNoEntryValue() {
        return null;
    }

}
