package com.ws;

public class Main {
	public static void main(String[] args) {
//		Container class의 init 메소드 실행
		Container.init(); 
		
		new App().run();
//		App 객체의 run 메소드 실행
		Container.close();
//		Container class의 close 메소드 실행 
	}
}