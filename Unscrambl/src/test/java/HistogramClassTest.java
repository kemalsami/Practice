import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HistogramClassTest extends TestCase {

    protected Histogram histogram;
    protected Histogram histogramMultiThread;
    protected List<Double> valueList;
    protected int datasetSize = 10000;

    protected void setUp(){
        String histogramIntervals = "[3, 4.1)\n" +
                "[8.5, 8.7)\n" +
                "[0, 1.1)\n" +
                "[31.5, 41.27)";

        histogram = new Histogram(histogramIntervals);
        histogramMultiThread = new Histogram(histogramIntervals);


        // Random dataset
        valueList = new ArrayList<Double>();
        Random random = new Random();
        for(int i=0; i<datasetSize; i++) {
            valueList.add(random.nextInt(50) + (random.nextInt(100) / 100.0));
        }


    }

    @Test
    public void testHistogram(){
        String histogramIntervals = "[3, 4.1)\n" +
                "[8.5, 8.7)\n" +
                "[0, 1.1)\n" +
                "[32, 43)\n" +
                "[31.5, 41.27)";


        System.out.println("-- TEST HISTOGRAM ERROR --");
        Assert.assertThrows(RuntimeException.class,() -> {
            Histogram histogramError = new Histogram(histogramIntervals);
        });

    }


    @Test
    public void testThreadSafe(){

        System.out.println("-- TEST HISTOGRAM ERROR --");
        for(int i=0; i<valueList.size(); i++) {
            histogram.insert(valueList.get(i));
        }

        double meanSingleThread = histogram.calculateMean(histogram.getHistogramValues());
        double varianceSingleThread = histogram.calculateVariance(histogram.getHistogramValues(),meanSingleThread);
        histogram.printHistogram();


        // CLEAR Histogram bucket list
        /*
        for(int i=0; i<histogram.getBucketList().size(); i++) {
            histogram.getBucketList().get(i).clearBucketValues();
        }
        */


        // CALL MULTI THREAD IN POOL
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < valueList.size(); i++) {
            double value = valueList.get(i);
            executorService.submit(() -> {
                histogramMultiThread.insert(value);
            });
        }
        executorService.shutdown();

        try {
            while(!executorService.awaitTermination(10, TimeUnit.SECONDS)){};
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double meanMultiThread = histogramMultiThread.calculateMean(histogramMultiThread.getHistogramValues());
        double varianceMultiThread = histogramMultiThread.calculateVariance(histogramMultiThread.getHistogramValues(),meanSingleThread);
        histogramMultiThread.printHistogram();

        Assert.assertTrue(meanSingleThread==meanMultiThread);
        Assert.assertTrue(varianceSingleThread==varianceMultiThread);

    }

}
