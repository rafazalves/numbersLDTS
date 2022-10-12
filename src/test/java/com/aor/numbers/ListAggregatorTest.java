package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    List<Integer> list;

    @BeforeEach
    public void helper(){
        list = Arrays.asList(1,2,4,2);
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }
    @Test
    public void distinct() {
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        List<Integer> distinct  = deduplicator.deduplicate(list);

        Assertions.assertEquals(3, distinct.size());
    }

    @Test
    public void max_bug_7263(){

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }
}
