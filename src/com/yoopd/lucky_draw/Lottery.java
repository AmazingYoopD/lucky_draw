package com.yoopd.lucky_draw;

import java.util.ArrayList;
public class Lottery implements Runnable {
    private static int[] LotteryNumbers = { 10, 10, 10, 10, 20, 20, 20, 50, 50,100};
    private static int num = LotteryNumbers.length;
    private static boolean[] flag = new boolean[LotteryNumbers.length];
    public Lottery(int[] arr){
    	LotteryNumbers=arr;
    }
    public void run(){
    	String threadName=Thread.currentThread().getName();
        ArrayList<Integer> list=new ArrayList<>();
        while (true) {
            synchronized (this) {
            	if(num<=0)
            		break;
            	else{
                    int index = (int) (Math.random() * LotteryNumbers.length);
                    int get = LotteryNumbers[index];
					if (flag[index] != true) {
							list.add(get);
							flag[index] = true;
							System.out.println(threadName+ "抽中了一个" + get + "元大奖");
							num--;
						}
					try{
						Thread.sleep(300);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
                 }
             }
        }
        if(list.size()>0)
          System.out.println(threadName+"总共抽中了"+list.size()+"个奖项，"+"分别为"+list+"，总金额为"+allLottery(list)+"元!");
        else
          System.out.println(threadName+"手气真差，一个也没抽到!");
    }
    public int allLottery(ArrayList<Integer> list){
    	int sum=0;
    	for(Integer money:list)
    		sum+=money;
    	return sum;
    }
    
}
