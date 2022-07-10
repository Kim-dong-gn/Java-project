package com.it.java.ssg;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램시작==");
		Scanner sc = new Scanner(System.in); // 입력하는 명령어
		int num=0;
		while (true) {
			System.out.println("명령어를 입력하세요) ");
			String command = sc.nextLine(); // 입력한 값을 저장
			command = command.trim();
			if (command.length()==0) {
				continue;
			}
			if (command.equals("exit")) {
				break;
			} else if (command.equals("article list")) {
				System.out.println("게시글이 없습니다.");
			} else if (command.equals("article write")) {
				System.out.println("제목 : ");
				String title = sc.nextLine();
				System.out.println("내용 : ");
				String body = sc.nextLine();
				num++;
				System.out.println(num+"번째글이 생성되었습니다");
			} else {
				System.out.println(command + "는존재하지않는 명령어입니다.");
			}

		}
		sc.close();// 스캐너 넣었을 시 반드시 넣어야함
		System.out.println("==프로그램 끝==");
	}
}
