package sortingtraining.utils;

import sortingtraining.decorators.SortingTimeDecorator;
import sortingtraining.resolver.SortingStrategyResolver;
import sortingtraining.sortalgorythms.SortingStrategy;

import java.util.Arrays;

public class SortingUtil {

    private final SortingStrategyResolver sortingStrategyResolver;

    public SortingUtil(SortingStrategyResolver sortingStrategyResolver) {
        this.sortingStrategyResolver = sortingStrategyResolver;
    }

    public int [] sort(int[] numbers, String strategy) {

        SortingStrategy sortingStrategy = getResolve(strategy);

        int[] sorted = sortingStrategy.sort(numbers);

        System.out.println(Arrays.toString(sorted));

        return sorted;
    }

    private SortingStrategy getResolve(String strategy) {
        return new SortingTimeDecorator(
                sortingStrategyResolver.resolve(strategy)
        );
    }
}
