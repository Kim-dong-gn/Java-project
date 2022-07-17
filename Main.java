package com.it.java.ssg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램시작==");
		Scanner sc = new Scanner(System.in); // 입력하는 명령어
		int lastnum = 0;

		List<Article> articles = new ArrayList<>();
		while (true) {
			System.out.println("명령어를 입력하세요) ");
			String command = sc.nextLine(); // 입력한 값을 저장
			command = command.trim();
			if (command.length() == 0) {
				continue;
			}
			if (command.equals("exit")) {
				break;
			} else if (command.equals("article write")) {
				int id = lastnum + 1;
				lastnum = id;
				String regDate = Util.main();
				System.out.println("제목 : ");
				String title = sc.nextLine();
				System.out.println("내용 : ");
				String body = sc.nextLine();
				Article article = new Article(id, regDate, title, body);
				articles.add(article);
				System.out.println(id + "번째글이 생성되었습니다");
			} else if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
				} else {
					for (int i = 0; i < articles.size(); i++) {
						Article article = articles.get(i);
						System.out.println(article.id + article.title);
					}
				}
			} else if (command.startsWith("article detail")) {
				String[] commandbits = command.split(" ");
				int id = Integer.parseInt(commandbits[2]);
			
				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지않습니다.\n", id);
					continue;
				} else {
					System.out.println("번호 : " + foundArticle.id);
					System.out.println("제목 : " + foundArticle.title);
					System.out.println("내용 : " + foundArticle.body);
					System.out.println("날짜 : " + foundArticle.regDate);
					
				}
			} else if (command.startsWith("article delete")) {
				String[] commandbits = command.split(" ");
				int id = Integer.parseInt(commandbits[2]);
				
				int foundIndex = -1;
				
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						foundIndex = i;
					
						break;
					}
				}
				if (foundIndex == -1) {
					System.out.printf("%d번 게시물은 존재하지않습니다.\n", id);
					continue;
				} else {
					System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
					articles.remove(foundIndex);
					
					continue;
				}
			}else if(command.startsWith("article modify")) {
				String[] commandbits = command.split(" ");
				int id = Integer.parseInt(commandbits[2]);
			
				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지않습니다.\n", id);
					continue;
				} else {
					System.out.println("제목 : ");
					String title = sc.nextLine();
					System.out.println("내용 : ");
					String body = sc.nextLine();
					foundArticle.title = title;
					foundArticle.body=body;
					System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
				}
			}else {
				System.out.println(command + "는존재하지않는 명령어입니다.");
			}

		}
		sc.close();// 스캐너 넣었을 시 반드시 넣어야함
		System.out.println("==프로그램 끝==");
	}
}

class Article {
	String title;
	String body;
	int id;
	String regDate;


	public Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}
}








