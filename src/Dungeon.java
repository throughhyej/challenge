import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dungeon {

    public void process() {
        Scanner scan = new Scanner(System.in);

        // -------------------------------------------------------- START 데이터 입력
        int monster = scan.nextInt(); // 몬스터 수
        int health = scan.nextInt(); // 기초 체력
        int returnCnt = 0; // 구한 사람

        List<Integer> sortedInteger = new ArrayList<>();
        int[] reduce = new int[monster]; // 마을 당 공격력에 따른 체력 감소
        int[] people = new int[monster]; // 마을 당 사람 수

        for (int i=0; i<monster; i++) {
            int val = scan.nextInt();
            reduce[i] = val;
            sortedInteger.add(val);
        }
        for (int i=0; i<monster; i++) people[i] = scan.nextInt();
        // -------------------------------------------------------- END 데이터 입력

        int movement = 0;
        Collections.sort(sortedInteger); // 공격력 정렬
        for (int i=0; i<sortedInteger.size(); i++) {
            int data = sortedInteger.get(i);
            for (int j=1; j<reduce.length; j++) {
                int reduceData = reduce[j];
                if (data == reduceData) {
                    if (health - (movement + reduceData) > -1) {
                        movement += reduceData;
                        returnCnt += people[j];
                        break;
                    }
                    else break;
                }
            }
        }

        System.out.println("returnCnt = " + returnCnt);
    }

    public static void main(String[] args) {
        new Dungeon().process();
    }
}
