package collectionpipeline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

public class CollectionPipelineMethods implements CollectionPipeline {

    @Override
    public <T> List<T> MyConcat(List<T> list, List<T> list2) {
        List<T> newList = Stream.concat(list.stream(), list2.stream())
                .collect(toList());
        return newList;
    }

    @Override
    public <T> List<T> MyDifference(List<T> list, List<T> list2) {
        return list.stream()
                .filter(element -> !list2.contains(element))
                .collect(toList());
    }

    @Override
    public <T> List<T> MyDistinct(List<T> list) {
        return list.stream().distinct().collect(toList());
    }

    @Override
    public <T> List<T> MyFilter(List<T> list, Predicate<? super T> predicate) {
        return list.stream().filter(predicate).collect(toList());
    }

    @Override
    public <T> List<T> MyDrop(List<T> list, Integer n) {
        return list.subList(0, n);
    }

    @Override
    public <T> List<T> MyFlatMap(List<T> list) {
        return null;
    }

    @Override
    public <T> List<T> MyFlatten(List<List<T>> list) {
        List<T> ls = new ArrayList<T>();
        list.forEach(ls::addAll);
        return ls;
    }

    @Override
    public <T> List<List<T>> MyGroupBy(List<T> list, Function<? super T, ? extends T> function) {
        return null;
    }

    @Override
    public <T> List<T> MyIntersection(List<T> list, List<T> list2) {
        return list.stream()
                .distinct()
                .filter(list2::contains).collect(Collectors.toList());
    }

    @Override
    public <T, R> List<R> MyMap(List<T> list, Function<? super T, ? extends R> mapper) {
        return list.stream().map(mapper).collect(Collectors.toList());
    }

    @Override
    public <T> T MyReduce(List<T> list, BinaryOperator<T> accumulator) {
        return list.stream().reduce(accumulator).orElseGet(null);
    }

    @Override
    public <T> List<T> MyReject(List<T> list, Predicate<? super T> predicate) {
        return list.stream().filter(not(predicate)).collect(toList());
    }

    @Override
    public <T> List<T> MySort(List<T> list, Comparator<? super T> comparator) {
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }


    @Override
    public <T> List<T> MyUnion(List<T> list, List<T> list2) {
        return Stream.concat(list.stream(), list2.stream())
                .distinct().collect(toList());
    }

    @Override
    public <T> List<T> MySlice(List<T> list, Integer start, Integer end) {
        return list.subList(start, end);
    }
}
