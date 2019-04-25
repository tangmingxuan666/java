package demo;
//该类重的方法都是静态的，所以该类是不需要创建对象的，为了保证不让其他成员创建对象可以将构造函数私有化
public class ArrayToolDemo {
    private  ArrayToolDemo(){

    }
    public  static  int getMax(int[] arr){
        int maxIndex = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>arr[maxIndex]){
                maxIndex =i;
            }
        }
        return arr[maxIndex];
    }

}
