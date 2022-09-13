package demo;

import edu.princeton.cs.algs4.In;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class DataDeal {

    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        File file = new File("/Users/wuxinqiang/Downloads/log-ic-search-ic_search_log-1606202578.txt");
        String fileContent = txt2String(file);

        System.out.println(fileContent.contains("headKdtId"));

        Set<Long> kdtList = new HashSet<>();
        char[] targetChars = new char[]{'h', 'e', 'a', 'd', 'K', 'd', 't', 'I', 'd'};
        char[] contents = fileContent.toCharArray();
        for (int i = 0; i < contents.length - 10; i++) {
            int j = 0;
            for (; j < targetChars.length; j++) {
                if (contents[i] != targetChars[j]) {
                    break;
                }
                i++;
            }
            if (j == targetChars.length) {
                StringBuffer stringBuffer = new StringBuffer();
                i++;
                while (contents[i] != ',' && i < contents.length - 10) {
                    stringBuffer.append(contents[i]);
                    i++;
                }
                kdtList.add(Long.parseLong(stringBuffer.toString()));
            }
        }
        System.out.println(kdtList.size());
    }

}
