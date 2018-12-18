package com.conveyal.object_differ;

import com.google.common.primitives.Ints;
import gnu.trove.map.TIntIntMap;

/**
 * Adapts a Trove int-int map to the minimal common Map interface used in comparisons.
 * TODO tests on this and other Trove and Guava comparison adapters
 *
 * Created by abyrd on 2018-11-05
 */
class TIntIntMapWrapper extends MapComparisonWrapper {

    private TIntIntMap map;

    public TIntIntMapWrapper(TIntIntMap map) {
        this.map = map;
    }

    @Override
    public Iterable<Integer> allKeys() {
        return Ints.asList(map.keys());
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(((Number)key).intValue());
    }

    @Override
    public Integer get(Object key) {
        return map.get(((Number)key).intValue());
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object getNoEntryValue () {
        return map.getNoEntryValue();
    }

}
