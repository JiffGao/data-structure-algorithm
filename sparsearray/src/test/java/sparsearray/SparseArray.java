package sparsearray;

import org.junit.Test;

import java.io.*;

/**
 * @author yangyinmei
 * @ClassName: SparseArray
 * @Description:
 * @date: 2019/12/30
 */
public class SparseArray {

    @Test
    public void sparseArrayTest() {
        // 0-表示无子 1-表示黑子  2-表示蓝子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        for (int[] row : chessArr) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        // 将二维数组转为稀疏数组
        // 1. 遍历数组得到非0数据的个数
        int sum = 0;// 记录非0数据的个数
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
        // 2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 遍历二维数组，将非0的值存放到稀疏数组中
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArr[i][0] = i;
                    sparseArr[i][1] = j;
                    sparseArr[i][2] = chessArr[i][j];
                }
            }
        }

        // 序列化稀疏数组到磁盘
        try {
            FileOutputStream outputStream = new FileOutputStream("e:/out");
            // BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < sum + 1; i++) {
                for (int j = 0; j < 3; j++) {
                    stringBuilder.append(sparseArr[i][j]).append('|');
                }
                stringBuilder.append("\r\n");
            }
            outputStream.write(stringBuilder.toString().getBytes("utf-8"));
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 从磁盘读取文件得到稀疏数组
        int[][] sparseArr3 = new int[sum + 1][3];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("e:/out"));
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split("\\|");
                for (int i = 0; i < arr.length; i++) {
                    // System.out.println(arr[i]);
                    sparseArr3[row][i] = Integer.parseInt(arr[i]);
                }
                row++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 得到反序列化的稀疏数组
        System.out.println("反序列化");
        for (int[] row : sparseArr3) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        System.out.println("反序列化结束");
        for (int[] row : sparseArr) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        // 将稀疏数组转为二维数组
        // 1. 先读取稀疏数组第一行得到二维数组的大小
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2.再读取稀疏数组后几行(从第二行开始)并赋给二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        // 恢复后的二维数组
        for (int[] row : chessArr) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
