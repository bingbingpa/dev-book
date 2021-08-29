package me.bingbingpa.ch11.item79;

@FunctionalInterface
public interface CopyOnWriteSetObserver<E> {

    void added(CopyOnWriteObservableSet<E> set, E element);
}
