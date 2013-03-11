/**
 * 
 */
package org.hello;

/**===================================================================== 
2.* �ļ���ThreadDemo_01.java 
3.* ����������һ���µ��߳� 
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

//	// ����run����
//	public void run() {
//		for (int count = 1, row = 1; row < 5; row++, count++) {
//			for (int i = 0; i < count; i++) {
//				System.out.print('*');
//			}
//			System.out.println();
//		}
//	}
	public void run() {
		// Ϊ�˸�����ؿ�������ȷ�Ľ���������һ�����ѭ��  
		for(int i = 0 ; i < 50; i++) {
			if(this.getName().equals("Thread1")) {
				synchronized (oShare) {
					oShare.szData = "���ǵ� 1 ���߳�";
					try{  
						Thread.sleep((int)Math.random() * 100);
					}catch(InterruptedException e){} 
					// ������
					System.out.println(this.getName() + ":" + oShare.szData); 
				}
			} else if(this.getName().equals("Thread2")) {
				synchronized (oShare) {
					 oShare.szData = "���ǵ�2 ���߳�";  
					 // Ϊ����ʾ���������⣬��������һ��˯��  
					 try{  
							Thread.sleep((int)Math.random() * 100);
						}catch(InterruptedException e){} 
						// ������
						System.out.println(this.getName() + ":" + oShare.szData); 
				}
			}
		}
	}
}
