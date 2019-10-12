package com.fiction.service;

import java.util.List;

import com.fiction.dao.WholeFictionDao;
import com.fiction.entity.WholeFiction;

public class WholeFictionService {
	WholeFictionDao wfd = new WholeFictionDao();
	//��ҳ������
		public List<WholeFiction> getAllFictionPage(int page){
			return wfd.getAllFictionPage(page);
		}
	//��ȡ ������
		public int getAllCount(){
			return wfd.getAllCount();
		}
	//���С˵
		public void addFiction(WholeFiction wf){	
			wfd.addFiction(wf);
		}
	//����id������
		public WholeFiction getFictionById(int id){
			return wfd.getFictionById(id);
		}
	//�޸�С˵
		public void updateFiction(WholeFiction wf){
			wfd.updateFiction(wf);
		}
	//����ɾ��С˵
		public void deleteFictionById(int id){
			wfd.deleteFictionById(id);
		}
	//����ɾ��
		public void deleteAllFiction(String[] ids){
			if(ids!=null){
				for(String i:ids){
					int id = Integer.parseInt(i);
					wfd.deleteFictionById(id);
				}
			}
		}
	//������������ģ����ѯ
		public List<WholeFiction> getFictionByName(String fiction_name,int page){
			return wfd.getFictionByName(fiction_name, page);
		}
	//��ȡ�û���������ģ����ѯ
		public int getByNameCount(String fiction_name){
			return wfd.getByNameCount(fiction_name);
		}
}
