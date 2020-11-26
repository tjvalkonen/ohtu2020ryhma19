package library.domain;

public class PodcastTip implements ReadingTip{

    private String title;
    private String author;
    private String podcastName;
    private String[] tags;
    private String[] relatedCourses;
    private final String type = "podcast";
    
    public PodcastTip(String title) {
        this.title = title;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void SetTitle(String title) {
        this.title = title;
    }

    @Override
    public String[] getTags() {
        return tags;
    }

    @Override
    public String[] getRelatedCourses() {
        return relatedCourses;
    }

    @Override
    public void setMoreInfo1(String author) {
       this.author = author;
    }

    @Override
    public void setMoreInfo2(String podcastName) {
       this.podcastName = podcastName;
    }

    @Override
    public String getMoreInfo1() {
        return author;
    }

    @Override
    public String getMoreInfo2() {
        return this.podcastName;
    }

}
