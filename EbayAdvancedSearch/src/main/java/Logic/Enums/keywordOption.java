package Logic.Enums;

public enum keywordOption {
    ALL_WORDS_ANY_ORDER("1"),
    ANY_WORDS_ANY_ORDER("2"),
    EXACT_WORDS_EXACT_ORDER("3"),
    EXACT_WORDS_ANY_ORDER("4");
    private final String id;
    keywordOption(String id) {
        this.id=id;
    }
    public String getId(){
        return id;
    }
}
