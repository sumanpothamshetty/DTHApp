package com.edubridge.DTHApp.DAO;

import java.util.List;

import com.edubridge.DTHApp.Model1.DTH;

public interface DTHDAO {
	int addDTH(DTH d) ;
	List<DTH>getAllDTH();
	DTH getDTH(String name);
	int updateDTH(DTH d);
	int deleteDTH(String name);
	void deleteAllDTH();

}
