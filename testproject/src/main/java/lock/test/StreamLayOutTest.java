package lock.test;

import org.openjdk.jol.info.ClassLayout;

import java.util.stream.Stream;

public class StreamLayOutTest {
    public static void main(String[] args) {

        /**
         * java.util.stream.ReferencePipeline$Head object internals:
         *  OFFSET  SIZE                                TYPE DESCRIPTION                               VALUE
         *       0     4                                     (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4                                     (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4                                     (object header)                           07 b0 00 20 (00000111 10110000 00000000 00100000) (536915975)
         *      12     4                                 int AbstractPipeline.sourceOrOpFlags          80
         *      16     4                                 int AbstractPipeline.depth                    0
         *      20     4                                 int AbstractPipeline.combinedFlags            95
         *      24     1                             boolean AbstractPipeline.linkedOrConsumed         false
         *      25     1                             boolean AbstractPipeline.sourceAnyStateful        false
         *      26     1                             boolean AbstractPipeline.parallel                 false
         *      27     1                                     (alignment/padding gap)
         *      28     4   java.util.stream.AbstractPipeline AbstractPipeline.sourceStage              (object)
         *      32     4   java.util.stream.AbstractPipeline AbstractPipeline.previousStage            null
         *      36     4   java.util.stream.AbstractPipeline AbstractPipeline.nextStage                null
         *      40     4               java.util.Spliterator AbstractPipeline.sourceSpliterator        (object)
         *      44     4         java.util.function.Supplier AbstractPipeline.sourceSupplier           null
         *      48     4                  java.lang.Runnable AbstractPipeline.sourceCloseAction        null
         *      52     4                                     (loss due to the next object alignment)
         * Instance size: 56 bytes
         * Space losses: 1 bytes internal + 4 bytes external = 5 bytes total
         */
        Stream stream = Stream.of("1");
        String layout2 = ClassLayout.parseInstance(stream).toPrintable();
        System.out.println(layout2);
        long count = stream.count();
        layout2 = ClassLayout.parseInstance(stream).toPrintable();
        System.out.println(layout2);
        System.out.println(count);
    }
}
