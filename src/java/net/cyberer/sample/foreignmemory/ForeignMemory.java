package net.cyberer.sample.foreignmemory;

import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemoryLayout.PathElement;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.SequenceLayout;

public class ForeignMemory {
  private static final long K = 0x400L;
  private static final long M = K * K;

  public static void main(final String[] args) throws InterruptedException {
    // 要素数512M個×64bit(long)=4GB のメモリを割り当てるためのレイアウトを構成する
    SequenceLayout longArrayLayout = MemoryLayout.ofSequence(512L * M,
        MemoryLayout.ofValueBits(Long.SIZE, ByteOrder.nativeOrder()));
    // try-with-resources 構文を使えば、確実にメモリを解放できる
    try (MemorySegment segment = MemorySegment.allocateNative(longArrayLayout)) {
      // 割り当てたメモリのアドレス情報を取得
      MemoryAddress base = segment.baseAddress();

      // long 配列のようにアクセスするための VarHandle を構成する
      VarHandle longElementHandle = longArrayLayout.varHandle(long.class, PathElement.sequenceElement());
      long n = longArrayLayout.elementCount().orElse(0L);

      // i 番目の要素に i*100 を書き込む
      for (long i = 0; i < n; i++) {
        longElementHandle.set(base, i, (long) i * 100);
      }

      // i 番目の要素を取り出し、全部表示するわけにもいかないので、32M個に1回だけ表示する
      for (long i = 0; i < n; i++) {
        long x = (long) longElementHandle.get(base, i);
        if (i % (32L * M) == 0) {
          System.out.println("i=" + i + ", x=" + x);
        }
      }
    }
  }
}
