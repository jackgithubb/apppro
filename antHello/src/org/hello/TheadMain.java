/**
 * 
 */
package org.hello;

/**
 * @author jack
 *
 */
public class TheadMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShareData oShare = new ShareData();
		ThreadDemo th1 = new ThreadDemo("Thread1", oShare);
		ThreadDemo th2 = new ThreadDemo("Thread2", oShare);
		// Æô¶¯Ïß³Ì
		th1.start();
		th2.start();
	}

}
