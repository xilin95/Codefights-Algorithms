boolean areFollowingPatterns(String[] strings, String[] patterns) {
    Hashtable<String, String> matchingPairs = new Hashtable<>();
    
    for(int i = 0; i < strings.length; i++) {
        String stringWord = strings[i];
        String patternWord = patterns[i];

        if (matchingPairs.containsKey(patternWord)) {
            if(!stringWord.equals(matchingPairs.get(patternWord))) {
                return false;
            }
        } else if(matchingPairs.containsValue(stringWord)) {
            return false;
        }

        matchingPairs.put(patternWord, stringWord);
    }

    return true;
}
