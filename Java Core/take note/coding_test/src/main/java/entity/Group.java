package entity;

import java.util.Date;

public class Group {
    int groupID;
    String groupName;
    int creatorID;
    Date createDate;

    public Group() {
    }

    public Group(int groupID, String groupName, int creatorID, Date createDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }
}
