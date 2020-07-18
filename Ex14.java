 /*****************************************************************
 * class name: Ex14
 * author: Amit Roth
 * last edited: 18.06.2020
 * this class contains static methods only, answers to mmn 14.
 ******************************************************************/
class Ex14 {
    /**
     * Question1 - win.
     * finds for Amir a strategy to avoid losing.
     * prints the progress of the game - the choices of each player and their final scores.
     * Time complexity - O(n). We have in the method 2 loops. the first - in even() and it runs through the whole array.
     * The second - a while loop. and it runs until all the numbers have been picked.
     * Space complexity - O(1). All of the variable decelerations are placed outside the loops.
     * No matter the input's size - we have 7 variable decelerations.
     * @param arr the array game
     */
    public static void win(int[] arr) {
        int tamarTotal = 0;
        int amirTotal = 0;
        int ceilPointer = arr.length - 1;
        int floorPointer = 0;

        boolean even = even(arr);
        while (gameOn(floorPointer, ceilPointer)) {
            //AMIR MOVE//
            if ((even && floorPointer % 2 == 0) || (!even && floorPointer % 2 == 1)) {
                System.out.println("Amir took " + arr[floorPointer]);
                amirTotal += arr[floorPointer++];
            } else {
                System.out.println("Amir took " + arr[ceilPointer]);
                amirTotal += arr[ceilPointer--];
            }

            //TAMAR MOVE//
            if (arr[floorPointer] < arr[ceilPointer]) {
                System.out.println("Tamar took " + arr[ceilPointer]);
                tamarTotal += arr[ceilPointer--];
            } else {
                System.out.println("Tamar took " + arr[floorPointer]);
                tamarTotal += arr[floorPointer++];
            }
        }
        System.out.println("Final Score:");
        System.out.println("Amir Total " + amirTotal);
        System.out.println("Tamar Total " + tamarTotal);
    }


    private static boolean even(int[] arr){
        //Private method for win()
        //runs over the array to tell which strategy prevent losing
        int evenSum = 0;
        int oddSum = 0;

        for(int i = 0; i<=arr.length-1; i++) {
            if (i%2==0)
                evenSum += arr[i];
            else
                oddSum += arr[i];
        }

        if (evenSum>oddSum)
            return true;
        else
            return false;
    }

    private static boolean gameOn(int floorPointer, int ceilPointer){ // if the game ends --> returns False
        //Private method for win.
        return floorPointer<ceilPointer;
    }

    /**
     * Question 2 - findTriplet.
     * finds a triplet of numbers in the given array with the highest product.
     * prints the triplet and returns their product.
     * Time complexity - O(n). Each of the side methods contains 1 or 2 for loops that runs on the whole array(not nested).
     * In the main method (findTriplet()) we have no loops. 9 for loops one after another give you liner complexity.
     * @param arr the array to search for the triplet with the highest product
     * @return the highest product of a triplet in arr
     */
    public static int findTriplet (int [] array)
    {
        int[] arr = array;
        int numOfCells = arr.length;
        int highestIndex = findHighest(arr, numOfCells); //assigns the index of the biggest value in the array
        int big1 = findHighest(arr, numOfCells, highestIndex); //assigns the index of the biggest value in the array(without highestIndex)
        int big2 = findHighest(arr, numOfCells, highestIndex, big1); //assigns the index of the biggest value in the array(without highestIndex and big1)
        int low1 = findLowest(arr, numOfCells, highestIndex); // assigns the index of the smallest value in the array
        int low2 = findLowest(arr, numOfCells, highestIndex, low1); // assigns the index of the smallest value in the array (without low1)

        if (arr[highestIndex]*arr[big1]*arr[big2] > arr[highestIndex]*arr[low1]*arr[low2]) {
            System.out.println(arr[highestIndex] + " " + arr[big1] + " " + arr[big2]); //Prints the triplet.
            return arr[highestIndex] * arr[big1] * arr[big2];
        }
        else
            System.out.println(arr[highestIndex] + " " + arr[low1] + " " + arr[low2]); //Prints the triplet.
        return arr[highestIndex]*arr[low1]*arr[low2];
    }


    // returns the index in the array of the biggest number
    private static int findHighest(int[] arr, int numOfCells)
    {
        int highest = 0;
        for(int i=1; i<numOfCells; i++)
            if( arr[i]>arr[highest])
                highest = i;
        return highest;
    }

    // returns the index in the array (without a certain value) of the biggest number
    private static int findHighest(int[] arr, int numOfCells, int invalidIndex)
    {
        int highest = -7; // Meaningless value in order to initialize highest.
        for(int j=0; j<numOfCells; j++) //Checks for the first valid index
            if(j!=invalidIndex) {
                highest = j;
                break;
            }

        for(int i=highest+1; i<numOfCells; i++)
            if( arr[i]>arr[highest] && i!=invalidIndex)
                highest = i;
        return highest;
    }

