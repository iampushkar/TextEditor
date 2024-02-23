package src.main.java.service;

public class TextDocument {
    private StringBuilder contentData = new StringBuilder();
    public void insertText(int position, String text){
        contentData.insert(position,text);
    }

    public void deleteText(int start, int end) {
        contentData.delete(start, end);
    }

    public void replaceText(int position, String oldtext, String newText) {
        contentData.replace(position, position + oldtext.length(), newText);

    }

    public String getContext() {
        return contentData.toString();
    }
}
