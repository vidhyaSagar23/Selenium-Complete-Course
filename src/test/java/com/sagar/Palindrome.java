package com.sagar;

class HelloWorld {
    public static void main(String[] args) {
        String word = "repaperrs";
        int rev = word.length()-1;
        boolean flag = true;
        for(int i=0; i <= word.length()/2; i++){
            if (word.charAt(i) != word.charAt(rev--)){
                flag = false;
                break;
            }
        }

        if (flag){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not palindrome");
        }
    }
}