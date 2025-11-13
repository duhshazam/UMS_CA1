//owned by faculty
class ResearchProfile {
    private java.util.ArrayList<String> publishedPapers;
    private java.util.ArrayList<String> activeResearch;

    public ResearchProfile() {
        this.publishedPapers = new java.util.ArrayList<>();
        this.activeResearch = new java.util.ArrayList<>();
    }

    public void addPaper(String title) {
        publishedPapers.add(title);
    }

    public void addResearch(String topic) {
        activeResearch.add(topic);
    }

    public int getPapersCount() {
        return publishedPapers.size();
    }

    public java.util.ArrayList<String> getPublishedPapers() {
        return publishedPapers;
    }

    public java.util.ArrayList<String> getActiveResearch() {
        return activeResearch;
    }
}
