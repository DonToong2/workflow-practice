package org.example;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        for(int i=5; i>0; i++) {
            for(int j=0; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}