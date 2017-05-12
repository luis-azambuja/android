package app.com.aula05;

/**
 * Created by sala01 on 12/05/2017.
 */

public class Item {

    int avatarId, imgId;
    String name, local, likes, description;

    public Item(String name) {
        this.name = name;
    }

    public Item(int avatarId, int imgId, String name, String local, String likes, String description) {
        this.avatarId = avatarId;
        this.imgId = imgId;
        this.name = name;
        this.local = local;
        this.likes = likes;
        this.description = description;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
