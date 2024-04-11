public class HashString {

    private final String key;

    public HashString(User usr) {
        this.key= generateKeyStr(usr.get_user_name(), usr.get_user_pwd());
    }

    public String getKey() {
        return key;
    }

    private String generateKeyStr(String uStr, String pStr){
        int swapLen = extractInt(pStr) + 1;

        StringBuilder sb  = new StringBuilder();
        int keepU = 0, keepP = 0;

        // swapping alternate characters
        int flag = 1;
        while(keepU < uStr.length() && keepP < pStr.length()){
            if(flag == 1){
                sb.append(uStr.charAt(keepU++));
            }
            else{
                sb.append(pStr.charAt(keepP++));
            }

            flag *= -1;
        }

        // handling leftovers
        while(keepP < pStr.length()){
            sb.append(pStr.charAt(keepP++));
        }
        while(keepU < uStr.length()){
            sb.append(uStr.charAt(keepU++));
        }

        // swapping substrings
        flag = 1;
        StringBuilder final_sb = new StringBuilder();

        int fast = 0, slow = 0;
        while(fast + swapLen < sb.length()){
            String str = sb.substring(fast, fast + swapLen);

            if(flag == 1){
                final_sb.append(str);
            }
            else{
                final_sb.insert(slow, str);
                slow += 2*swapLen;
            }
            flag *= -1;
            fast += swapLen;
        }

        if(fast < sb.length()){
            final_sb.append(sb.substring(fast, sb.length()));
        }

        return final_sb.toString();
    }

    private int extractInt(String str){
        int result = 0;

        for(char c : str.toCharArray()){
            if(c >= '0' && c <= '9'){
                result = result * 10 + c - '0';
            }
        }

        return result % 10;
    }

}
