package com.iu.main.file;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.iu.main.MyTest;

public class CalendarTest extends MyTest{

	@Test
	public void test() {
		// 1/1000밀리세컨드를 이용
		// 칼렌드라는 클래스가 시간을 담당?
		
		Calendar ca = Calendar.getInstance();
		System.out.println(ca);
		System.out.println(ca.getTime());// ca객체를 만들때의 시간정보가 들어 있음
		
		System.out.println(ca.get(Calendar.YEAR));
		System.out.println(ca.get(Calendar.DATE));
		System.out.println(ca.get(Calendar.MONTH));
		// 월만 실제 월에서 -1한 값이 나옴, 0을 1월로 봐서
		
		ca.set(Calendar.YEAR, 1994);
		ca.set(Calendar.MONTH, 0);
		System.out.println(ca.getTime());
		
		System.out.println("=====================");
		ca = Calendar.getInstance();// 들어온 시간이라하고
		Calendar ca2 = Calendar.getInstance();
		ca2.set(2023, 6, 27, 18, 20);// 나간 시간이라고 할때
		
		long l1=ca.getTimeInMillis();
		long l2=ca2.getTimeInMillis();
		long result = l2-l1;
		System.out.println(result/(1000*60));
		
	}

}
