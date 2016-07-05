package com.bzu.util;
import java.util.Date;

public class ThreadTest2 {//为什么结束不了？？？
	public static void main(String[] args) {
		Runner2 f=new Runner2();
		f.run();
		Thread d=new Thread(f);
		d.start();
		try{
			System.out.println("dddddd");
			Thread.sleep(1000);
		}catch(InterruptedException es){
			es.printStackTrace();
			Thread.interrupted();
	
		}
	}
}
class Runner2 implements Runnable{
	public void run(){
		boolean fig=true;
		while(fig){
			System.out.println("...."+ new Date()+"....");
		
			try{
			
				Thread.sleep(1000);
		
			}catch(InterruptedException es){
				es.printStackTrace();
				return;
		
			}
		}
	}
}