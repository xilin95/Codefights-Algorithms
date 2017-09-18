String[][] groupingDishes(String[][] dishes) {
    // Key is ingredient, value is dish
    Hashtable<String, ArrayList<String>> ingredientList = new Hashtable<String, ArrayList<String>>();
    for (int i = 0; i < dishes.length; i++) {
        String dish = dishes[i][0];
        for(int j = 1; j < dishes[i].length; j++) {
            String ingredient = dishes[i][j];
            ArrayList<String> list;
            if(!ingredientList.containsKey(ingredient)) {
                list = new ArrayList<String>();
            } else {
                list = ingredientList.get(ingredient);
            }

            list.add(dish);
            ingredientList.put(ingredient, list);
        }

    }

    ArrayList<String[]> result = new ArrayList<>();

    for(String ingredient: ingredientList.keySet()) {
        ArrayList<String> allDishes = ingredientList.get(ingredient);
        // Only interested in ingredients for which there are at least 2 dishes
        if(allDishes.size() > 1) {
            Collections.sort(allDishes);
            // put ingredient at index 0
            allDishes.add(0, ingredient);
            result.add(allDishes.toArray(new String[allDishes.size()]));
        }

    }

    // Sort based on the ingredient at index 0
   Collections.sort(result,(a,b)-> a[0].compareTo(b[0]));

    return result.toArray(new String[result.size()][]);




}
