import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Histogram {

    private volatile List<Bucket> bucketList;
    private volatile List<Double> outliers;

    public List<Bucket> getBucketList() {
        return bucketList;
    }

    public void setBucketList(List<Bucket> bucketList) {
        this.bucketList = bucketList;
    }

    public List<Double> getOutliers() {
        return outliers;
    }

    public void setOutliers(List<Double> outliers) {
        this.outliers = outliers;
    }


    public Histogram(String intervals){

        outliers = new ArrayList<>();
        bucketList = new ArrayList<>();

        String[] a = intervals.split("\\[");
        for(int i=0; i<a.length; i++){
            if(a[i].split(",").length==2){
                String minValStr = a[i].split(",")[0].trim();
                String maxValStr = a[i].split(",")[1].split("\\)")[0].trim();

                double minVal = Double.parseDouble(minValStr);
                double maxVal = Double.parseDouble(maxValStr);

                // check overlap before adding to bucketlist
                for(int j=0; j<bucketList.size(); j++){
                    if((minVal >= bucketList.get(j).minVal && minVal < bucketList.get(j).maxVal) ||
                                (maxVal > bucketList.get(j).minVal && maxVal <= bucketList.get(j).maxVal) ||
                                (bucketList.get(j).minVal >= minVal && bucketList.get(j).minVal < maxVal) ||
                                (bucketList.get(j).maxVal > minVal && bucketList.get(j).maxVal <= maxVal)){
                        throw new RuntimeException("Intervals overlap error");
                    };
                }

                Bucket bucket = new Bucket(minVal,maxVal);
                bucketList.add(bucket);
            }
        }

        // bucket list will be sort here
        Collections.sort(bucketList);
    }

    /**
     *
     * @param newValue
     */
    public synchronized void insert(double newValue) {

        // 1-find correct bucket
        // It should be find in (log n) in sorted array
        int index = -1;
        for(int i=0; i<bucketList.size(); i++){
            if(newValue>=bucketList.get(i).minVal && newValue<bucketList.get(i).maxVal){
                index=i;
                continue;
            }
        }

        // 2- set bucket or outliers list
        if(index!=-1){
            bucketList.get(index).insideBucket.add(newValue);
        }else{
            outliers.add(newValue);
        }

    }

    /**
     * Print Histogram
     */
    public void printHistogram(){

        System.out.println("***************************");
        System.out.println("        Histogram");
        System.out.println("***************************");

        List<Double> histogramValues = new ArrayList<>();
        for(int i=0; i<bucketList.size(); i++){
            System.out.printf("[%f,%f): %d \n" , bucketList.get(i).minVal , bucketList.get(i).maxVal, bucketList.get(i).insideBucket.size());
            histogramValues.addAll(bucketList.get(i).insideBucket);
        }

        // Calculate mean & variance
        double mean = calculateMean(histogramValues);
        System.out.println("sample mean: " + mean);
        System.out.println("sample variance: " + calculateVariance(histogramValues , mean));

        // Print outliers
        System.out.println("outliers: " + outliers);
    }


    /**
     *
     * @return
     */
    public List<Double> getHistogramValues(){
        List<Double> histogramValues = new ArrayList<>();
        for(int i=0; i<bucketList.size(); i++){
            histogramValues.addAll(bucketList.get(i).insideBucket);
        }

        return histogramValues;
    }

    /**
     *
     * @param values
     * @return
     */
    public double calculateMean(List<Double> values){
        double mean=0;
        for (int i = 0; i < values.size(); i++) {
            mean += values.get(i);
        }
        mean /= values.size();

        return mean;
    }

    /**
     *
     * @param values
     * @param mean
     * @return
     */
    public double calculateVariance(List<Double> values, double mean){
        double variance=0;
        for (int i = 0; i < values.size(); i++) {
            variance += Math.pow(values.get(i) - mean, 2);
        }
        variance /= values.size();
        return variance;
    }

}


class Bucket implements Comparable<Bucket>{
    public double minVal;
    public double maxVal;
    public volatile List<Double> insideBucket;

    public Bucket(double minVal, double maxVal){
        this.minVal = minVal;
        this.maxVal = maxVal;
        insideBucket = new ArrayList<Double>();
    }

    public void clearBucketValues(){
        insideBucket = new ArrayList<Double>();
    }

    @Override
    public int compareTo(Bucket b) {
        return (this.minVal > b.minVal) ? -1 : 0;
    }


}