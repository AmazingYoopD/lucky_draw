package com.yoopd.lucky_draw;

import java.util.Random;

public class Demo {
	public static void main(String[] args) {
		int[] arr = { -1, -1, -1, -1, -1, -1, -1, -1, -1,-1 };
		Random random = new Random();
		int count = 0;
		System.out.print("随机产生抽奖奖项为(元):");
		while (count < arr.length) {
			boolean flag = true;
			int r = random.nextInt(200);
			for (int i = 0; i < arr.length; i++) {
				if (r == arr[i]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				arr[count] = r;
				System.out.print(r + " ");
				if(count==arr.length-1)
					System.out.println();
				count++;
			}
		}
	  System.out.println("张三、李四、王五开始抽奖.......");
	   Lottery lottery = new Lottery(arr);
	   new Thread(lottery,"张三").start();
	   new Thread(lottery,"李四").start();
	   new Thread(lottery,"王五").start();
	 
	}
}
