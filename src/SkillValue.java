import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SkillValue {
    public static String nthCharacter(String s, int n) {
        int l = s.length();
        int i=n;
        StringBuilder sb = new StringBuilder("");
        while(i<l) {
            sb.append(s.charAt(i-1));
            i+=n;
        }
        return sb.toString();
    }

    public static String nthCharacterRepeatdly(String s, int n) {
        final int l = s.length();
        boolean [] val = new boolean[l];
        final char[] chars = s.toCharArray();
        final StringBuilder sb = new StringBuilder("");
        int count =0;
        for (int j = 0; ; j++) {
            if(!val[j%l]) {
                ++count;
                if (count % n == 0) {
                    sb.append(s.charAt(j % l));
                    val[j % l] = true;
                }
            }
            if (sb.length() == l)
                break;
        }
        return sb.toString();
    }

    public static void simpleSieve(int n, List prime) {
        boolean [] num = new boolean[n+1];
        for(int i=2;i<=n;i++) {
            if(!num[i]){
                prime.add(i);
                System.out.println(i);
                for(int j=i*2;j<=n;j+=i) {
                    num[j] = true;
                }
            }
        }
    }
    public static String nthCharacterRepeatdly(String s) {
        final int l = s.length();
        boolean [] val = new boolean[l];
        final char[] chars = s.toCharArray();
        final StringBuilder sb = new StringBuilder("");
        List<Integer> list = new ArrayList<>();
        simpleSieve(100000,list);
        int i=0;
        int n=list.get(i++);
        int count = 0;
        int se = 0;
        int primeTotal = n;
        for (int j = 0; ; j++) {
            se = (primeTotal)%l;
            if(se!=0)
                se =se -1;
            else
                se=l-1;
            if(!val[se]) {
                ++count;
                val[se]=true;
            }
            sb.append(s.charAt(se));
            n=list.get(i++);
            primeTotal+=n;
            if (count == l)
                break;
        }
        return sb.toString();
    }

    public static boolean parenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        Character top;
        for(char c:s.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.empty())
                        return false;
                    top = stack.pop();
                    if(top.charValue()!='(') {
                        return false;
                    }
                    break;
                case '}':
                    if(stack.empty())
                        return false;
                    top = stack.pop();
                    if(top.charValue()!='{') {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.empty())
                        return false;
                    top = stack.pop();
                    if(top.charValue()!='[') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
    public static void main( String[] args ) {
        String st= "HELLO";
        int n=5;
        int l =st.length();
        StringBuilder sb = new StringBuilder("");
        boolean [] val = new boolean[st.length()];
        int i=5;
        System.out.println(nthCharacterRepeatdly(st));
        System.out.println(parenthesis("{[abcd]}(asd)"));
        String sss="HelloWorld.java                public class HelloWorld {                {                	public static void main(String[] args) {                		System.out.println(\"Hello World!\");                	}                }";
        System.out.println(parenthesis(sss));

    }
}
