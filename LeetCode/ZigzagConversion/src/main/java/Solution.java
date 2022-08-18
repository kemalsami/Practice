import java.util.Arrays;

public class Solution {

    public void print2DArray(String[][] strArr){
        for(int i=0; i<strArr.length; i++){
            System.out.println();
            for(int j=0; j<strArr[i].length; j++){
                if(strArr[i][j]!=null){
                    System.out.print(strArr[i][j]);
                }else{
                    System.out.print(".");
                }

            }
        }
    }

    /**
     * 0123456789012
     * ABCDEFGHIJKLM 4 için sonuç aşağıdaki gibi olmalıdır
     *
     * A _ _ G _ _ M        -> 1. satır için A G M yani index değerleri 0-6-12 (her 6 değer sonrası)
     * B _ F H _ L          -> 2. satır için B F H L yani index değerleri 1-5-7-11 (önce 4 sonra 2 değer sonrası)
     * C E   I K            -> 3. satır için C E I K yani index değerleri 2-4-8-10 (önce 2 sonra 4 değer sonrası)
     * D     J              -> 4. satır için D J yani index değerleri 3-9 (her 6 değer sonrası)
     *
     * Dönen sonuç indexlerine baktığımızda (AGMBFHLCEIKDJ) ilk satır için 6şar 6şar atlarken diğer satırlarda
     * önce 4-2 sonra 2-6 şeklinde indexlerinin arttığı görülmektedir.
     *
     * Diğer bir deyişler,
     *  0. satır için sıçrama değeri "jumpSize" numRows + (numRows-2) olarak görülmektedir
     *  1. satır için sıçrama değeri 2 azalarak önce 4 sonra 2 olmuştur
     *  2. satır için soçrama değeri yine 2 azalarak bu sefer önce 2 sonra 4 olmuştur ve böyle devam etmektedir
     *
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {

        // if size equals 1 then return s
        if(numRows==1)
            return s;

        String result = "";
        int jumpSize = (numRows)+(numRows-2);
        int diff = jumpSize;
        for(int i=0, row=0, pos=0; i<s.length() && row<numRows; i++){

            // check size of the string input
            if(pos>=s.length()){
                row++;
                pos=row;
            }

            // get value
            result += s.charAt(pos);

            // prepare for next loop
            // update diff and find next position on string
            if(row%numRows!=0 && row%numRows!=numRows-1){
                int newDiff = Math.abs((jumpSize-(row*(2))));
                diff = pos == row ? newDiff : Math.abs(diff-jumpSize);
            }else {
                diff = jumpSize;
            }
            pos = pos==row ? row + diff : pos + diff;
        }
        return result;
    }

}