    // returns the index in the array (without two values) of the biggest number
    private static int findHighest(int[] arr, int numOfCells, int invalidIndex1, int invalidIndex2)
    {
        int highest = -7; // Meaningless value in order to initialize highest.
        for(int j=0; j<numOfCells; j++) //Checks for the first valid index
            if(j!=invalidIndex1 && j!=invalidIndex2) {
                highest = j;
                break;
            }

        for(int i=1; i<numOfCells; i++)
            if( arr[i]>arr[highest] && i!=invalidIndex1 && i!=invalidIndex2)
                highest = i;
        return highest;
    }


    // returns the index in the array of the lowest number.
    private static int findLowest(int[] arr, int numOfCells, int invalidIndex)
    {
        int lowest = -7; // Meaningless value in order to initialize lowest.
        for(int j=0; j<numOfCells; j++) //Checks for the first valid index
            if(j!=invalidIndex) {
                lowest = j;
                break;
            }

        for(int i=1; i<numOfCells; i++)
            if( arr[i]<arr[lowest] && i!=invalidIndex)
                lowest = i;
        return lowest;
    }

    // returns the index in the array of the lowest number.
    private static int findLowest(int[] arr, int numOfCells, int invalidIndex1, int invalidIndex2)
    {
        int lowest = -7; // Meaningless value in order to initialize lowest.
        for(int j=0; j<numOfCells; j++) //Checks for the first valid index
            if(j!=invalidIndex1 && j!=invalidIndex2) {
                lowest = j;
                break;
            }

        for(int i=1; i<numOfCells; i++)
            if( arr[i]<arr[lowest] && i!=invalidIndex1 && i!=invalidIndex2)
                lowest = i;
        return lowest;
    }


    /**
     * Question3
     * returns the number of times a pattern appears in the String str.
     * @param str the string which the patterns is searched in
     * @param pattern the patterns to search in the string
     * @return the number of times the pattern appears in the string.
     */
    //The signature of the method
    public static int count (String str, String pattern){
        //Starting from the first char in str and from the first char in pattern.
        return count(str, pattern, 0, 0);
    }

    private static int count (String str, String pattern, int i, int j){
        if (str.length()==i || pattern.length()==j)// prevent StringIndexOutOfBoundsException
            return 0;

        //recursive base case
        if(str.charAt(i)==pattern.charAt(j) && pattern.length()-1==j){
            return repetitions(str, pattern.charAt(j), i);
        }

        if(str.charAt(i)==pattern.charAt(j)){
            return count(str, pattern, i+1, j) + count(str, pattern, i+1, j+1);
        }
        return count(str, pattern, i+1, j);
    }

    //how many times char c in str from index i
    private static int repetitions(String str, char c, int i) {
        if (str.length() == i) {
            return 0;
        }
        if (str.charAt(i) == c) {
            return 1 + repetitions(str, c, i + 1);
        }
        return repetitions(str, c, i + 1);
    }

    /**
     * Question4
     * finds the shortest path form the prince to the villain
     * the prince can walk to a roof with the same height/ climb 1/ drop 1/ drop 2
     * if the prince is next to the villain he can jump to his roof no matter what is the height
     * @param drm the digital roof represents the heights, and the villain place.
     * @param i the staring row of the prince
     * @param j the starting column if the prince
     * @return the length of the shortest path from the prince to the villain. -1 if there is no path.
     */
    public static int prince(int[][] drm, int i, int j){
        return prince(drm, i, j, 1, drm[i][j]);
    }

    private static int prince(int[][] drm, int i, int j, int count, int prev){
        if ( i<0 || j<0 || i>= drm.length || j>= drm.length || drm[i][j] == -7 ) // Bounds Check
            return -1;
        if(drm[i][j]==-1) // Base case
            return count;
        int val = drm[i][j];
        if (!(prev +1 == val || prev == val || prev -1 == val || prev -2 == val )) // Legal jump value.
            return -1;

        int temp = drm[i][j];
        drm[i][j] = -7; // To mark slot as traveled.
        int min = minPath(
                prince(drm, i + 1, j, count+1, temp),
                prince(drm, i - 1, j, count+1, temp),
                prince(drm, i, j + 1, count+1, temp),
                prince(drm, i, j - 1, count+1, temp)
        );

        drm[i][j] = temp;
        return min;
    }


    private static int minPath(int a1, int a2, int a3, int a4){
        //returns the min positive value. if all -1 then it returns -1.
        int min = a1;
        if (min<0 || (a2>0 && a2<min))
            min = a2;
        if (min<0 || (a3>0 && a3<min))
            min = a3;
        if (min<0 || (a4>0 && a4<min))
            min = a4;

        return min;
    }
}

