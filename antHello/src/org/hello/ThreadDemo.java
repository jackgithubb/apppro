/**
 * 
 */
package org.hello;

/**===================================================================== 
2.* 文件：ThreadDemo_01.java 
3.* 描述：产生一个新的线程 
4.* ====================================================================== 
5.*/  
class ThreadDemo extends Thread {
	
	private ShareData oShare;
	ThreadDemo() {
	}

	ThreadDemo(String szName, ShareData oShare) {
		super(szName);
		this.oShare = oShare;
	}

//	// 重载run函数
//	public void run() {
//		for (int count = 1, row = 1; row < 5; row++, count++) {
//			for (int i = 0; i < count; i++) {
//				System.out.print('*');
//			}
//			System.out.println();
//		}
//	}
	public void run() {
		// 为了更清楚地看到不正确的结果，这里放一个大的循环  
		for(int i = 0 ; i < 50; i++) {
			if(this.getName().equals("Thread1")) {
				synchronized (oShare) {
					oShare.szData = "这是第 1 个线程";
					try{  
						Thread.sleep((int)Math.random() * 100);
					}catch(InterruptedException e){} 
					// 输出结果
					System.out.println(this.getName() + ":" + oShare.szData); 
				}
			} else if(this.getName().equals("Thread2")) {
				synchronized (oShare) {
					 oShare.szData = "这是第2 个线程";  
					 // 为了演示产生的问题，这里设置一次睡眠  
					 try{  
							Thread.sleep((int)Math.random() * 100);
						}catch(InterruptedException e){} 
						// 输出结果
						System.out.println(this.getName() + ":" + oShare.szData); 
				}
			}
		}
	}
}
