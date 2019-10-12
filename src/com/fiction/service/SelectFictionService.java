package com.fiction.service;

import java.util.List;

import com.fiction.dao.SelectFictionDao;
import com.fiction.entity.SelectFiction;

public class SelectFictionService {
	
		SelectFictionDao sfd = new SelectFictionDao();
	//��ҳ���ҳ����Ӧ������
		public List<SelectFiction> getAllSelectPage(int page){
			return sfd.getAllSelectPage(page);
		}
	//��ȡ ������
		public int getAllCount(){
			return sfd.getAllCount();
		}
	//���С˵
		public void addSelect(SelectFiction sf){
			sfd.addSelect(sf);
		}
	//����id������
		public SelectFiction getSelectById(int id){
			return sfd.getSelectById(id);
		}
	//�޸�С˵
		public void updateSelect(SelectFiction sf){
			sfd.updateSelect(sf);
		}
	//����ɾ��С˵
		public void deleteSelectById(int id){
			sfd.deleteSelectById(id);
		}
	//����ɾ��
	public void deleteAllSelect(String[] ids){
		if(ids!=null){
			for(String i:ids){
				int id = Integer.parseInt(i);
				sfd.deleteSelectById(id);
			}
		}
	}
	//������������ģ����ѯ
		public List<SelectFiction> getSelectByName(String selectqq_name,int page){
			return sfd.getSelectByName(selectqq_name, page);
		}
	//��ȡ�û���������ģ����ѯ
	public int getByNameCount(String selectqq_name){
		return sfd.getByNameCount(selectqq_name);
	}
	//�����������в�ѯ����
	public List<SelectFiction> ZhanByNameTwo(String selectqq_name){
			return sfd.ZhanByNameTwo(selectqq_name);
	}
	
}
