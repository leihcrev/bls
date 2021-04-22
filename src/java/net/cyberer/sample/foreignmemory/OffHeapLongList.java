package net.cyberer.sample.foreignmemory;

import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemoryLayout.PathElement;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.SequenceLayout;

public class OffHeapLongList implements List<Long>, AutoCloseable {
  private final int size;
  private final SequenceLayout layout;
  private final MemorySegment segment;
  private final MemoryAddress base;
  private final VarHandle varHandle;

  public OffHeapLongList(final int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Cannot create 0 or negative size list. size=" + size);
    }
    this.size = size;
    layout = MemoryLayout.ofSequence(size, MemoryLayout.ofValueBits(Long.SIZE, ByteOrder.nativeOrder()));
    segment = MemorySegment.allocateNative(layout);
    try {
      base = segment.baseAddress();
      varHandle = layout.varHandle(long.class, PathElement.sequenceElement());
    } catch (Throwable t) {
      close();
      throw t;
    }
  }

  @Override
  public void close() {
    segment.close();
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean contains(final Object o) {
    if (o instanceof Long l) {
      for (int i = 0; i < size; i++) {
        if (get(i) == l) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public Iterator<Long> iterator() {
    return listIterator();
  }

  @Override
  public Object[] toArray() {
    throw new UnsupportedOperationException();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean add(Long e) {
    return false;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends Long> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends Long> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {
  }

  @Override
  public Long get(int index) {
    return null;
  }

  @Override
  public Long set(int index, Long element) {
    return null;
  }

  @Override
  public void add(int index, Long element) {
  }

  @Override
  public Long remove(int index) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator<Long> listIterator() {
    return null;
  }

  @Override
  public ListIterator<Long> listIterator(int index) {
    return null;
  }

  @Override
  public List<Long> subList(int fromIndex, int toIndex) {
    return null;
  }
}
