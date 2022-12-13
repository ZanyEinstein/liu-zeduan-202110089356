package test;

import java.util.ArrayList;

public class SchoolSystem implements IParams,ISignUp{ //here 

	int big = 0, medium = 0,small = 0;//variate
	SchoolSystem (Integer big, Integer medium, Integer small){
		this.big = big;
		this.medium = medium;
		this.small = small;
	}
	public boolean addStudent(int stuType) {
		switch(stuType) {
		case 1:
			if(this.big>0) {
				this.big--;
				return true;
			}else if(this.big<=0) {
				return false;
			}
			break;
		case 2:
			if(this.medium>0) {
				this.medium--;
				return true;
			}else if(this.medium<=0) {
				return false;
			}
			break;
		case 3:
			if(this.small>0) {
				this.small--;
				return true;
			}else if(this.small<=0) {
				return false;
			}
			break;
		}
		return false;
	}
	String[] parse(String input) {
		String a = input.replaceAll("\\s+", ""); //ȥ����ҳ�����С��Ʊ����
		String b = a.replaceAll("\\[", ""); //ȥ��������
		String c = b.replaceAll("\\]", ""); //ȥ��������
		String d= c.replaceAll("\\p(Punct}", " "); //����ַ����ɿո�
		String e=d.replaceAll(" ", "x"); //�ո񻻳�x
		String[] s =e.split("x"); //��x�ָ�
		return s;
	}
	public void print() {
		
	}
	public int getBig() {
		return this.big;
	}
	@Override
	public int getMedium() {
		return this.medium;
	}
	@Override
	public int getSmall() {
		return this.small;
	}
	@Override
	public ArrayList<Integer> getPlanSignUp() {
		return null;
	}
	public static void main(String[] args) throws Exception {
      IParams params = ISignUp.parse();//SchoolSystem.parse();
      SchoolSystem sc = new SchoolSystem(params.getBig(), params.getMedium(),params.getSmall());
      ArrayList<Integer> plan = params. getPlanSignUp ();
      for (int i = 0; i < plan.size(); i++) {
          sc.addStudent(plan.get(i));
      }
      sc.print();
	}
}
//������ѧ�ӿ�
interface ISignUp{
  // ��ӡ������
	public void print();
  // ����Ƿ��� stuType��Ӧ�İ༶����
  // ���û��ʣ������뷵�� false ������ѧ������������ð༶������ true
	public boolean addStudent (int stuType);
  // ��������������Ĳ�������ʽ�������ĵ�����
	public static IParams parse() throws Exception{
		return null;
	};
}
interface IParams {
  // ��ȡ�������
  public int getBig();
  // ��ȡ�а�����
  public int getMedium();
  // ��ȡС������
  public int getSmall();
  // ��ȡ��ѧ���У����� [1 2 2 3] ��ʾ���α�����ѧһ����ࡢ�аࡢ�аࡢС��ѧ��
  public ArrayList<Integer> getPlanSignUp ();
}
