package demo;

import java.util.*;


public class TableFootball {

    public static void main(String[] args) {
        int gameCount = 1;
        List<String> names = Arrays.asList(
                "姜博",  "二毛",
                "肖洋",  "郎泽宇"
        );
        Boolean[] lunkong = new Boolean[names.size()];
        Arrays.fill(lunkong, false);


        for (int i = 0; i < gameCount; i++) {
            List<Integer> ranDomRes = getRandomSet(names.size(), names.size());
            // 处理轮空
            int lun = ranDomRes.size() % 4;
            for (int k = 0; k < lun; k++) {
                if (lunkong[ranDomRes.get(k)]) {
                    for (int t = ranDomRes.size() - 1; t > k; t--) {
                        if (!lunkong[ranDomRes.get(t)]) {
                            int temp = ranDomRes.get(t);
                            ranDomRes.set(t, ranDomRes.get(k));
                            ranDomRes.set(k, temp);
                            break;
                        }
                    }
                }
            }

            int size = ranDomRes.size() - 1;
            int count = ranDomRes.size() / 4;
            System.out.println("第" + i + "轮：");
            while (count > 0) {
                int A1 = ranDomRes.get(size);
                int A2 = ranDomRes.get(size - 1);
                int B1 = ranDomRes.get(size - 2);
                int B2 = ranDomRes.get(size - 3);
                System.out.println("[" + names.get(A1) + " " + names.get(A2) + "] vs " + "[" + names.get(B1) + " " + names.get(B2) + "]");

                count--;
                size = size - 4;
            }
            System.out.print("轮空：");
            for (int j = 0; j <= size; j++) {
                int r = ranDomRes.get(j);
                System.out.print(names.get(r) + " ");
                lunkong[r] = true;
                //System.out.print(Arrays.toString(lunkong) + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> getRandomSet(int size, int max){
        Random random = new Random();

        Set<Integer> result = new LinkedHashSet<Integer>();
        while (result.size() < size)
        {
            Integer next = random.nextInt(max);
            result.add(next);
        }
        System.out.println(result);
        return new ArrayList<>(result);
    }

}
