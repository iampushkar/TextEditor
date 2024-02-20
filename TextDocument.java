class TextDocument {
    StringBuilder contentData = new StringBuilder();

    boolean insertText(String text, int position){
        try {
            contentData.insert(position, text);
            return true;
        }catch (Exception e){
            System.out.println("ERROR!!! " + e.getMessage());
            return false;
        }
    }

    boolean deleteText(int start, int end){
        try {
            contentData.delete(start, end);
            return true;
        }catch (Exception e){
            System.out.println("ERROR!!! " + e.getMessage());
            return false;
        }
    }

    public String getText(){
        return contentData.toString();
    }

    public int getSize(){
        return contentData.length();
    }

    public String getTextByIndex(int start, int end){
        return contentData.substring(start, end);
    }
}
