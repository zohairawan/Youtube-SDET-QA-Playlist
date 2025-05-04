package org.example.testng_demo.annotations.test_level;

public class C2 {

    public static void main(String[] args) {
        //Sample Input: [1, 2, 3, 2, 4, 1] // Expected Output: Duplicate elements: 2 1, Diff: Medium
//        int[] nums = {1, 2, 3, 2, 4, 1};
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++)
//                if (nums[i] == nums[j]) {
//                    System.out.println(nums[i]);
//                }
//        }

        // Sample Input: [5, 8, 2, 9, 1] // Expected Output: // Max: 9 // Min: 1
//        int[] nums = {5, 9, 2, 8, 1};
//        int max = nums[0];
//        int min = nums[0];
//
//        for (int i = 0; i < nums.length; i++) {
//
//            if (nums[i] < min) {
//                min = nums[i];
//            }
//
//            if (nums[i] > max) {
//                max = nums[i];
//            }
//        }
//        System.out.println("Max " + max);
//        System.out.println("Min " + min);
//
//
//        int[] array = {4, 2, 9, 1, 5};
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                System.out.print(" i:" + array[i] + ", j:" + array[j]);
//                if (array[i] > array[j]) {
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
//            }
//            System.out.println();
//        }


        // Check if a String is a palindrome
//        String word = "test";
//        String reverseWord = "";
//
//        // Reverse the String
//        for (int i = word.length()-1; i >= 0; i--) {
//            reverseWord += word.charAt(i);
//        }
//        // Compare if the original and reversed string are the same
//        if (word.equals(reverseWord)) {
//            System.out.println("Is palindrome");
//        } else {
//            System.out.println("Is not a palindrome");
//        }


        // Count the number of vowels in a string
//        String word = "tesadfeofghgfut";
//        int vowelCounter = 0;
//        for (int i = 0; i < word.length(); i++) {
//            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
//                System.out.println(word.charAt(i) + " is a vowel");
//                vowelCounter++;
//            }
//        }
//        System.out.println("Total number of vowels: " + vowelCounter);

        // Remove duplicates from an array
//        int[] nums = {1, 2, 5, 3, 4, 2, 5, 5, 8, 6, 2, 3, 1};
//        List<Integer> numsAl = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            numsAl.add(nums[i]);
//        }
//        System.out.println(numsAl);
//
//        for (int i = 0; i < numsAl.size(); i++) {
//            for (int j = i + 1; j < numsAl.size(); j++) {
//                if (numsAl.get(i).equals(numsAl.get(j))) {
//                    numsAl.remove(j);
//                    j--;
//                }
//            }
//
//        }
//
//        System.out.println(numsAl);

        // Find the second-largest number in an array
        int[] num = {1, 20, 4, 3, 8, 7, 2, 14, 5};
        int max1 = num[0];
        int max2 = num[0];


        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    int temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }
        }

        System.out.println(num[num.length - 2]);
        for (int i : num) {
            System.out.print(i + ",");
        }
    }
}