package ua.edu.ucu.tempseries;
import java.lang.Math;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    double[] myList = new double[10];
    double count_average = 0;
    int lenght_list = 0;

    public TemperatureSeriesAnalysis() {
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) throws InputMismatchException{
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] < -273) {
                throw new InputMismatchException();}
        }
        this.myList = temperatureSeries;
    }

    public double average() throws IllegalArgumentException{
        if (myList.length == 0){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < myList.length; i++) {
                count_average += myList[i];
            }
        count_average = count_average / myList.length;
        return count_average;
    }

    public double deviation()throws IllegalArgumentException {
        if (myList.length == 0){
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < myList.length; i++) {
            double b = Math.pow(myList[i] - average(), 2);
            sum += b;
        }
        double m = Math.sqrt(sum / myList.length);
        return Math.round(m);
    }

    public double min() throws IllegalArgumentException{
        if (myList.length == 0){
            throw new IllegalArgumentException();
        }
        double min = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] < min) {
                min = myList[i];
            }
        }
        return min;
    }

    public double max() throws IllegalArgumentException{
        if (myList.length == 0){
            throw new IllegalArgumentException();
        }
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) {
                max = myList[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero()throws IllegalArgumentException {
        if (myList.length == 0){
            throw new IllegalArgumentException();
        }
        double temp = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (Math.abs(myList[i]) < Math.abs(temp)) {
                temp = myList[i];
            } else if (Math.abs(myList[i]) == Math.abs(temp) && myList[i] > 0) {
                temp = myList[i];
            }
        }
        return temp;
    }

    public double findTempClosestToValue(double tempValue)throws IllegalArgumentException{
        if (myList.length == 0){
            throw new IllegalArgumentException();
        }
        double temp1 = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (Math.abs(myList[i] - tempValue) < Math.abs(temp1 - tempValue)) {
                temp1 = myList[i];
            } else if (Math.abs(myList[i] - tempValue) == Math.abs(temp1 - tempValue) && myList[i] > tempValue) {
                temp1 = myList[i];
            }
        }
        return temp1;
    }
   public double[] findTempsLessThen ( double tempValue){
       int y = 0;
       int x = 0;
        for (int i = 0; i < myList.length; i++){
            if (myList[i] < tempValue){
                y += 1;
            }
        }
        double[]myList1 = new double [y];
       for (int i = 0; i < myList.length; i++){
           if (myList[i] < tempValue){
               myList1[x] = myList[i];
               x += 1;
           }
       }
       return myList1;
    }

    public double[] findTempsGreaterThen ( double tempValue){
        int q = 0;
        int w = 0;
        for (int i = 0; i < myList.length; i++){
            if (myList[i] >= tempValue){
                q += 1;
            }
        }
        double[]myList2 = new double [q];
        for (int i = 0; i < myList.length; i++){
            if (myList[i] >= tempValue){
                myList2[w] = myList[i];
                w += 1;
            }
        }
        return myList2;
    }

    public TempSummaryStatistics summaryStatistics() throws IllegalArgumentException{
        if (myList.length == 0){
            throw new IllegalArgumentException();
        }
        final TempSummaryStatistics test1 = new TempSummaryStatistics(this.average(), this.deviation(), this.min(), this.max());
        return test1;
    }

    public int addTemps(double... temps)throws  InputMismatchException{
        for (int i = 0; i < temps.length; i++)
        {
            if (temps[i] < -273) {throw new InputMismatchException();}
        }
        double[] myList3 = new double[Math.max(myList.length+temps.length, myList.length * 2)];
        for (int i = 0; i < myList.length; i++){
            myList3[i] = myList[i];
        }
        for (int i = 0; i < temps.length; i++){
            myList3[i + myList.length] = temps[i];
        }
        int amount = myList.length + temps.length;
        return amount;
    }
}