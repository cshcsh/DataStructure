package date0826;

import java.util.Stack;

/**
 * ����
 * @author CSH
 * @date 2018��6��25������3:50:28
 */
public class HuiWen {
	
	public static boolean isHuiWen(String string){
		boolean flag=true;
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<string.length();i++){
			stack.push(string.charAt(i));
		}
		for(int i=0;i<string.length();i++){
			if(stack.pop()!=string.charAt(i)){
				flag=false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {

		System.out.println(isHuiWen("313"));
	}

}
