public class WordDictionary {
    private List<String> words;

    public WordDictionary() {
        this.words = new ArrayList<>();
    }
    public void addWord(String word) {
        this.words.add(word);
    }
    public boolean search(String word) {
        for (String w : this.words) {
            if (match(w, word)) {
                return true;
            }
        }
        return false;
    }
    private boolean match(String w, String word) {
        if (w.length() != word.length()) {
            return false;
        }
        for (int i = 0; i < w.length(); i++) {
            if (word.charAt(i) != '.' && word.charAt(i) != w.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
