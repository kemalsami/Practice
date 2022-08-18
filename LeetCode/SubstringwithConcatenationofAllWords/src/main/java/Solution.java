import com.sun.source.tree.UsesTree;

import java.util.*;


public class Solution {


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        HashMap<String,Integer> hs=new HashMap<>();
        for(String i:words){
            hs.put(i,hs.getOrDefault(i,0)+1);
        }
        int n=s.length();
        int len=words[0].length();
        for(int st=0;st<len;st++){
            int l=st;
            int cnt=words.length;
            HashMap<String,Integer> ts=new HashMap<>();
            for(int r=st;r+len<=n;r+=len){
                String cur=s.substring(r,r+len);
                if(hs.getOrDefault(cur,0)>0){
                    if(ts.getOrDefault(cur,0)<hs.getOrDefault(cur,0))
                    {
                        cnt--;
                    }
                    ts.put(cur,ts.getOrDefault(cur,0)+1);
                    if(cnt==0){
                        cur=s.substring(l,l+len);
                        while(ts.getOrDefault(cur,0)>hs.getOrDefault(cur,0)){
                            ts.put(cur,ts.getOrDefault(cur,0)-1);
                            l+=len;
                            cur=s.substring(l,l+len);
                        }
                        ts.put(cur,ts.getOrDefault(cur,0)-1);
                        cnt++;
                        if(len*(words.length-1)+l==r){
                            res.add(l);
                        }
                        l+=len;
                    }
                }else{
                    l=r+len;
                    cnt=words.length;
                    ts.clear();
                }

            }
        }
        return res;
    }

    public HashMap<String, Integer> aa(String[] words){
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for(String word:words){
            if(wordsMap.containsKey(word)){
                wordsMap.replace(word, wordsMap.get(word)+1);
            }else{
                wordsMap.put(word,1);
            }
        }
        return wordsMap;
    }

    public List<Integer> findSubstring_accepted_v2(String s, String[] words) {

        List<Integer> list = new ArrayList<>();
        int chunkSize = words[0].length();

        for(int i=0; i<=s.length()-(words.length*words[0].length()); i++){

            HashMap<String, Integer> map = aa(words);
            for (int j = i; j < i+chunkSize*words.length; j += chunkSize) {
                if(map.containsKey(s.substring(j, Math.min(i+chunkSize*words.length, j + chunkSize)))){

                    if(map.get(s.substring(j, Math.min(i+chunkSize*words.length, j + chunkSize)))==1){
                        map.remove(s.substring(j, Math.min(i+chunkSize*words.length, j + chunkSize)));
                    }else{
                        map.replace(s.substring(j, Math.min(i+chunkSize*words.length, j + chunkSize)) , map.get(s.substring(j, Math.min(i+chunkSize*words.length, j + chunkSize)))-1);
                    }

                }else{
                    break;
                }
            }
            if(map.size()==0)
                list.add(i);

        }

        return list;
    }



    /**
     *
     * Disscuss altında yazılan Sliding windows yöntemi denendi
     *
     * s içerisinde words
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring_accepted_v1(String s, String[] words) {

        List<Integer> list = new ArrayList<>();
        int chunkSize = words[0].length();
        for(int i=0; i<=s.length()-(words.length*words[0].length()); i++){

            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i; j < i+chunkSize*words.length; j += chunkSize) {
                if(map.containsKey(s.substring(j, Math.min(i+chunkSize*words.length, j + chunkSize)))){
                    map.replace(s.substring(j, Math.min(i+chunkSize*words.length, j + chunkSize)) , map.get(s.substring(j, Math.min(i+chunkSize*words.length, j + chunkSize)))+1);
                }else{
                    map.put(s.substring(j, Math.min(i+chunkSize*words.length, j + chunkSize)), 1) ;
                }
            }

            for(String word:words){
                if(map.containsKey(word)){

                    if(map.get(word)==1){
                        map.remove(word);
                    }else{
                        map.replace(word, map.get(word)-1);
                    }

                }else{
                    break;
                }
            }

            if(map.size()==0)
                list.add(i);

        }

        return list;
    }

    /**
     *
     * Time Limit Exceeded
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring_timelimit_v2(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int chunkSize = words[0].length();

        for(int i=0; i<=s.length()-(words.length*words[0].length()); i++){

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s.substring(i, i+words.length*words[0].length()));
            LinkedList<String> linkedList = new LinkedList<>();
            for (int j = 0; j < stringBuilder.length(); j += chunkSize) {
                linkedList.add(stringBuilder.substring(j, Math.min(stringBuilder.length(), j + chunkSize)));
            }

            for(String word:words){
                linkedList.removeFirstOccurrence(word);
            }

            if(linkedList.size()==0)
                list.add(i);

        }

        return list;
    }







    /**
     *
     * Time Limit Exceeded
     *
     * Çalışıyor ancak zamana takılıyor
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring_timelimit_v1(String s, String[] words) {

        StringBuilder wordsString = new StringBuilder();
        for(String w : words){
            wordsString.append(w);
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<s.length(); i++){

            StringBuilder wordsStringTemp = new StringBuilder();
            wordsStringTemp.append(wordsString);
            for(int j=i; j+words[0].length()<=s.length() ; j=j+words[0].length()){

                String tmp = s.substring(j,j+words[0].length());

                /*
                int loc = wordsStringTemp.indexOf(tmp);
                if(loc==-1 || (loc%words[0].length()!=0 && words[0].length()!=1))
                    break;

                wordsStringTemp.delete(loc, loc +  words[0].length());
                 */

                int loc=-1;
                do{
                    loc=wordsStringTemp.indexOf(tmp , loc+1);
                    if(loc==-1)
                        break;

                    if((loc%words[0].length()==0))
                        break;

                }while(true);

                if(loc==-1 || (loc%words[0].length()!=0 && words[0].length()!=1))
                    break;

                wordsStringTemp.delete(loc, loc +  words[0].length());

            }

            if(wordsStringTemp.length()==0)
                result.add(i);

        }
        return result;
    }


    /**
     *
     *
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring_v3(String s, String[] words) {

        List<Integer> list = new ArrayList<>();
        int[] position = new int[words.length];
        int[] times = new int[words.length];
        int[] expectedWordCount = new int[words.length];
        for(int exp=0 ; exp< words.length; exp++){
            expectedWordCount[exp] = (int)Arrays.stream(words).filter(words[exp]::equals).count();
        }

        int returnPosition=-1;
        for(int i=0; i<s.length(); i++){

            int count = 0;
            boolean isCharacterExist = false;
            boolean continueFlag=false;
            Set<String> myset = new HashSet<>();
            for(int j=0 ; j< words.length ; j++){

                if(times[j]==expectedWordCount[j]){
                    count++;
                    continueFlag = true;
                    continue;
                }

                if(s.charAt(i)==words[j].charAt(position[j])){
                    position[j]++;
                    isCharacterExist = true;
                    returnPosition = returnPosition == -1 ? i : returnPosition;
                }

                if(position[j]==words[j].length()){
                    times[j]=times[j]+1;
                    position[j]=0;

                    if(times[j]>expectedWordCount[j]){
                        isCharacterExist = false;
                        break;
                    }

                    // count sadece 1 kere
                    if(!myset.contains(words[j])){
                        myset.add(words[j]);
                        count++;
                    }
                }
            }

            if(!isCharacterExist){
                position = new int[words.length];
                times = new int[words.length];
                if(true || continueFlag){
                    i = returnPosition;
                    returnPosition=-1;
                }
            }

            if(count==words.length){
                position = new int[words.length];
                times = new int[words.length];
                int pos = i+1-(count*words[0].length());
                list.add(pos);
                i = returnPosition;
                returnPosition=-1;
            }

        }

        return list;
    }


    /**
     *
     * Her kelimenin S içerisinde nerelerde olduğuna bakılır ve bir array içerisinde tutulur
     *
     * words = {A , B , C , D , E}
     *
     *      A -> 0, 13, 17, 21
     *      B -> 4, 10,
     *      C -> ...
     *      D -> ...
     *
     * Uzunluğu en kısa olan kelime bulunur (diyelim C olsun). Bunun anlamı sonuc unuzluğu en fazla o olabilir
     *
     * Sonrasında her kelime için bir sonraki değerde bulunup bulunmadığına bakılır
     *  Örn. C 20. indexte ise ve uzunluğu 4 ise A,B,D veya E den biri 20+4 ya da 20-4'te bulunmalıdır
     *
     *
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring_v2(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        List<Set<Integer>> a = new ArrayList<>();
        int wordSize=words!=null&& words.length>0 ? words[0].length() : 0;

        for(String word : words){
            String stemp = s;

            Set<Integer> locations = new HashSet<>();

            while(stemp.indexOf(word)!=-1){
                locations.add(stemp.indexOf(word));
                stemp = stemp.substring(stemp.indexOf(word)+1);
            }

            // Her kelime 1 kez olmak zorunda
            if(locations.size()==0){
                return null;
            }

            a.add(locations);
        }


        // ilk kelime olmak zorunda olduğundan ilk kelimenin durumuna göre diğerleri kontrol edilir
        Set<Integer> locationSet = a.get(0);
        Integer[] x = locationSet.toArray(new Integer[0]);
        for(int loc : x){
            int possibleNext = loc + (wordSize);
            int possiblePrev = loc - (wordSize);
            // diğer kelimelerden birisi possibleNext veya possiblePrev olmak zorunda

            for(int j=1; j<a.size(); j++){
                //if(a.get(j).contains(possibleNext))
            }
        }


        System.out.println("aa");

        return result;
    }


    /**
     *
     * Akla gelen ilk çözüm tüm alternatif kelimeleri oluşturup tek tek lokasyonlarına bakmak olacaktır
     *
     * Her kelimeden 1 kez olması istenilmektedir
     *
     * Bu çözümde n! kadar kelime çıkacağından çözüm uygun gelmemektedir
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring_v1(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        /**
         * A B C D E
         *
         * A B C D E
         * A B C E D
         * A B D C E
         * A B D E C
         * A C B D E
         * A C B E D
         * A C D B E
         * A C D E B
         * A D .
         * A D .
         * A D .
         * ...
         * B
         * C
         * D
         * E
         */

        return result;
    }

}
