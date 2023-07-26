package com.iu.main.bankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public List<BankBookDTO> getList(Pager pager) throws Exception{
//		Map<String, Integer> map = new HashMap<String, Integer>();
		//page     startRow      lastRow
		//1           1             10
		//2           11            20
		//.....
//		int count=10;
//		int startRow=(page-1)*count+1;//count가 바뀌더라도 계속 이용가능
//		int lastRow=page*count;
		
		pager.makeRowNum();
		Long total =bankBookDAO.getTotal();
		pager.makePageNum(total);
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);

		return bankBookDAO.getList(pager);
	}
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setAdd(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setAdd(bankBookDTO);
	}
	
	public int setDelete(Long num)throws Exception{
		return bankBookDAO.setDelete(num);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
}
