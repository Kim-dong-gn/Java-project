package com.it.java.ssg;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램시작==");
		Scanner sc = new Scanner(System.in); //입력하는 명령어
		System.out.println("명령어를 입력하세요) "); 
		String command = sc.nextLine(); //입력한 값을 저장
		System.out.println("입력된 명령어 : "+command);
		int num = sc.nextInt();
		sc.close();// 스캐너 넣었을 시 반드시 넣어야함
		System.out.println("==프로그램 끝==");
	}
}
