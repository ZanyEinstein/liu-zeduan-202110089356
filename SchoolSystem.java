package test;

import java.util.ArrayList;

public class SchoolSystem implements IParams,ISignUp{ //interface

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
		String a = input.replaceAll("\\s+", ""); //去除换页、换行、制表符等
		String b = a.replaceAll("\\[", ""); //去除左括号
		String c = b.replaceAll("\\]", ""); //去除右括号
		String d= c.replaceAll("\\p(Punct}", " "); //标点字符换成空格
		String e=d.replaceAll(" ", "x"); //空格换成x
		String[] s =e.split("x"); //用x分割
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
//报名入学接口
interface ISignUp{
  // 打印输出结果
	public void print();
  // 检查是否有 stuType对应的班级名额
  // 如果没有剩余名额，请返回 false ，否则学生将报名进入该班级并返回 true
	public boolean addStudent (int stuType);
  // 解析命令行输入的参数（格式），如文档描述
	public static IParams parse() throws Exception{
		return null;
	};
}
interface IParams {
  // 获取大班名额
  public int getBig();
  // 获取中班名额
  public int getMedium();
  // 获取小班名额
  public int getSmall();
  // 获取入学序列，例如 [1 2 2 3] 表示依次报名入学一名大班、中班、中班、小班学生
  public ArrayList<Integer> getPlanSignUp ();
}
