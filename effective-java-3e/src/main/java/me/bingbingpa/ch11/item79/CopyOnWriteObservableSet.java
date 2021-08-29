package me.bingbingpa.ch11.item79;

import me.bingbingpa.ch04.item18.ForwardingSet;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteObservableSet<E> extends ForwardingSet<E> {

    private final List<CopyOnWriteSetObserver<E>> observers = new CopyOnWriteArrayList<>();

    public CopyOnWriteObservableSet(Set<E> set) {
        super(set);
    }

    public void addObserver(CopyOnWriteSetObserver<E> observer) {
        observers.add(observer);
    }

    public boolean removeObserver(CopyOnWriteSetObserver<E> observer) {
        return observers.remove(observer);
    }

    private void notifyElementAdded(E element) {
        for (CopyOnWriteSetObserver<E> observer : observers) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);
        if (added) {
            notifyElementAdded(e);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result |= add(element);
        }
        return result;
    }
}
