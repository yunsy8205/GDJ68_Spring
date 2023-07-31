package com.iu.main.file;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.iu.main.MyTest;

public class FileTest extends MyTest{

	@Test
	public void test() {
		//File
		File file = new File("C:\\study\\study1.txt");
		System.out.println(file.exists());//exists()존재하는지 아닌지(true, false)
		System.out.println(file.isFile());
		file=new File("c:\\study", "study.txt");
		
		file=new File("c:\\study");
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println("==============");
		file = new File(file, "ex");
		System.out.println(file.exists());// 해당파일이 존재하는지
		System.out.println(file.isDirectory());
		file.delete();//삭제
		file = new File("C:\\study\\study.txt");
		file.delete();
		
		file = new File("C:\\study");
		//file.delete();// 폴더를 지우려면 아무것도 없어야 지워진다.
		
		String [] list = file.list();//폴더내에 파일의 이름을 꺼내옴
		//향상된 for 문
		//for(Collection에서 모은타입 변수명:Collection변수명)
		for(String str:list) {
			System.out.println(str);
		}
		
		file = new File(file, "t1");
		file.mkdir();// 폴더 만들기
		
		file = new File(file, "sub1\\sub2");
		file.mkdir();// 중간에 없는 폴더가 있으면 폴더가 만들어지지 않음

		file = new File(file, "sub1\\sub2");
		file.mkdirs();// 중간에 없는 폴더가 있으면 없는 폴더도 만들면서 만들어줌
		
	}

}
