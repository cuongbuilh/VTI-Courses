package entity;

public class CategoryQuestion {
    private  int castegoryID;
    private String categoryName;

    public CategoryQuestion(){}

    public CategoryQuestion(int castegoryID, String categoryName) {
        this.castegoryID = castegoryID;
        this.categoryName = categoryName;
    }

    public int getCastegoryID() {
        return castegoryID;
    }

    public void setCastegoryID(int castegoryID) {
        this.castegoryID = castegoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "castegoryID=" + castegoryID +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
