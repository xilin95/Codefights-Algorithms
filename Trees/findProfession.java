String findProfession(int level, int pos) {
    return findProfessionHelper(level, pos);
}

String findProfessionHelper(int level, int pos) {
    // Base case: level 1 position 1 is always an engineer
    if (level == 1) {
        return "Engineer";
    }

    // If parent is doctor, then the child with odd index is
    // also a doctor and the child at even index is an engineer
    // Need to do (pos + 1) / 2 because otherwise will get the wrong
    // parent
    if (findProfession(level - 1, (pos + 1) / 2) == "Doctor") {
        return pos % 2 == 1? "Doctor" : "Engineer";
    }

    // If parent is engineer, then the child at odd index is
    // also an engineer and the child at even index is a doctor
    return pos % 2 == 1? "Engineer" : "Doctor";
}
