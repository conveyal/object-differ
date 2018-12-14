package com.conveyal.object_differ;

import com.google.common.primitives.Ints;
import gnu.trove.map.TIntObjectMap;

/**
 * Adapts a Trove int-Object hash map to the minimal common Map interface used in comparisons.
 *
 * Created by abyrd on 2018-11-05
 */
class TIntObjectMapWrapper extends MapComparisonWrapper {

    private TIntObjectMap map;

    public TIntObjectMapWrapper(TIntObjectMap map) {
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
    public Object get(Object key) {
        return map.get(((Number)key).intValue());
    }

    @Override
    public int size() {
        return map.size();
    }

}
