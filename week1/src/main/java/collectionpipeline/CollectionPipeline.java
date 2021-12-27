package collectionpipeline;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public interface CollectionPipeline {

    public <T> List<T> MyConcat(List<T> list, List<T> list2);

    public <T> List<T> MyDifference(List<T> list, List<T> list2);

    public <T> List<T> MyDistinct(List<T> list);

    public <T> List<T> MyFilter(List<T> list, Predicate<? super T> predicate);

    public <T> List<T> MyDrop(List<T> list, Integer n);

    public <T> List<T> MyFlatMap(List<T> list);

    public <T> List<T> MyFlatten(List<List<T>> list);

    public <T> List<List<T>> MyGroupBy(List<T> list, Function<? super T, ? extends T> mapper);

    public <T> List<T> MyIntersection(List<T> list, List<T> list2);

    public <T, R> List<R> MyMap(List<T> list, Function<? super T, ? extends R> mapper);

    public <T> T MyReduce(List<T> list, BinaryOperator<T> accumulator);

    public <T> List<T> MyReject(List<T> list, Predicate<? super T> predicate);

    public <T> List<T> MySort(List<T> list, Comparator<? super T> comparator);

    public <T> List<T> MyUnion(List<T> list, List<T> list2);

    public <T> List<T> MySlice(List<T> list, Integer start, Integer end);
}

