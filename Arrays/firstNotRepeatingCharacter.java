/* Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.

Example

For s = "abacabad", the output should be
firstNotRepeatingCharacter(s) = 'c'.

There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.

For s = "abacabaabacaba", the output should be
firstNotRepeatingCharacter(s) = '_'.

There are no characters in this string that do not repeat.
*/

char firstNotRepeatingCharacter(String s) {
    int[][] record = new int[26][2];
    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        record[Character.getNumericValue(ch) - Character.getNumericValue('a')][0]++;
        record[Character.getNumericValue(ch) - Character.getNumericValue('a')][1] = i;
    }

    char result = '_';
    Integer index = Integer.MAX_VALUE;

    for (int i = 0; i < record.length; i++) {
        if (record[i][0] == 1) {
            if (record[i][1] < index) {
                index = record[i][1];
                result = s.charAt(index);
            }
        }
    }

    return result;
}
